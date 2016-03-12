package apiparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import brut.apktool.Main;
import brut.common.BrutException;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author ysafaeis
 */
public class Adb {

    private static ProcessBuilder proc;
    private static Process pc;
    private static BufferedReader buf;
    public static ArrayList<String> devicesList = new ArrayList<>();
    public static int decodeProgress;

    public static Map<String, String[]> runAdb(String adbPath, String selectedDevice) {
        Map<String, String[]> sdkParsedInfo = new HashMap<>();
        String seperator;
        if (OsName.isWindows()) {
            seperator = "\\";
        } else {
            seperator = "/";
        }
        String workingdirectory = System.getProperty("user.dir");
        File file = new File(workingdirectory + seperator + "temp");
        file.mkdir();
        String devicePCApksLocation = file.getAbsolutePath();

        try {

            String tmp;
            String[] packageList;

            packageList = new String[]{adbPath, "-s", selectedDevice, "shell", "pm", "list", "packages", "-3", "-f"};
            devicePCApksLocation = devicePCApksLocation.concat(seperator).concat(selectedDevice);

            proc = new ProcessBuilder(packageList);
            pc = proc.start();
            pc.waitFor();
            buf = new BufferedReader(new InputStreamReader(pc.getInputStream()));

            ArrayList<String> packages = new ArrayList<>();
            ArrayList<String> packagesLocations = new ArrayList<>();
            while ((tmp = buf.readLine()) != null) {
                if (tmp.compareTo("") != 0) {
                    String[] files = tmp.split("=");
                    packagesLocations.add(files[0].substring(8));
                    packages.add(files[1]);
                }
            }
            if (!packages.isEmpty()) {
                for (String p : packagesLocations) {

                    proc = new ProcessBuilder(adbPath, "pull", p, devicePCApksLocation);//, outputfile, inputfile);
                    new File(devicePCApksLocation).mkdir();
                    proc.directory(new File(devicePCApksLocation));
                    pc = proc.start();
                    pc.waitFor();
                }

                for (String p : packagesLocations) {

                    String fileLocation = devicePCApksLocation.concat(seperator).concat((p.substring(10)).replace("/", seperator));
                    String output = devicePCApksLocation.concat(seperator).concat((p.substring(10, p.length() - 4)).replace("/", seperator));

                    try {
                        Main.main(new String[]{"d", "-f", fileLocation, "-o", output});
                    } catch (BrutException ex) {
                        Logger.getLogger(Adb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Yaml yaml = new Yaml();
                    String document = output + seperator + "apktool.yml";
                    Reader input = new FileReader(new File(document));
                    Map<String, Object> map = (Map<String, Object>) yaml.load(input);
                    LinkedHashMap sdk = (LinkedHashMap) map.get("sdkInfo");

                    String minSdk = (String) sdk.get("minSdkVersion");
                    String targetSdk = (String) sdk.get("targetSdkVersion");
                    if (targetSdk == null) {
                        targetSdk = minSdk;
                    }
                    sdkParsedInfo.put(p.substring(10, p.length() - 4), new String[]{minSdk, targetSdk});

                }
                if (pc.waitFor() != 0) {

                }
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Adb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sdkParsedInfo;
    }

    public static void setDevices(String adbPath) {

        devicesList.clear();
        String[] devicesCommand = {adbPath, "devices"};
        proc = new ProcessBuilder(devicesCommand);
        try {
            pc = proc.start();
            pc.waitFor();
            buf = new BufferedReader(new InputStreamReader(pc.getInputStream()));
            String tmp;
            while ((tmp = buf.readLine()) != null) {
                if (tmp.compareTo("") != 0 && tmp.split("\t")[0].matches("^[a-zA-Z0-9]{16}$")) {
                    devicesList.add(tmp.split("\t")[0]);
                }
            }
            pc.destroy();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Adb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static final class OsName {

        private static String OS = null;

        public static String getOS() {
            if (OS == null) {
                OS = System.getProperty("os.name").toLowerCase();
            }
            return OS;
        }
        public static boolean isWindows() {
            return getOS().startsWith("windows");
        }

        public static boolean isUnix() {
            return !getOS().startsWith("windows");
        }
    }
}
