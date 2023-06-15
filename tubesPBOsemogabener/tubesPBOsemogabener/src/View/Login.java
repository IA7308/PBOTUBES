package View;

import controller.ControllerApp;
import controller.Listener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Login extends javax.swing.JFrame {

    Listener listener;

    public Login() {
        initComponents();
        //CA = new ControllerApp(this);
        this.setVisible(false);
        KodeAgensi.setVisible(false);
        KodeAgensiLabel.setVisible(false);
        //listener.pilihan();
        //CA.pilihan();
    }
    
    public void setListener(Listener listener) {
        this.listener = listener;
    }
    

    public JToggleButton getAgensi() {
        return Agensi;
    }

    public JButton getButtonLogin() {
        return ButtonRegistrasi;
    }

    public JTextField getKodeAgensi() {
        return KodeAgensi;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JTextField getUsername() {
        return username;
    }

    public JLabel getKodeAgensiLabel() {
        return KodeAgensiLabel;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        ButtonRegistrasi = new javax.swing.JButton();
        Pembeli = new javax.swing.JToggleButton();
        Agensi = new javax.swing.JToggleButton();
        Pegawai = new javax.swing.JToggleButton();
        KodeAgensi = new javax.swing.JTextField();
        KodeAgensiLabel = new javax.swing.JLabel();
        ButtonLogin1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 420));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 420));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\tubesPBO\\src\\Gambar\\Rumah.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 600, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 830));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(370, 333));
        jPanel2.setPreferredSize(new java.awt.Dimension(370, 333));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\tubesPBO\\src\\Gambar\\Icon Username.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 48, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 102, 0));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        username.setToolTipText("");
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 240, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\tubesPBO\\src\\Gambar\\Icon Password.png")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 102, 0));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 240, -1));

        ButtonRegistrasi.setBackground(new java.awt.Color(204, 102, 0));
        ButtonRegistrasi.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRegistrasi.setText("Registrasi");
        ButtonRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegistrasiActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonRegistrasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 110, -1));

        Pembeli.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pembeli);
        Pembeli.setForeground(new java.awt.Color(255, 255, 255));
        Pembeli.setText("Pembeli");
        Pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PembeliActionPerformed(evt);
            }
        });
        jPanel2.add(Pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 90, -1));

        Agensi.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Agensi);
        Agensi.setForeground(new java.awt.Color(255, 255, 255));
        Agensi.setText("Agensi");
        Agensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgensiActionPerformed(evt);
            }
        });
        jPanel2.add(Agensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, -1));

        Pegawai.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(Pegawai);
        Pegawai.setForeground(new java.awt.Color(255, 255, 255));
        Pegawai.setText("Pegawai");
        Pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegawaiActionPerformed(evt);
            }
        });
        jPanel2.add(Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 90, -1));

        KodeAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeAgensiActionPerformed(evt);
            }
        });
        jPanel2.add(KodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 240, -1));

        KodeAgensiLabel.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        KodeAgensiLabel.setForeground(new java.awt.Color(204, 102, 0));
        KodeAgensiLabel.setText("Kode Agensi");
        jPanel2.add(KodeAgensiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        ButtonLogin1.setBackground(new java.awt.Color(204, 102, 0));
        ButtonLogin1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLogin1.setText("Login");
        ButtonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogin1ActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 590, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KodeAgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeAgensiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeAgensiActionPerformed

    private void ButtonRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegistrasiActionPerformed
        //CA.SignIn();
        listener.Regis();
    }//GEN-LAST:event_ButtonRegistrasiActionPerformed

    private void AgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgensiActionPerformed
        //CA.pilihan();
        listener.pilihan();
    }//GEN-LAST:event_AgensiActionPerformed

    private void PegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegawaiActionPerformed
        //CA.pilihan();
        listener.pilihan();
    }//GEN-LAST:event_PegawaiActionPerformed

    private void PembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PembeliActionPerformed
        //CA.pilihan();
        listener.pilihan();
    }//GEN-LAST:event_PembeliActionPerformed

    private void ButtonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogin1ActionPerformed
        listener.SignIn();
    }//GEN-LAST:event_ButtonLogin1ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Agensi;
    private javax.swing.JButton ButtonLogin1;
    private javax.swing.JButton ButtonRegistrasi;
    private javax.swing.JTextField KodeAgensi;
    private javax.swing.JLabel KodeAgensiLabel;
    private javax.swing.JToggleButton Pegawai;
    private javax.swing.JToggleButton Pembeli;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
