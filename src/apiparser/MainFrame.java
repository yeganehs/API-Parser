package apiparser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ysafaeis
 */
public class MainFrame extends javax.swing.JFrame {

    private String AdbPath = "";
    private String selectedDevice = "";

    public MainFrame() {

        initComponents();
       
        PrintStream printStream = new PrintStream(new RedirectOutput(jAreaConsole));
        System.setOut(printStream);
        System.setErr(printStream);
        jComboDevices.setEnabled(false);
        jButtonAnalyze.setEnabled(false);
        jButtonSearch.setEnabled(false);
        jComboDevices.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDevice = (String) jComboDevices.getSelectedItem();

            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboDevices = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePackages = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAreaConsole = new javax.swing.JTextArea();
        jButtonBrowse = new javax.swing.JButton();
        jButtonAnalyze = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelPackagesNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextAdbLocation = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel3.setText("Available Devices");

        jTablePackages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Package Name", "Min Sdk", "Target Sdk"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jScrollPane2.setViewportView(jTablePackages);

        jAreaConsole.setEditable(false);
        jAreaConsole.setColumns(20);
        jAreaConsole.setRows(5);
        jScrollPane1.setViewportView(jAreaConsole);

        jButtonBrowse.setText("Browse");
        jButtonBrowse.setToolTipText("");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jButtonAnalyze.setText("Analyze");
        jButtonAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalyzeActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Number of Packages: ");

        jLabel2.setText("adb Location");

        jButtonSearch.setText("Search Devices");
        jButtonSearch.setToolTipText("");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextAdbLocation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBrowse))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(jButtonSearch))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelPackagesNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextAdbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBrowse)))
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnalyze)
                            .addComponent(jComboDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addComponent(jLabelPackagesNo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            AdbPath = chooser.getSelectedFile().toString();
            jTextAdbLocation.setText(AdbPath);
            jButtonSearch.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jButtonAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalyzeActionPerformed
        Map<String, String[]> sdk = new HashMap<>();
        sdk = Adb.runAdb(AdbPath, selectedDevice);
        Iterator it = sdk.entrySet().iterator();
        DefaultTableModel tableModel = new DefaultTableModel();
        String header[] = new String[]{"Package Name", "Min SDK", "Target SDK"};
        tableModel.setColumnIdentifiers(header);
        if (sdk.isEmpty()) {
            tableModel.addRow(new Object[]{"No Package is Available", "", ""});
        } else {
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                String[] sdkinfo = (String[]) pair.getValue();
                tableModel.addRow(new Object[]{pair.getKey(), sdkinfo[0], sdkinfo[1]});
                it.remove();
            }
        }
        jTablePackages.setModel(tableModel);
        jTablePackages.validate();
        jLabelPackagesNo.setText(Integer.toString(tableModel.getRowCount()));
    }//GEN-LAST:event_jButtonAnalyzeActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        updateDeviceList(AdbPath);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private void updateDeviceList(String adb) {

        Adb.setDevices(AdbPath);
        ArrayList<String> devices = new ArrayList();
        devices = Adb.devicesList;
        jComboDevices.removeAllItems();
        for (String device : devices) {
            jComboDevices.addItem(device);
        }
        jComboDevices.setEnabled(true);

        if (devices.size() > 0) {

            jButtonAnalyze.setEnabled(true);
        } else {

            jComboDevices.addItem("No Devices");
        }
    }

    public class RedirectOutput extends OutputStream {

        private JTextArea consoleTextArea;

        public RedirectOutput(JTextArea consoleTextArea) {
            this.consoleTextArea = consoleTextArea;
        }

        @Override
        public void write(int b) throws IOException {

            consoleTextArea.append(String.valueOf((char) b));
            consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jAreaConsole;
    private javax.swing.JButton jButtonAnalyze;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboDevices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPackagesNo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePackages;
    private javax.swing.JTextField jTextAdbLocation;
    // End of variables declaration//GEN-END:variables
}
