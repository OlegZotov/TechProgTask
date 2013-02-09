package Jform;

import java.io.*;
import javax.swing.JFileChooser;

public class NewJFrame extends javax.swing.JFrame {

    public File selectFile() {
        JFileChooser FileChooserOpen = new JFileChooser("E:\\Programming\\TechProg\\GroupTask");
        int ret = FileChooserOpen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return FileChooserOpen.getSelectedFile();
        }
        return null;
    }

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTextFileName = new javax.swing.JLabel();
        ButtonChooseDictFile = new javax.swing.JButton();
        LabelDictFileName = new javax.swing.JLabel();
        CheckBoxIsReadyTextFile = new javax.swing.JCheckBox();
        CheckBoxIsReadyDictFile = new javax.swing.JCheckBox();
        ButtonChooseTextFile = new javax.swing.JButton();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelTextFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckBoxIsReadyTextFile, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addComponent(ButtonChooseTextFile))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ButtonChooseDictFile)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBoxIsReadyDictFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelDictFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonChooseDictFile)
                    .addComponent(ButtonChooseTextFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTextFileName)
                    .addComponent(LabelDictFileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxIsReadyTextFile)
                    .addComponent(CheckBoxIsReadyDictFile))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonChooseTextFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseTextFileActionPerformed
    }//GEN-LAST:event_ButtonChooseTextFileActionPerformed

    private void ButtonChooseDictFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseDictFileActionPerformed
        File file = selectFile();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }//GEN-LAST:event_ButtonChooseDictFileActionPerformed
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
    private javax.swing.JButton ButtonChooseTextFile;
    private javax.swing.JCheckBox CheckBoxIsReadyDictFile;
    private javax.swing.JCheckBox CheckBoxIsReadyTextFile;
    private javax.swing.JLabel LabelDictFileName;
    private javax.swing.JLabel LabelTextFileName;
    // End of variables declaration//GEN-END:variables
}
