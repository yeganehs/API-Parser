Introduction:

 API_Parser is a program written in Java to extract minimum and target sdk of apps installed on an Android device.
 It searches for Android devices and uses adb tool to get the installed app on the device and copy the .apk files to the <current-directory>/temp/ and runs apktool to get minimum and target sdk from their manifest file.

Requirements:

 1- Java Runtime Environment (JRE) 8
	
 2- adb (Android Debug Bridge)
    Android SDK should be installed on your machine
    adb tool can be found in <android-sdk>/platform-tools/

Installation:

  1- Copy publish\API_Parser.jar to a chosen <directory>

  2- Depending on your OS, do one of the following:

     Windows:
	     Double click on API_Parser.jar
	     or type <directory>\API_Parser.jar from the command line
     Linux:
	     Make the file executable using the following command
             $ chmod +x <directory>/API_Paerser.jar

	     Double click on API_Parser.jar
             or run the file
	     $ ./API_Parser.jar