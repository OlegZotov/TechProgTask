package Jform;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class NewJFrame extends javax.swing.JFrame {

    Set<String> dict = new TreeSet();//{"a", "strong", "kill", ""};

    public File selectFile() {
        JFileChooser FileChooserOpen = new JFileChooser("/home/oleg");
        int ret = FileChooserOpen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return FileChooserOpen.getSelectedFile();
        }
        return null;
    }

    public BufferedReader openFileForRead(File file) {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public BufferedWriter openFileForWrite(File file) {
        try {
            return new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Set<String> readDict(File dictFile) {
        Set<String> dictionary = new TreeSet<String>();
        BufferedReader bufReader;
        if ((bufReader = openFileForRead(dictFile)) != null) {
            String line;
            try {
                while ((line = bufReader.readLine()) != null) {
                    dictionary.add(line);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (bufReader != null) {
                    try {
                        bufReader.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            return dictionary;
        } else {
            return null;
        }
    }

    public String processOneString(String str) {
        StringBuilder res = new StringBuilder(str);
        for (String wordFromDict : dict) {
            if (wordFromDict.length() > str.length()) {
                continue;
            }
            for (int replaceIndex = res.indexOf(wordFromDict, 0); replaceIndex != -1; replaceIndex = res.indexOf(wordFromDict, replaceIndex + 7)) {
                String separators = "!@#$%^&*():;\"\' ,\\./[]{}|-+=";
                int endWordIndex = replaceIndex + wordFromDict.length();
                if (endWordIndex != res.length() && (separators.indexOf(res.charAt(endWordIndex)) == -1)) {
                    continue;
                }
                StringBuilder replacedStr = new StringBuilder(wordFromDict.length() + 7); // 7 = <b></b>.length()
                replacedStr.append("<b>");
                replacedStr.append(wordFromDict);
                replacedStr.append("</b>");
                res.replace(replaceIndex, endWordIndex, replacedStr.toString());
            }
        }
        return res.toString();
    }

    public NewJFrame() {
        initComponents();
        SpinnerModel model = new SpinnerNumberModel(100, //initial value
                100, //min
                10000, //max
                100);
        SpinnerSizeRestriction.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        LabelTextFileName = new javax.swing.JLabel();
        ButtonChooseDictFile = new javax.swing.JButton();
        LabelDictFileName = new javax.swing.JLabel();
        CheckBoxIsReadyTextFile = new javax.swing.JCheckBox();
        CheckBoxIsReadyDictFile = new javax.swing.JCheckBox();
        ButtonChooseTextFile = new javax.swing.JButton();
        ButtonChooseHTMLFile = new javax.swing.JButton();
        SpinnerSizeRestriction = new javax.swing.JSpinner();
        CheckBoxIsReadyHMTLFile = new javax.swing.JCheckBox();
        LabelHTMLFileName = new javax.swing.JLabel();
        CheckBoxIsRestrictOutSize = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelTextFileName.setText("<< имя файла с текстом>>");

        ButtonChooseDictFile.setText("Выбрать файл со словарем");
        ButtonChooseDictFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChooseDictFileActionPerformed(evt);
            }
        });

        LabelDictFileName.setText("<< имя файла со словарем>>");

        CheckBoxIsReadyTextFile.setText("Готовность к обработке");
        CheckBoxIsReadyTextFile.setEnabled(false);

        CheckBoxIsReadyDictFile.setText("Готовность к обработке");
        CheckBoxIsReadyDictFile.setEnabled(false);

        ButtonChooseTextFile.setText("Выбрать файл с текстом");
        ButtonChooseTextFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChooseTextFileActionPerformed(evt);
            }
        });

        ButtonChooseHTMLFile.setText("Выбрать выходной файл");
        ButtonChooseHTMLFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChooseHTMLFileActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CheckBoxIsRestrictOutSize, org.jdesktop.beansbinding.ELProperty.create("${selected}"), SpinnerSizeRestriction, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        CheckBoxIsReadyHMTLFile.setText("Готовность к обработке");
        CheckBoxIsReadyHMTLFile.setEnabled(false);

        LabelHTMLFileName.setText("<< имя выходного файла>>");

        CheckBoxIsRestrictOutSize.setText("Ограничить размер выходного файла");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelTextFileName)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheckBoxIsReadyDictFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelDictFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheckBoxIsReadyTextFile, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonChooseTextFile))
                                .addGap(18, 18, 18)
                                .addComponent(ButtonChooseDictFile))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CheckBoxIsRestrictOutSize, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpinnerSizeRestriction)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CheckBoxIsReadyHMTLFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonChooseHTMLFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelHTMLFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonChooseHTMLFile)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonChooseDictFile)
                            .addComponent(ButtonChooseTextFile))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelTextFileName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CheckBoxIsReadyTextFile))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelDictFileName)
                                    .addComponent(LabelHTMLFileName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CheckBoxIsReadyDictFile)
                                    .addComponent(CheckBoxIsReadyHMTLFile))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxIsRestrictOutSize)
                    .addComponent(SpinnerSizeRestriction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonChooseTextFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseTextFileActionPerformed
    }//GEN-LAST:event_ButtonChooseTextFileActionPerformed

    private void ButtonChooseDictFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseDictFileActionPerformed
        File dictFile;
        if ((dictFile = selectFile()) != null) {
            if ((dict = readDict(dictFile)) != null) {
                LabelDictFileName.setText(dictFile.getName());
                CheckBoxIsReadyDictFile.setSelected(true);
            }
        }
    }//GEN-LAST:event_ButtonChooseDictFileActionPerformed

    private void ButtonChooseHTMLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseHTMLFileActionPerformed

    }//GEN-LAST:event_ButtonChooseHTMLFileActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;




                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonChooseDictFile;
    private javax.swing.JButton ButtonChooseHTMLFile;
    private javax.swing.JButton ButtonChooseTextFile;
    private javax.swing.JCheckBox CheckBoxIsReadyDictFile;
    private javax.swing.JCheckBox CheckBoxIsReadyHMTLFile;
    private javax.swing.JCheckBox CheckBoxIsReadyTextFile;
    private javax.swing.JCheckBox CheckBoxIsRestrictOutSize;
    private javax.swing.JLabel LabelDictFileName;
    private javax.swing.JLabel LabelHTMLFileName;
    private javax.swing.JLabel LabelTextFileName;
    private javax.swing.JSpinner SpinnerSizeRestriction;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
