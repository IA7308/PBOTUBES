package View;

import controller.ControllerApp;
import controller.Listener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Landing extends javax.swing.JFrame {

    //ControllerApp CA;
    Listener listener;
    
    public Landing() {
        initComponents();
        //CA = new ControllerApp(this);
        //CA.PilihanBox();
        getLabelRegistrasiPegawai().setVisible(false);
        getKodeAgensi().setVisible(false);
        getEmail().setVisible(false);
        getNomorhp().setVisible(false);
        getUsername().setVisible(true);
        getPassword().setVisible(true);
        getSignup1().setVisible(false);
        getLabelEmail().setVisible(false);
        getLabelKodeAgensi().setVisible(false);
        getLabelNomorHp().setVisible(false);
    }

    public JLabel getLabelRegistrasiPegawai() {
        return labelRegistrasiPegawai;
    }
    

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public JLabel getLabelEmail() {
        return LabelEmail;
    }

    public JLabel getLabelKodeAgensi() {
        return LabelKodeAgensi;
    }

    public JLabel getLabelNomorHp() {
        return LabelNomorHp;
    }

    public JLabel getLabelPassword() {
        return LabelPassword;
    }

    public JLabel getLabelUsername() {
        return LabelUsername;
    }
    

    public JToggleButton getAgensi() {
        return Agensi;
    }

    public JTextField getEmail() {
        return Email;
    }

    public JToggleButton getPegawai() {
        return Pegawai;
    }

    public JToggleButton getPembeli() {
        return Pembeli;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public JTextField getKodeAgensi() {
        return KodeAgensi;
    }

    public JInternalFrame getjInternalFrame1() {
        return jInternalFrame1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JTextField getNomorhp() {
        return nomorhp;
    }

    public JTextField getPassword() {
        return password;
    }

    public JButton getSignup() {
        return Login;
    }

    public JTextField getUsername() {
        return username;
    }

    public JButton getLogin() {
        return Login;
    }

    public JButton getSignup1() {
        return signup1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelRegistrasiPegawai = new javax.swing.JLabel();
        Pegawai = new javax.swing.JToggleButton();
        Pembeli = new javax.swing.JToggleButton();
        Agensi = new javax.swing.JToggleButton();
        Email = new javax.swing.JTextField();
        KodeAgensi = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        nomorhp = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        signup1 = new javax.swing.JButton();
        LabelUsername = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        LabelNomorHp = new javax.swing.JLabel();
        LabelKodeAgensi = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\tubesPBO\\src\\Gambar\\Rumah.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 600, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 830));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegistrasiPegawai.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        labelRegistrasiPegawai.setForeground(new java.awt.Color(204, 102, 0));
        labelRegistrasiPegawai.setText("Silahkan pilih menu login untuk pegawai");
        jPanel2.add(labelRegistrasiPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        Pegawai.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pegawai);
        Pegawai.setForeground(new java.awt.Color(255, 255, 255));
        Pegawai.setText("Pegawai");
        Pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegawaiActionPerformed(evt);
            }
        });
        jPanel2.add(Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 90, -1));

        Pembeli.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pembeli);
        Pembeli.setForeground(new java.awt.Color(255, 255, 255));
        Pembeli.setText("Pembeli");
        Pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PembeliActionPerformed(evt);
            }
        });
        jPanel2.add(Pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 90, -1));

        Agensi.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Agensi);
        Agensi.setForeground(new java.awt.Color(255, 255, 255));
        Agensi.setText("Agensi");
        Agensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgensiActionPerformed(evt);
            }
        });
        jPanel2.add(Agensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, -1));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel2.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 200, -1));

        KodeAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeAgensiActionPerformed(evt);
            }
        });
        jPanel2.add(KodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 200, -1));

        nomorhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorhpActionPerformed(evt);
            }
        });
        jPanel2.add(nomorhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, -1));

        Login.setBackground(new java.awt.Color(204, 102, 0));
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 90, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("Registrasi Akun, ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 200, -1));

        signup1.setBackground(new java.awt.Color(204, 102, 0));
        signup1.setForeground(new java.awt.Color(255, 255, 255));
        signup1.setText("Sign Up");
        signup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup1ActionPerformed(evt);
            }
        });
        jPanel2.add(signup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 90, -1));

        LabelUsername.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        LabelUsername.setForeground(new java.awt.Color(204, 102, 0));
        LabelUsername.setText("Username :");
        jPanel2.add(LabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        LabelEmail.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        LabelEmail.setForeground(new java.awt.Color(204, 102, 0));
        LabelEmail.setText("Email :");
        jPanel2.add(LabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        LabelPassword.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        LabelPassword.setForeground(new java.awt.Color(204, 102, 0));
        LabelPassword.setText("Password");
        jPanel2.add(LabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        LabelNomorHp.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        LabelNomorHp.setForeground(new java.awt.Color(204, 102, 0));
        LabelNomorHp.setText("Nomor Handphone :");
        jPanel2.add(LabelNomorHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        LabelKodeAgensi.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        LabelKodeAgensi.setForeground(new java.awt.Color(204, 102, 0));
        LabelKodeAgensi.setText("Kode Agensi :");
        jPanel2.add(LabelKodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 590, 830));

        setSize(new java.awt.Dimension(1314, 835));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegawaiActionPerformed
        //CA.PilihanBox();
        listener.PilihanBox();
    }//GEN-LAST:event_PegawaiActionPerformed

    private void PembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PembeliActionPerformed
        //CA.PilihanBox();
        listener.PilihanBox();
    }//GEN-LAST:event_PembeliActionPerformed

    private void AgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgensiActionPerformed
       // CA.PilihanBox();
       listener.PilihanBox();
    }//GEN-LAST:event_AgensiActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void KodeAgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeAgensiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeAgensiActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void nomorhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorhpActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        listener.Login();
    }//GEN-LAST:event_LoginActionPerformed

    private void signup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup1ActionPerformed
        listener.SignUp();
    }//GEN-LAST:event_signup1ActionPerformed

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
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Landing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Agensi;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField KodeAgensi;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelKodeAgensi;
    private javax.swing.JLabel LabelNomorHp;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JButton Login;
    private javax.swing.JToggleButton Pegawai;
    private javax.swing.JToggleButton Pembeli;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelRegistrasiPegawai;
    private javax.swing.JTextField nomorhp;
    private javax.swing.JTextField password;
    private javax.swing.JButton signup1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
