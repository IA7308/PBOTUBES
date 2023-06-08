package View;

import controller.ControllerApp;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Landing extends javax.swing.JFrame {

    ControllerApp CA;
    
    public Landing() {
        initComponents();
        CA = new ControllerApp(this);
        CA.PilihanBox();
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
        return signup;
    }

    public JTextField getUsername() {
        return username;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Pegawai = new javax.swing.JToggleButton();
        Pembeli = new javax.swing.JToggleButton();
        Agensi = new javax.swing.JToggleButton();
        Email = new javax.swing.JTextField();
        KodeAgensi = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        nomorhp = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Rumah.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 600, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 530));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pegawai.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pegawai);
        Pegawai.setForeground(new java.awt.Color(255, 255, 255));
        Pegawai.setText("Pegawai");
        Pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegawaiActionPerformed(evt);
            }
        });
        jPanel2.add(Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 90, -1));

        Pembeli.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pembeli);
        Pembeli.setForeground(new java.awt.Color(255, 255, 255));
        Pembeli.setText("Pembeli");
        Pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PembeliActionPerformed(evt);
            }
        });
        jPanel2.add(Pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 90, -1));

        Agensi.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Agensi);
        Agensi.setForeground(new java.awt.Color(255, 255, 255));
        Agensi.setText("Agensi");
        Agensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgensiActionPerformed(evt);
            }
        });
        jPanel2.add(Agensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, -1));

        Email.setForeground(new java.awt.Color(204, 204, 204));
        Email.setText("Email");
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel2.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, -1));

        KodeAgensi.setForeground(new java.awt.Color(204, 204, 204));
        KodeAgensi.setText("Kode Agensi");
        KodeAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeAgensiActionPerformed(evt);
            }
        });
        jPanel2.add(KodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 170, -1));

        password.setForeground(new java.awt.Color(204, 204, 204));
        password.setText("password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 170, -1));

        nomorhp.setForeground(new java.awt.Color(204, 204, 204));
        nomorhp.setText("nomor handphone");
        nomorhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorhpActionPerformed(evt);
            }
        });
        jPanel2.add(nomorhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 170, -1));

        signup.setBackground(new java.awt.Color(204, 102, 0));
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Sign Up");
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("Registrasi Akun, ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        username.setForeground(new java.awt.Color(204, 204, 204));
        username.setText("username");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 380, 530));

        setSize(new java.awt.Dimension(842, 535));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegawaiActionPerformed
        CA.PilihanBox();
    }//GEN-LAST:event_PegawaiActionPerformed

    private void PembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PembeliActionPerformed
        CA.PilihanBox();
    }//GEN-LAST:event_PembeliActionPerformed

    private void AgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgensiActionPerformed
        CA.PilihanBox();
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
    private javax.swing.JToggleButton Pegawai;
    private javax.swing.JToggleButton Pembeli;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomorhp;
    private javax.swing.JTextField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
