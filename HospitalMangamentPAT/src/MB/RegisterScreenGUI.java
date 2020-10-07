/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import javax.swing.JOptionPane;

/**
 *
 * @author Bhyatmua
 */
public class RegisterScreenGUI extends javax.swing.JFrame {

    /**
     * Creates new form RegisterScreenGUI
     */
    public RegisterScreenGUI() {
        initComponents();
    }
    PassGen reg = new PassGen();
    String regCode = reg.makeCode();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recCode = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        recCodeText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        useName = new javax.swing.JLabel();
        Pass = new javax.swing.JLabel();
        confirmPass = new javax.swing.JLabel();
        registerbtn = new javax.swing.JButton();
        passTxt = new javax.swing.JPasswordField();
        passConTxt = new javax.swing.JPasswordField();
        userTxt = new javax.swing.JTextField();
        btnHelp = new javax.swing.JButton();
        errTxt = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RECOVERY CODE!!!");

        recCodeText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        recCodeText.setForeground(new java.awt.Color(187, 0, 0));
        recCodeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("This is Your Recovery Code, Keep It Safe To Recover Your Account");

        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Copy To Clipboard");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout recCodeLayout = new javax.swing.GroupLayout(recCode.getContentPane());
        recCode.getContentPane().setLayout(recCodeLayout);
        recCodeLayout.setHorizontalGroup(
            recCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        recCodeLayout.setVerticalGroup(
            recCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(null);

        title.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Register New User");
        jPanel1.add(title);
        title.setBounds(0, 10, 500, 50);

        useName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        useName.setForeground(new java.awt.Color(255, 255, 255));
        useName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        useName.setText("UserName:");
        useName.setAlignmentY(0.0F);
        jPanel1.add(useName);
        useName.setBounds(100, 80, 81, 22);

        Pass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Pass.setForeground(new java.awt.Color(255, 255, 255));
        Pass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Pass.setText("Password:");
        Pass.setAlignmentY(0.0F);
        jPanel1.add(Pass);
        Pass.setBounds(110, 130, 74, 20);

        confirmPass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        confirmPass.setForeground(new java.awt.Color(255, 255, 255));
        confirmPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        confirmPass.setText("Confirm Password:");
        confirmPass.setAlignmentY(0.0F);
        jPanel1.add(confirmPass);
        confirmPass.setBounds(50, 170, 139, 22);

        registerbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        registerbtn.setText("Register");
        registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbtnActionPerformed(evt);
            }
        });
        jPanel1.add(registerbtn);
        registerbtn.setBounds(200, 230, 150, 33);

        passTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(passTxt);
        passTxt.setBounds(200, 120, 150, 30);

        passConTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(passConTxt);
        passConTxt.setBounds(200, 170, 150, 30);

        userTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userTxt);
        userTxt.setBounds(200, 70, 150, 30);

        btnHelp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jPanel1.add(btnHelp);
        btnHelp.setBounds(200, 280, 150, 33);

        errTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        errTxt.setForeground(new java.awt.Color(255, 51, 51));
        errTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(errTxt);
        errTxt.setBounds(10, 330, 450, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void registerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbtnActionPerformed
        String temp = "";
        PatientManager pm = new PatientManager(userTxt.getText());
        Hasher h = new Hasher();
        MasterValidator mv = new MasterValidator();
        if (passTxt.getText().isEmpty() || passConTxt.getText().isEmpty() || userTxt.getText().isEmpty()) {
            temp += "Make Sure all fields are filled in\n";
        }
        if (!(passTxt.getText().equals(passConTxt))) {
            temp += "Passwords must match\n";
        }
        if (mv.isStringTooShort(passTxt.getText(), 8)) {
            temp += "Passord is too short\n";
        }
        if (mv.isStringTooShort(userTxt.getText(), 8) || mv.isStringTooLong(userTxt.getText(), 15)) {
            temp += "Username must be between 8-15 chracters";
        }
        if (!pm.logExixts(userTxt.getText())) {
            try {
                String username = userTxt.getText();

                pm.updateTbl("INSERT INTO tblPatientsPersonalInfo (PatUsername, Passwordhash, RecoveryCodehash) VALUES('" + username + "','"
                        + h.toHexString(h.getSHA(passTxt.getText())) + "', '" + h.toHexString(h.getSHA(regCode)) + "');");
                pm.updateTbl("INSERT INTO tblPatientHealth (PatUsername) VALUES('" + username + "');");
                recCode.setVisible(true);
                recCode.setSize(500, 400);
                recCodeText.setText(regCode);
            } catch (SQLException ex) {
                System.out.println("Error with Insert Statment");
                System.out.println(ex);
            }

        } else {
            temp += "Username is already taken";

            passTxt.setText("");
            passConTxt.setText("");

        }
        if (!temp.isEmpty()) {
            JOptionPane.showMessageDialog(null, temp);
        }
    }//GEN-LAST:event_registerbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EditGUI lo = new EditGUI(userTxt.getText());
        recCode.dispose();
        this.dispose();
        lo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StringSelection stringSelection = new StringSelection(regCode);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        HelpScreenUi hs = new HelpScreenUi();
        hs.setVisible(true);
        hs.setFocusable(true);

    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegisterScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreenGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pass;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel confirmPass;
    private javax.swing.JLabel errTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passConTxt;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JDialog recCode;
    private javax.swing.JLabel recCodeText;
    private javax.swing.JButton registerbtn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel useName;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
