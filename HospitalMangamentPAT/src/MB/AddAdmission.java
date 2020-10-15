/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muaaz Bhyat
 */
public class AddAdmission extends javax.swing.JFrame {

    /**
     * Creates new form AddAdmission
     */
    public AddAdmission() {
        initComponents();

    }

    public AddAdmission(String user) {
        initComponents();
        this.user = user;
    }

    private String hosList;

    private String user;

    private void hosRef() {
        PatientManager pm = new PatientManager(user);
        HosRefDialog.setSize(500, 250);
        HosRefDialog.setVisible(true);
        hosTxtArea.setText(pm.getHos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HosRefDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        hosTxtArea = new javax.swing.JTextArea();
        closeBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        WardTxt = new javax.swing.JTextField();
        DateInTxt = new javax.swing.JTextField();
        DateOutTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HosIdChoice = new javax.swing.JComboBox<>();
        HopitalRef = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        hosTxtArea.setColumns(20);
        hosTxtArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        hosTxtArea.setRows(5);
        jScrollPane1.setViewportView(hosTxtArea);

        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HosRefDialogLayout = new javax.swing.GroupLayout(HosRefDialog.getContentPane());
        HosRefDialog.getContentPane().setLayout(HosRefDialogLayout);
        HosRefDialogLayout.setHorizontalGroup(
            HosRefDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(HosRefDialogLayout.createSequentialGroup()
                .addComponent(closeBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        HosRefDialogLayout.setVerticalGroup(
            HosRefDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HosRefDialogLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeBtn)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(null);

        WardTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WardTxtActionPerformed(evt);
            }
        });
        jPanel1.add(WardTxt);
        WardTxt.setBounds(182, 96, 100, 25);

        DateInTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateInTxtActionPerformed(evt);
            }
        });
        jPanel1.add(DateInTxt);
        DateInTxt.setBounds(182, 130, 100, 25);

        DateOutTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOutTxtActionPerformed(evt);
            }
        });
        jPanel1.add(DateOutTxt);
        DateOutTxt.setBounds(303, 130, 100, 25);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add An Admission:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 11, 189, 30);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("/");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(292, 127, 7, 25);

        HosIdChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", " " }));
        jPanel1.add(HosIdChoice);
        HosIdChoice.setBounds(182, 68, 31, 20);

        HopitalRef.setBackground(new java.awt.Color(255, 255, 255));
        HopitalRef.setText("Hospital ID Refrence");
        HopitalRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HopitalRefActionPerformed(evt);
            }
        });
        jPanel1.add(HopitalRef);
        HopitalRef.setBounds(223, 67, 131, 23);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hospital ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(23, 71, 52, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ward");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(23, 101, 26, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date In/Date Out");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(23, 135, 84, 14);

        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddBtn);
        AddBtn.setBounds(182, 166, 79, 23);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("(YYYY/MM/DD)");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(407, 135, 70, 14);

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 166, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WardTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WardTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WardTxtActionPerformed

    private void DateInTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateInTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateInTxtActionPerformed

    private void DateOutTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOutTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateOutTxtActionPerformed

    private void HopitalRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HopitalRefActionPerformed
        this.hosRef();
    }//GEN-LAST:event_HopitalRefActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        HosRefDialog.setVisible(false);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        MasterValidator mv = new MasterValidator();
        int hosID = Integer.parseInt((String)HosIdChoice.getSelectedItem());
        String ward = WardTxt.getText();
        String dIn = DateInTxt.getText();
        String dOut = DateOutTxt.getText();
        if (mv.dateCheck(dIn, dOut)) {
            PatientManager pm = new PatientManager(this.user);
            try {
                pm.updateTbl(String.format("INSERT INTO tblAdmissions (AdmissionID, PatientUser, Ward, DateIn, DateOut) VALUES(%s,'%s','%s',#%s#,#%s#,%s)", pm.getAdLast(), this.user, ward, dIn, dOut, hosID));
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(AddAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please make sure the date is entered correctly and in the right format");
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAdmission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField DateInTxt;
    private javax.swing.JTextField DateOutTxt;
    private javax.swing.JButton HopitalRef;
    private javax.swing.JComboBox<String> HosIdChoice;
    private javax.swing.JDialog HosRefDialog;
    private javax.swing.JTextField WardTxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextArea hosTxtArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
