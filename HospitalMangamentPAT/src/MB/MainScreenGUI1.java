/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import static MB.MainScreenGUI.username;
import java.util.Scanner;

/**
 *
 * @author Bhyatmua
 */
public class MainScreenGUI1 extends javax.swing.JFrame {
    //fileds
    static String username;
    static int authLvl;
    
    /**
     * Creates new form NewJFrame
     */
    public MainScreenGUI1() {
        initComponents();
        
    }
    public MainScreenGUI1(String user, int auth) {
        initComponents();
        username = user;
        PatientManager pm = new PatientManager(username);
        Scanner sc = new Scanner(pm.getInfo(username, auth)).useDelimiter(";");
        System.out.println(sc.next() + "oop if only");
        System.out.println(pm.getInfo(user, auth));
        authLvl = auth;
        this.doStuff(sc);
        
        
    }
    private void doStuff(Scanner sc){
        this.namelbl1.setText("UserName : " + " Desperate");
        this.fullNamelbl2.setText("Full Name: " + sc.next());
        this.bloodTypelbl2.setText("Blood Type: " + sc.next());
        this.allergenslbl3.setText("Allergens: " + sc.next());
        this.phoneNotxt.setText("Phone No: " + sc.next());
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namelbl = new javax.swing.JLabel();
        logoutbtn = new javax.swing.JButton();
        fullNamelbl2 = new javax.swing.JLabel();
        bloodTypelbl2 = new javax.swing.JLabel();
        allergenslbl3 = new javax.swing.JLabel();
        logoutbtn1 = new javax.swing.JButton();
        phoneNotxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));

        namelbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        namelbl.setForeground(new java.awt.Color(255, 255, 255));
        namelbl.setText("UserName:");

        logoutbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        fullNamelbl2.setBackground(new java.awt.Color(255, 255, 255));
        fullNamelbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fullNamelbl2.setForeground(new java.awt.Color(255, 255, 255));
        fullNamelbl2.setText("Full Name:");

        bloodTypelbl2.setBackground(new java.awt.Color(255, 255, 255));
        bloodTypelbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bloodTypelbl2.setForeground(new java.awt.Color(255, 255, 255));
        bloodTypelbl2.setText("Blood type:");

        allergenslbl3.setBackground(new java.awt.Color(255, 255, 255));
        allergenslbl3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        allergenslbl3.setForeground(new java.awt.Color(255, 255, 255));
        allergenslbl3.setText("Allergens:");

        logoutbtn1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        logoutbtn1.setText("Help");
        logoutbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtn1ActionPerformed(evt);
            }
        });

        phoneNotxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phoneNotxt.setForeground(new java.awt.Color(255, 255, 255));
        phoneNotxt.setText("Phone No:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logoutbtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutbtn))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bloodTypelbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allergenslbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(namelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullNamelbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneNotxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullNamelbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bloodTypelbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allergenslbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutbtn)
                    .addComponent(logoutbtn1)))
        );

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

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        LoginGui lo = new LoginGui();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void logoutbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtn1ActionPerformed
        HelpScreenUi hs = new HelpScreenUi();
        hs.setVisible(true);
        hs.setFocusable(true);
    }//GEN-LAST:event_logoutbtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenGUI1().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allergenslbl;
    private javax.swing.JLabel allergenslbl3;
    private javax.swing.JLabel bloodTypelbl;
    private javax.swing.JLabel bloodTypelbl2;
    private javax.swing.JLabel fullNamelbl;
    private javax.swing.JLabel fullNamelbl2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JButton logoutbtn1;
    private javax.swing.JButton logoutbtn2;
    private javax.swing.JButton logoutbtn3;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel namelbl1;
    private javax.swing.JLabel phoneNotxt;
    // End of variables declaration//GEN-END:variables
}
