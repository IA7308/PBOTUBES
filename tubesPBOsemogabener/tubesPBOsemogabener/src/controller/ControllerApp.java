package controller;

import DataAccessObject.*;
import Model.*;
import View.Landing;
import View.Login;
import java.util.List;
import javax.swing.JOptionPane;
import View.DashboardAdmin;
import View.DashboardAgency;
import View.DashboardPembeli;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;


public class ControllerApp implements Listener {

    List<Pegawai> listPegawai;
    List<Agensi> listAgen;
    List<Pembeli> listBuyer;
    List<DataRumah> listRumah;
    List<DataRumah> listRumahPengajuan;
    List<String> KodeAgensi;
    List<String> NamaAgensi;
    List<Form> listForm;
    List<WaktuTersediaForm> listWaktuJanjian;
    Landing frameRegis;
    Login frameLogin;
    DashboardAdmin frameAdmin;
    DashboardAgency frameAgen;
    DashboardPembeli framePembeli;
    iAgensiDao agenDao;
    iPegawaiDao pegawaiDao;
    iPembeliDao pembeliDao;
    

    public ControllerApp(Landing frame) {
        this.frameRegis = frame;
        this.agenDao = new AgensiDao();
        this.pegawaiDao = new PegawaiDao();
        this.pembeliDao = new PembeliDao();
        listPegawai = pegawaiDao.getAllPegawai();
        listAgen = agenDao.getAllAgensi();
        listBuyer = pembeliDao.getAllPembeli();
    }

    public ControllerApp(Login login) {
        this.frameLogin = login;
        this.agenDao = new AgensiDao();
        
        this.pegawaiDao = new PegawaiDao();
        this.pembeliDao = new PembeliDao();
        listPegawai = pegawaiDao.getAllPegawai();
        listAgen = agenDao.getAllAgensi();
        listBuyer = pembeliDao.getAllPembeli();
        
    }

    public ControllerApp() {
        this.frameRegis = new Landing();
        this.frameLogin = new Login();
        this.frameAdmin = new DashboardAdmin();
        this.frameAgen = new DashboardAgency();
        this.framePembeli = new DashboardPembeli();
        this.agenDao = new AgensiDao();
        this.pegawaiDao = new PegawaiDao();
        this.pembeliDao = new PembeliDao();
        listPegawai = pegawaiDao.getAllPegawai();
        listAgen = agenDao.getAllAgensi();
        listBuyer = pembeliDao.getAllPembeli();
        listForm = pegawaiDao.getAllForm();
        listWaktuJanjian = pegawaiDao.getAllWaktuJanjian();
        KodeAgensi = pegawaiDao.getAllKodeAgensi();
        NamaAgensi = pegawaiDao.getAllNamaAgensi();
    }

    @Override
    public void PilihanBox() {
        this.frameRegis.getKodeAgensi().setVisible(false);
        this.frameRegis.getEmail().setVisible(false);
        this.frameRegis.getNomorhp().setVisible(false);
        this.frameRegis.getUsername().setVisible(true);
        this.frameRegis.getPassword().setVisible(true);
        this.frameRegis.getSignup1().setVisible(false);
        this.frameRegis.getLabelRegistrasiPegawai().setVisible(false);
        this.frameRegis.getLabelEmail().setVisible(false);
        this.frameRegis.getLabelKodeAgensi().setVisible(false);
        this.frameRegis.getLabelNomorHp().setVisible(false);

        if (this.frameRegis.getAgensi().isSelected()) {
            this.frameRegis.getKodeAgensi().setVisible(true);
            this.frameRegis.getEmail().setVisible(false);
            this.frameRegis.getSignup1().setVisible(true);
            this.frameRegis.getNomorhp().setVisible(false);
            this.frameRegis.getLabelEmail().setVisible(false);
            this.frameRegis.getLabelKodeAgensi().setVisible(true);
            this.frameRegis.getLabelNomorHp().setVisible(false);
            this.frameRegis.getLabelUsername().setVisible(true);
            this.frameRegis.getLabelPassword().setVisible(true);
        } else if (this.frameRegis.getPegawai().isSelected()) {
            this.frameRegis.getjLabel2().setVisible(false);
            this.frameRegis.getLabelRegistrasiPegawai().setVisible(true);
            
            this.frameRegis.getKodeAgensi().setVisible(false);
            this.frameRegis.getEmail().setVisible(false);
            this.frameRegis.getNomorhp().setVisible(false);
            this.frameRegis.getSignup1().setVisible(false);
            
            this.frameRegis.getLabelEmail().setVisible(false);
            this.frameRegis.getLabelPassword().setVisible(false);
            this.frameRegis.getLabelUsername().setVisible(false);
            this.frameRegis.getLabelKodeAgensi().setVisible(false);
            this.frameRegis.getLabelNomorHp().setVisible(false);
            this.frameRegis.getLabelUsername().setVisible(true);
            this.frameRegis.getLabelPassword().setVisible(true);
        } else if (this.frameRegis.getPembeli().isSelected()) {
            this.frameRegis.getKodeAgensi().setVisible(false);
            this.frameRegis.getEmail().setVisible(true);
            this.frameRegis.getNomorhp().setVisible(true);
            this.frameRegis.getSignup1().setVisible(true);
            this.frameRegis.getLabelEmail().setVisible(true);
            this.frameRegis.getLabelKodeAgensi().setVisible(false);
            this.frameRegis.getLabelNomorHp().setVisible(true);
            this.frameRegis.getLabelUsername().setVisible(true);
            this.frameRegis.getLabelPassword().setVisible(true);
        }
    }

    public void showDefaultView() {
        this.frameRegis.setVisible(true);
        this.frameRegis.setListener(this);
        this.frameLogin.setListener(this);
    }

    public void SignUp() {
        //this.frameLogin.setVisible(true);
        this.frameLogin.setListener(this);
        if (this.frameRegis.getAgensi().isSelected()) {
            Agensi agen = new Agensi();

            agen.setKodeAgensi(this.frameRegis.getKodeAgensi().getText());
            agen.setUsername(this.frameRegis.getUsername().getText());
            agen.setPassword(this.frameRegis.getPassword().getText());
            if (!agen.isRegistered()) {
                agen.setRegistered(true);
                listAgen.add(agen);
                pegawaiDao.insertAgen(agen);
                this.frameRegis.setVisible(false);
                this.frameLogin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frameRegis, "Kode Agensi salah atau Belum Terdaftar");
            }
        } else if (this.frameRegis.getPegawai().isSelected()) {
            Pegawai pegawai = new Pegawai();

            pegawai.setPassword(this.frameRegis.getUsername().getText());
            pegawai.setUsername(this.frameRegis.getPassword().getText());

            this.frameRegis.setVisible(false);
            this.frameLogin.setVisible(true);

            //JOptionPane.showMessageDialog(frameRegis, "Maaf Pegawai tidak memiliki Hak untuk Registrasi");
        } else if (this.frameRegis.getPembeli().isSelected()) {
            Pembeli pembeli = new Pembeli();

            pembeli.setIdPembeli("P"+(listBuyer.size() + 1));
            pembeli.setUsername(this.frameRegis.getUsername().getText());
            pembeli.setPassword(this.frameRegis.getPassword().getText());
            pembeli.setNoHP(this.frameRegis.getNomorhp().getText());
            pembeli.setEmail(this.frameRegis.getEmail().getText());

            boolean found = false;
            for (int i = 0; i < listBuyer.size(); i++) {
                if (listBuyer.get(i).getUsername().matches(pembeli.getUsername())
                        && listBuyer.get(i).getPassword().matches(pembeli.getPassword())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(frameLogin, "Akun Telah Ada");
                this.frameLogin.setVisible(false);
                this.framePembeli.setVisible(true);
            } else {
                listBuyer.add(pembeli);
                pegawaiDao.insertPembeli(pembeli);
                this.frameRegis.setVisible(false);
                this.frameLogin.setVisible(true);

                JOptionPane.showMessageDialog(frameLogin, "Akun berhasil dibuat");
            }

        }
    }

    public void SignIn() {
        this.frameAdmin.setListener(this);
         this.frameAgen.setListener(this);
         this.framePembeli.setListener(this);
         pilihanAdminKosong();
         pilihanAgensiKosong();
         pilihanPembeliKosong();
         this.frameAdmin.setVisible(false);
         this.frameAgen.setVisible(false);
         this.framePembeli.setVisible(false);

         try {
             if (this.frameLogin.getAgensi().isSelected()) {
                 Agensi agen = new Agensi();

                 agen.setKodeAgensi(this.frameLogin.getKodeAgensi().getText());
                 agen.setUsername(this.frameLogin.getUsername().getText());
                 char[] password = this.frameLogin.getPassword().getPassword();
                 String passwordString = new String(password);
                 agen.setPassword(passwordString);

                 if (agen.getKodeAgensi().isEmpty() || agen.getUsername().isEmpty() || agen.getPassword().isEmpty()) {
                     throw new IllegalArgumentException("Kode Agensi / Username / password tidak boleh kosong");
                 }
                 boolean found = false;
                 for (int i = 0; i < listAgen.size(); i++) {
                     if (listAgen.get(i).getUsername().matches(agen.getUsername())
                             && listAgen.get(i).getPassword().matches(agen.getPassword())
                             && listAgen.get(i).getKodeAgensi().matches(agen.getKodeAgensi())) {
                         found = true;
                         break;
                     }
                 }
                 if (found) {
                     this.frameLogin.setVisible(false);
                     this.frameAgen.setVisible(true);
                     JOptionPane.showMessageDialog(frameLogin, "Kamu Berhasil Login");
                 } else {
                     JOptionPane.showMessageDialog(frameLogin, "KodeAgensi/Username/Password salah!");
                 }
             } else if (this.frameLogin.getPegawai().isSelected()) {
                 Pegawai pegawai = new Pegawai();

                 pegawai.setUsername(this.frameLogin.getUsername().getText());
                 char[] password = this.frameLogin.getPassword().getPassword();
                 String passwordString = new String(password);
                 pegawai.setPassword(passwordString);
                 
                 if (pegawai.getUsername().isEmpty() || pegawai.getPassword().isEmpty()) {
                     throw new IllegalArgumentException("Username/password tidak boleh kosong");
                 }

                 if (listPegawai.get(0).getUsername().matches(pegawai.getUsername())
                         && listPegawai.get(0).getPassword().matches(pegawai.getPassword())) {
                     JOptionPane.showMessageDialog(frameLogin, "Kamu Berhasil Login");
                     this.frameLogin.setVisible(false);
                     this.frameAdmin.setVisible(true);
                 } else {
                     JOptionPane.showMessageDialog(frameLogin, "Maaf Username/Password salah");
                 }
             } else if (this.frameLogin.getPembeli().isSelected()) {
                 String username = this.frameLogin.getUsername().getText();
                 char[] password = this.frameLogin.getPassword().getPassword();
                 String passwordString = new String(password);

                 if (username.isEmpty() || passwordString.isEmpty()) {
                     throw new IllegalArgumentException("Username/password tidak boleh kosong");
                 }

                 boolean found = false;
                 for (int i = 0; i < listBuyer.size(); i++) {
                     if (listBuyer.get(i).getUsername().matches(username)
                             && listBuyer.get(i).getPassword().matches(passwordString)) {
                         found = true;
                         break;
                     }
                 }
                 if (found) {
                     JOptionPane.showMessageDialog(frameLogin, "Kamu Berhasil Login");
                     this.frameLogin.setVisible(false);
                     this.framePembeli.setVisible(true);
                 } else {
                     JOptionPane.showMessageDialog(frameLogin, "Maaf Username/Password salah");
                 }
             } else {
                 throw new IllegalArgumentException("Pilih tipe akun terlebih dahulu");
             }
         } catch (IllegalArgumentException e) {
             JOptionPane.showMessageDialog(frameLogin, e.getMessage());
         } catch (Exception e) {
             JOptionPane.showMessageDialog(frameLogin, "An error occurred: " + e.getMessage());
         }

    }

    public void pilihan() {
        this.frameLogin.getKodeAgensi().setVisible(false);
        this.frameLogin.getKodeAgensiLabel().setVisible(false);
        if (this.frameLogin.getAgensi().isSelected()) {
            this.frameLogin.getKodeAgensi().setVisible(true);
            this.frameLogin.getKodeAgensiLabel().setVisible(true);
        } else if (this.frameLogin.getPegawai().isSelected()) {
            this.frameLogin.getKodeAgensi().setVisible(false);
            this.frameLogin.getKodeAgensiLabel().setVisible(false);
        } else if (this.frameLogin.getPembeli().isSelected()) {
            this.frameLogin.getKodeAgensi().setVisible(false);
            this.frameLogin.getKodeAgensiLabel().setVisible(false);
        }
    }

    private void pilihanAdminKosong() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(false);
        this.frameAdmin.getDashboardLabel().setVisible(true);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(false);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(false);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(false);

        // yang baru
        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(false);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);
    }

    private void pilihanAdminLDR() {
        this.frameAdmin.getAlamat().setVisible(true);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(false);
        this.frameAdmin.getDashboardLabel().setVisible(true);
        this.frameAdmin.getCodeAgensi().setVisible(true);
        this.frameAdmin.getDeskripsi().setVisible(true);
        this.frameAdmin.getHarga().setVisible(true);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(true);
        this.frameAdmin.getJumlahLantai().setVisible(true);
        this.frameAdmin.getJumlahParkir().setVisible(true);
        this.frameAdmin.getJumlahToilet().setVisible(true);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(false);
        this.frameAdmin.getLuasBangunan().setVisible(true);
        this.frameAdmin.getLuasTanah().setVisible(true);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(true);
        this.frameAdmin.getTableDataRumah().setVisible(true);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(false);
        this.frameAdmin.getjScrollPane3().setVisible(true);
        this.frameAdmin.getjScrollPane4().setVisible(true);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(true);
        this.frameAdmin.getKonfirmasiTable().setVisible(true);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(false);

        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(false);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

    }

    private void pilihanAdminIKA() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(false);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(true);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(false);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);

        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(true);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(false);

        // yang baru
        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(true);
        this.frameAdmin.getInputNamaAgensi().setVisible(true);
        this.frameAdmin.getLabelNamaAgensi().setVisible(false);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

        // yang baru
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(true);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(false);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(false);
    }

    private void pilihanAdminLKA() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(true);
        //this.frameAdmin.getDashboardLabel().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(true);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(true);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(false);

        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(true);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

    }

    private void pilihanAdminMWF() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(true);
        //this.frameAdmin.getDashboardLabel().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(true);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(true);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(true);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(true);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(true);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(true);

        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(true);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(true);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

    }

    private void pilihanAdminEditForm() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(false);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(false);
        //this.frameAdmin.getDashboardLabel().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(false);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(false);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(false);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(true);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(false);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(false);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(true);

        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(true);
        this.frameAdmin.getTableForm().setVisible(false);
        this.frameAdmin.getTableWaktu().setVisible(true);
        this.frameAdmin.getjScrollPane6().setVisible(true);
        this.frameAdmin.getjScrollPane7().setVisible(false);
        this.frameAdmin.getLabelKeterangan().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

    }

    private void pilihanAdminKF() {
        this.frameAdmin.getAlamat().setVisible(false);
        this.frameAdmin.getDaftarIdForm().setVisible(true);
        this.frameAdmin.getDaftarKodeAgensi1().setVisible(false);
        //this.frameAdmin.getDashboardLabel().setVisible(false);
        this.frameAdmin.getCodeAgensi().setVisible(false);
        this.frameAdmin.getDeskripsi().setVisible(false);
        this.frameAdmin.getHarga().setVisible(false);
        this.frameAdmin.getInputKodeAgensi().setVisible(false);
        this.frameAdmin.getInputWaktuTersedia1().setVisible(false);
        this.frameAdmin.getJumlahKamar().setVisible(false);
        this.frameAdmin.getJumlahLantai().setVisible(false);
        this.frameAdmin.getJumlahParkir().setVisible(false);
        this.frameAdmin.getJumlahToilet().setVisible(false);
        this.frameAdmin.getListIdForm().setVisible(false);
        this.frameAdmin.getListKodeAgensi1().setVisible(false);
        this.frameAdmin.getLuasBangunan().setVisible(false);
        this.frameAdmin.getLuasTanah().setVisible(false);
        this.frameAdmin.getMasukanIdFormPengajuan().setVisible(true);
        this.frameAdmin.getNamaRumah().setVisible(false);
        this.frameAdmin.getTableDataRumah().setVisible(false);
        this.frameAdmin.getTextFieldInputIdForm().setVisible(true);
        this.frameAdmin.getTextFieldInputKode().setVisible(false);
        this.frameAdmin.getTextFieldInputWaktu1().setVisible(false);
        this.frameAdmin.getSubmitDeleteAll().setVisible(false);
        this.frameAdmin.getSubmitDeleteID().setVisible(false);
        this.frameAdmin.getSubmitInputIdForm1().setVisible(true);
        this.frameAdmin.getSubmitInputKode().setVisible(false);
        this.frameAdmin.getSubmitInputKode2().setVisible(false);
        this.frameAdmin.getjScrollPane1().setVisible(false);
        this.frameAdmin.getjScrollPane2().setVisible(false);
        this.frameAdmin.getjScrollPane3().setVisible(false);
        this.frameAdmin.getjScrollPane4().setVisible(false);
        this.frameAdmin.getTableUntukKonfirmasi().setVisible(false);
        this.frameAdmin.getKonfirmasiTable().setVisible(false);
        this.frameAdmin.getListWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane5().setVisible(false);
        this.frameAdmin.getLabelKodeAgensi().setVisible(false);
        this.frameAdmin.getTextFieldInputNamaAgensi().setVisible(false);
        this.frameAdmin.getInputNamaAgensi().setVisible(false);
        this.frameAdmin.getLabelNamaAgensi().setVisible(false);
        this.frameAdmin.getTableForm().setVisible(true);
        this.frameAdmin.getTableWaktu().setVisible(false);
        this.frameAdmin.getjScrollPane6().setVisible(false);
        this.frameAdmin.getjScrollPane7().setVisible(true);
        this.frameAdmin.getLabelKeterangan().setVisible(false);
        this.frameAdmin.getLabelWaktuDipilih().setVisible(false);

    }

    @Override
    public void pilihanAdmin() {
        if (this.frameAdmin.getLihatDataRumah().isSelected()) {
            pilihanAdminLDR();
        } else if (this.frameAdmin.getTambahKodeAgensi().isSelected()) {
            pilihanAdminIKA();
        } else if (this.frameAdmin.getLihatKodeAgensi().isSelected()) {
            pilihanAdminMWF();
        } else if (this.frameAdmin.getMenambahWaktuForm().isSelected()) {
            pilihanAdminEditForm();
        } else if (this.frameAdmin.getMenyuntingWaktuForm().isSelected()) {
            pilihanAdminKF();
        } else if (this.frameAdmin.getKonfirmasiForm().isSelected()) {
            pilihanAdminLKA();
        } else {
            pilihanAdminKosong();
        }
    }

    public void LogOut() {
        if (this.frameAdmin.isVisible()) {
            this.frameAdmin.setVisible(false);
        }

        if (this.frameAgen.isVisible()) {
            this.frameAgen.setVisible(false);
        }

        if (this.framePembeli.isVisible()) {
            this.framePembeli.setVisible(false);

        }

        this.frameLogin.setVisible(true);
    }

    public void isiTabel() {
        if (this.frameAdmin.getLihatDataRumah().isSelected()) {
            listRumah = pegawaiDao.getAllRumah();
            TableDataRumah tdm = new TableDataRumah(listRumah);
            this.frameAdmin.getTableDataRumah().setModel(tdm);
            
            listRumahPengajuan = pegawaiDao.getAllRumahPengajuan();
            TableDataRumah tpr = new TableDataRumah(listRumahPengajuan);
            this.frameAdmin.getTableUntukKonfirmasi().setModel(tpr);
            
        } else if (this.frameAgen.getLihatDaftarRumah().isSelected() || this.frameAgen.getTambahDataRumah().isSelected()) {
           
            listRumah = agenDao.getAllRumahAgensi(this.frameLogin.getKodeAgensi().getText());
            TableDataRumah tdm = new TableDataRumah(listRumah);
            this.frameAgen.getTableDataRumah().setModel(tdm);
            
            listRumahPengajuan = agenDao.getAllRumahPengajuan(this.frameLogin.getKodeAgensi().getText());
            TableDataRumah tpr = new TableDataRumah(listRumahPengajuan);
            this.frameAgen.getTabelPengajuanDataRumah().setModel(tpr);
            
        } else if(this.framePembeli.getLihatDaftarRumah().isSelected() || this.framePembeli.getSearch().isSelected()){
            listRumah = pembeliDao.getAllRumah();
            TableDataRumah tdm = new TableDataRumah(listRumah);
            this.framePembeli.getTableDatarRumah().setModel(tdm);
        } else if(this.frameAdmin.getMenyuntingWaktuForm().isSelected()){
            listForm = pegawaiDao.getAllForm();
            TableForm tdm = new TableForm(listForm);
            this.frameAdmin.getTableForm().setModel(tdm);
        } else if(this.frameAdmin.getMenambahWaktuForm().isSelected()){
            listWaktuJanjian = pegawaiDao.getAllWaktuJanjian();
            TableWaktu tw = new TableWaktu(listWaktuJanjian);
            this.frameAdmin.getTableWaktu().setModel(tw);
        } else if (this.framePembeli.getFormPengajuan().isSelected()){
            Pembeli pembeli = new Pembeli();
            for(int i = 0;i<listBuyer.size();i++){
                if(listBuyer.get(i).getUsername().equals(this.frameLogin.getUsername().getText())){
                    pembeli = listBuyer.get(i);
                }
            }
            listForm = pegawaiDao.getFormId(pembeli.getIdPembeli());
            TableForm tdm = new TableForm(listForm);
            this.framePembeli.getTableForm().setModel(tdm);
        }
        
        
        
    }
    
    public void submitRumah(){
        listRumah = pegawaiDao.getAllRumah();
        listRumahPengajuan = pegawaiDao.getAllRumahPengajuan();
        
        DataRumah rumah = new DataRumah();
        
        rumah.setIdRumah(listRumah.size() + listRumahPengajuan.size() + 1);
        rumah.setKodeAgensi(this.frameLogin.getKodeAgensi().getText());
        rumah.setAlamat(this.frameAgen.getAlamatField().getText());
        rumah.setNamaRumah(this.frameAgen.getNamaRumahField().getText());
        rumah.setDescription("");
        rumah.setHarga(Integer.parseInt(this.frameAgen.getHargaField().getText()));     
        rumah.setJmlhKamar(Integer.parseInt(this.frameAgen.getJumlahKamarField().getText()));
        rumah.setLuasBangunan(Integer.parseInt(this.frameAgen.getLuasBangunanField().getText()));
        rumah.setLuasTanah(Integer.parseInt(this.frameAgen.getLuasTanahField().getText()));
        rumah.setJmlhParkir(Integer.parseInt(this.frameAgen.getJumlahParkirField().getText()));
        rumah.setJmlhLantai(Integer.parseInt(this.frameAgen.getJumlajLantaiField().getText()));  
        rumah.setJmlhToilet(Integer.parseInt(this.frameAgen.getJumlahToiletField().getText()));
   
        agenDao.insertRumahAgensi(rumah);
        listRumahPengajuan.add(rumah);
        JOptionPane.showMessageDialog(frameAgen, "Data Rumah Baru sudah ditambahkan");
    }
    
    public void KonfirmasiRumah(int row){
        DataRumah rumah = new DataRumah();
        
        rumah.setAlamat(listRumahPengajuan.get(row).getAlamat());
        rumah.setDescription(listRumahPengajuan.get(row).getDescription());
        rumah.setKodeAgensi(listRumahPengajuan.get(row).getKodeAgensi());
        rumah.setNamaRumah(listRumahPengajuan.get(row).getNamaRumah());
        rumah.setHarga(listRumahPengajuan.get(row).getHarga());
        rumah.setIdRumah(listRumahPengajuan.get(row).getIdRumah());
        rumah.setJmlhKamar(listRumahPengajuan.get(row).getJmlhKamar());
        rumah.setJmlhLantai(listRumahPengajuan.get(row).getJmlhLantai());
        rumah.setJmlhToilet(listRumahPengajuan.get(row).getJmlhToilet());
        rumah.setJmlhParkir(listRumahPengajuan.get(row).getJmlhParkir());
        rumah.setLuasBangunan(listRumahPengajuan.get(row).getLuasBangunan());
        rumah.setLuasTanah( listRumahPengajuan.get(row).getLuasTanah());
        
        pegawaiDao.insertRumah(rumah);
        listRumah.add(rumah);
        pegawaiDao.delete(row);
        listRumahPengajuan.remove(row);
        JOptionPane.showMessageDialog(frameAdmin, "Data Rumah berhasil dikonfirmasi");
    }

    public void isiListForm() {

        listForm = pegawaiDao.getAllForm();
        DefaultListModel<String> listFormModel = new DefaultListModel<>();
        for (int i = 0; i < this.listForm.size(); i++) {
            listFormModel.add(i, this.listForm.get(i).getIdForm());
        }
        this.frameAdmin.getListIdForm().setModel(listFormModel);

        listWaktuJanjian = pegawaiDao.getAllWaktuJanjian();
        DefaultListModel<String> listWaktuModel = new DefaultListModel<>();
        for (int i = 0; i < this.listWaktuJanjian.size(); i++) {
            listWaktuModel.add(i, this.listWaktuJanjian.get(i).getWaktuTersedia());
        }
        this.frameAdmin.getListWaktu().setModel(listWaktuModel);

    }

    public void isiListKodeAgen() {

        KodeAgensi = pegawaiDao.getAllKodeAgensi();
        NamaAgensi = pegawaiDao.getAllNamaAgensi();
        DefaultListModel<String> listKodeAgensi = new DefaultListModel<>();
        for (int i = 0; i < this.KodeAgensi.size(); i++) {
            listKodeAgensi.add(i, this.KodeAgensi.get(i));
        }
        this.frameAdmin.getListKodeAgensi1().setModel(listKodeAgensi);

    }

    @Override
    public void Regis() {
        this.frameLogin.setVisible(false);
        this.frameRegis.setVisible(true);
    }
    
    private void pilihanAgensiKosong(){
        this.frameAgen.getAlamatField().setVisible(false);
        this.frameAgen.getAlamatLabel().setVisible(false);
        this.frameAgen.getAlamatLabelField().setVisible(false);
        this.frameAgen.getDataRumahBaruLabelField().setVisible(false);
        this.frameAgen.getButtonSubmit().setVisible(false);
        this.frameAgen.getHargaLabel().setVisible(false);
        this.frameAgen.getHargaField().setVisible(false);
        this.frameAgen.getHargaLabelField().setVisible(false);
        this.frameAgen.getIDLabel().setVisible(false);
        this.frameAgen.getJumlahKamarField().setVisible(false);
        this.frameAgen.getJumlahKamarLabelField().setVisible(false);
        this.frameAgen.getJumlahLantaiLabel().setVisible(false);
        this.frameAgen.getJumlahLantaiLabelField().setVisible(false);
        this.frameAgen.getJumlahParkirField().setVisible(false);
        this.frameAgen.getJumlahParkirLabel().setVisible(false);
        this.frameAgen.getJumlahParkirLabelField().setVisible(false);
        this.frameAgen.getJumlahToiletField().setVisible(false);
        this.frameAgen.getJumlahToiletLabelField().setVisible(false);
        this.frameAgen.getJumlajLantaiField().setVisible(false);
        this.frameAgen.getKodeAgencyLabel().setVisible(false);
        this.frameAgen.getLuasBangunanField().setVisible(false);
        this.frameAgen.getLuasBangunanLabel().setVisible(false);
        this.frameAgen.getLuasTanahField().setVisible(false);
        this.frameAgen.getLuasTanahLabel().setVisible(false);
        this.frameAgen.getLuasTanahLabelField().setVisible(false);
        this.frameAgen.getNamaRumahField().setVisible(false);
        this.frameAgen.getNamaRumahLabel().setVisible(false);
        this.frameAgen.getNamaRumahLabelField().setVisible(false);
        this.frameAgen.getTableDataRumah().setVisible(false);
        this.frameAgen.getjScrollPane1().setVisible(false);
        this.frameAgen.getTabelPengajuanDataRumah().setVisible(false);
        this.frameAgen.getjScrollPane2().setVisible(false);
        this.frameAgen.getLuasBangunanLabelField().setVisible(false);
        this.frameAgen.getJumlahKamarLabel().setVisible(false);
        this.frameAgen.getJumlahToiletLabel().setVisible(false);
    }

    private void pilihanAgensiLDR(){
        this.frameAgen.getAlamatField().setVisible(true);
        this.frameAgen.getAlamatLabel().setVisible(false);
        this.frameAgen.getAlamatLabelField().setVisible(true);
        this.frameAgen.getDataRumahBaruLabelField().setVisible(true);
        this.frameAgen.getButtonSubmit().setVisible(true);
        this.frameAgen.getHargaLabel().setVisible(false);
        this.frameAgen.getHargaField().setVisible(true);
        this.frameAgen.getHargaLabelField().setVisible(true);
        this.frameAgen.getIDLabel().setVisible(false);
        this.frameAgen.getJumlahKamarField().setVisible(true);
        this.frameAgen.getJumlahKamarLabelField().setVisible(true);
        this.frameAgen.getJumlahLantaiLabel().setVisible(false);
        this.frameAgen.getJumlahLantaiLabelField().setVisible(true);
        this.frameAgen.getJumlahParkirField().setVisible(true);
        this.frameAgen.getJumlahParkirLabel().setVisible(false);
        this.frameAgen.getJumlahParkirLabelField().setVisible(true);
        this.frameAgen.getJumlahToiletField().setVisible(true);
        this.frameAgen.getJumlahToiletLabelField().setVisible(true);
        this.frameAgen.getJumlajLantaiField().setVisible(true);
        this.frameAgen.getKodeAgencyLabel().setVisible(false);
        this.frameAgen.getLuasBangunanField().setVisible(true);
        this.frameAgen.getLuasBangunanLabel().setVisible(false);
        this.frameAgen.getLuasTanahField().setVisible(true);
        this.frameAgen.getLuasTanahLabel().setVisible(false);
        this.frameAgen.getLuasTanahLabelField().setVisible(true);
        this.frameAgen.getNamaRumahField().setVisible(true);
        this.frameAgen.getNamaRumahLabel().setVisible(false);
        this.frameAgen.getNamaRumahLabelField().setVisible(true);
        this.frameAgen.getTableDataRumah().setVisible(true);
        this.frameAgen.getjScrollPane1().setVisible(true);
        this.frameAgen.getTabelPengajuanDataRumah().setVisible(true);
        this.frameAgen.getjScrollPane2().setVisible(true);
        this.frameAgen.getLuasBangunanLabelField().setVisible(true);
        this.frameAgen.getJumlahKamarLabel().setVisible(false);
        this.frameAgen.getJumlahToiletLabel().setVisible(false);
    }

    private void pilihanAgensiIDR(){
        this.frameAgen.getAlamatField().setVisible(false);
        this.frameAgen.getAlamatLabel().setVisible(true);
        this.frameAgen.getAlamatLabelField().setVisible(false);
        this.frameAgen.getDataRumahBaruLabelField().setVisible(false);
        this.frameAgen.getButtonSubmit().setVisible(false);
        this.frameAgen.getHargaLabel().setVisible(true);
        this.frameAgen.getHargaField().setVisible(false);
        this.frameAgen.getHargaLabelField().setVisible(false);
        this.frameAgen.getIDLabel().setVisible(true);
        this.frameAgen.getJumlahKamarField().setVisible(false);
        this.frameAgen.getJumlahKamarLabelField().setVisible(false);
        this.frameAgen.getJumlahLantaiLabel().setVisible(true);
        this.frameAgen.getJumlahLantaiLabelField().setVisible(false);
        this.frameAgen.getJumlahParkirField().setVisible(false);
        this.frameAgen.getJumlahParkirLabel().setVisible(true);
        this.frameAgen.getJumlahParkirLabelField().setVisible(false);
        this.frameAgen.getJumlahToiletField().setVisible(false);
        this.frameAgen.getJumlahToiletLabelField().setVisible(false);
        this.frameAgen.getJumlajLantaiField().setVisible(false);
        this.frameAgen.getKodeAgencyLabel().setVisible(true);
        this.frameAgen.getLuasBangunanField().setVisible(false);
        this.frameAgen.getLuasBangunanLabel().setVisible(true);
        this.frameAgen.getLuasTanahField().setVisible(false);
        this.frameAgen.getLuasTanahLabel().setVisible(true);
        this.frameAgen.getLuasTanahLabelField().setVisible(false);
        this.frameAgen.getNamaRumahField().setVisible(false);
        this.frameAgen.getNamaRumahLabel().setVisible(true);
        this.frameAgen.getNamaRumahLabelField().setVisible(false);
        this.frameAgen.getTableDataRumah().setVisible(true);
        this.frameAgen.getjScrollPane1().setVisible(true);
        this.frameAgen.getTabelPengajuanDataRumah().setVisible(false);
        this.frameAgen.getjScrollPane2().setVisible(false);
        this.frameAgen.getLuasBangunanLabelField().setVisible(false);
        this.frameAgen.getJumlahKamarLabel().setVisible(true);
        this.frameAgen.getJumlahToiletLabel().setVisible(true);
    }

    
    @Override
    public void pilihanAgensi() {
        if(this.frameAgen.getTambahDataRumah().isSelected()){
            pilihanAgensiLDR();
        }else if(this.frameAgen.getLihatDaftarRumah().isSelected()){            
            pilihanAgensiIDR();
        }else{
            pilihanAgensiKosong();
        }
    }

    @Override
    public void isiField(int row) {
        if (this.frameAdmin.getLihatDataRumah().isSelected()) {
            this.frameAdmin.getAlamat().setText("Alamat : " + listRumah.get(row).getAlamat());
            this.frameAdmin.getDeskripsi().setText("Deskripsi : " + listRumah.get(row).getDescription());
            this.frameAdmin.getCodeAgensi().setText("Kode Agensi : " + listRumah.get(row).getKodeAgensi());
            this.frameAdmin.getNamaRumah().setText("Nama Rumah : " + listRumah.get(row).getNamaRumah());
            this.frameAdmin.getHarga().setText("Harga : " + listRumah.get(row).getHarga());
            //this.frameAdmin.get().setText("Id Rumah : " + listRumah.get(row).getIdRumah());
            this.frameAdmin.getJumlahKamar().setText("Jumlah Kamar : " + listRumah.get(row).getJmlhKamar());
            this.frameAdmin.getJumlahLantai().setText("Jumlah Lantai : " + listRumah.get(row).getJmlhLantai());
            this.frameAdmin.getJumlahToilet().setText("Jumlah Toilet : " + listRumah.get(row).getJmlhToilet());
            this.frameAdmin.getJumlahParkir().setText("Jumlah Parkir : " + listRumah.get(row).getJmlhParkir());
            this.frameAdmin.getLuasBangunan().setText("Luas Bangunan : " + listRumah.get(row).getLuasBangunan());
            this.frameAdmin.getLuasTanah().setText("Luas Tanah : " + listRumah.get(row).getLuasTanah());
            pilihanAdminLDR();
        } else if (this.frameAgen.getLihatDaftarRumah().isSelected()) {
            this.frameAgen.getAlamatLabel().setText("Alamat : " + listRumah.get(row).getAlamat());
            //this.frameAgen.get().setText("Deskripsi : " + listRumah.get(row).getDescription());
            this.frameAgen.getKodeAgencyLabel().setText("Kode Agensi : " + listRumah.get(row).getKodeAgensi());
            this.frameAgen.getNamaRumahLabel().setText("Nama Rumah : " + listRumah.get(row).getNamaRumah());
            this.frameAgen.getHargaLabel().setText("Harga : " + listRumah.get(row).getHarga());
            this.frameAgen.getIDLabel().setText("ID : " + listRumah.get(row).getIdRumah());
            this.frameAgen.getJumlahKamarLabel().setText("Jumlah Kamar : " + listRumah.get(row).getJmlhKamar());
            this.frameAgen.getJumlahLantaiLabel().setText("Jumlah Lantai : " + listRumah.get(row).getJmlhLantai());
            this.frameAgen.getJumlahToiletLabel().setText("Jumlah Toilet : " + listRumah.get(row).getJmlhToilet());
            this.frameAgen.getJumlahParkirLabel().setText("Jumlah Parkir : " + listRumah.get(row).getJmlhParkir());
            this.frameAgen.getLuasBangunanLabel().setText("Luas Bangunan : " + listRumah.get(row).getLuasBangunan());
            this.frameAgen.getLuasTanahLabel().setText("Luas Tanah : " + listRumah.get(row).getLuasTanah());
            //pilihanAgensiLDR();
        } else if (this.framePembeli.getLihatDaftarRumah().isSelected() || this.framePembeli.getSearch().isSelected()) {
            this.framePembeli.getTabelAlamat().setText("Alamat : " + listRumah.get(row).getAlamat());
            //this.framePembeli.getDeskripsi().setText("Deskripsi : " + listRumah.get(row).getDescription());
            //this.framePembeli.getTabelKodeAgensi().setText("Kode Agensi : " + listRumah.get(row).getKodeAgensi());
            this.framePembeli.getAlamatRumah().setText("Nama Rumah : " + listRumah.get(row).getNamaRumah());
            this.framePembeli.getHarga().setText("Harga : " + listRumah.get(row).getHarga());
            //this.framePembeli.getTabelID().setText("Id Rumah : " + listRumah.get(row).getIdRumah());
            this.framePembeli.getJumlahKamar().setText("Jumlah Kamar : " + listRumah.get(row).getJmlhKamar());
            this.framePembeli.getJumlahLantai().setText("Jumlah Lantai : " + listRumah.get(row).getJmlhLantai());
            this.framePembeli.getJumlahToilet().setText("Jumlah Toilet : " + listRumah.get(row).getJmlhToilet());
            this.framePembeli.getJumlahParkir().setText("Jumlah Parkir : " + listRumah.get(row).getJmlhParkir());
            this.framePembeli.getLuasBangunan().setText("Luas Bangunan : " + listRumah.get(row).getLuasBangunan());
            this.framePembeli.getLuasTanah().setText("Luas Tanah : " + listRumah.get(row).getLuasTanah());
        } else if (this.frameAdmin.getMenyuntingWaktuForm().isSelected()){
            this.frameAdmin.getTextFieldInputIdForm().setText(listForm.get(row).getIdForm());
//            this.frameAdmin.getLabelKodeAgensi().setText("Kode Agensi: " + KodeAgensi.get(row));

        } else if(this.framePembeli.getFormPengajuan().isSelected()){
            this.framePembeli.getTextFieldNamaRumah().setText(listRumah.get(row).getNamaRumah());
        } else if (this.frameAdmin.getKonfirmasiForm().isSelected()){
            this.frameAdmin.getLabelNamaAgensi().setText("Nama Agensi: " + NamaAgensi.get(row));
        } else if (this.frameAdmin.getMenambahWaktuForm().isSelected() || this.frameAdmin.getLihatKodeAgensi().isSelected()){
            this.frameAdmin.getLabelNamaAgensi().setText("Nama Agensi: " + NamaAgensi.get(row));
            this.frameAdmin.getLabelKodeAgensi().setText("Kode Agensi: " + KodeAgensi.get(row));
            this.frameAdmin.getLabelWaktuDipilih().setText(listWaktuJanjian.get(row).getWaktuTersedia());
        } 
    }
    
    private void pilihanPembeliKosong(){
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getTextFieldHarga().setVisible(false);
        this.framePembeli.getTextFieldJumlahKamar().setVisible(false);
        this.framePembeli.getSubmitForm().setVisible(false);
        this.framePembeli.getSubmitSearch1().setVisible(false);
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getjComboBox1().setVisible(false);
        this.framePembeli.getjComboBox2().setVisible(false);
        this.framePembeli.getjComboBox3().setVisible(false);
        this.framePembeli.getjComboBox4().setVisible(false);
        this.framePembeli.getKeterangan1().setVisible(false);
        this.framePembeli.getKeterangan2().setVisible(false);
        this.framePembeli.getTableDatarRumah().setVisible(false);
        //this.framePembeli.getTabelID().setVisible(false);
        //this.framePembeli.getTabelKodeAgensi().setVisible(false);
        this.framePembeli.getTabelAlamat().setVisible(false);
        this.framePembeli.getAlamatRumah().setVisible(false);
        this.framePembeli.getHarga().setVisible(false);
        this.framePembeli.getJumlahKamar().setVisible(false);
        this.framePembeli.getLuasBangunan().setVisible(false);
        this.framePembeli.getLuasTanah().setVisible(false);
        this.framePembeli.getJumlahParkir().setVisible(false);
        this.framePembeli.getJumlahToilet().setVisible(false);
        this.framePembeli.getJumlahLantai().setVisible(false);
        this.framePembeli.getTextFieldNama().setVisible(false);
        this.framePembeli.getjScrollPane1().setVisible(false);
        this.framePembeli.getNamaRumahField().setVisible(false);
        this.framePembeli.getWaktuJanjianField().setVisible(false);
        this.framePembeli.getTanggalJanjianField().setVisible(false);
        this.framePembeli.getLabelHarga().setVisible(false);
        this.framePembeli.getLabelNama().setVisible(false);
        this.framePembeli.getLabelJumlahKamar().setVisible(false);
        this.framePembeli.getTableForm().setVisible(false);
        this.framePembeli.getTablePengajuanForm().setVisible(false);
        
    }
    private void pilihanPembeliLDR(){
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getTextFieldHarga().setVisible(false);
        this.framePembeli.getTextFieldJumlahKamar().setVisible(false);
        this.framePembeli.getSubmitForm().setVisible(false);
        this.framePembeli.getSubmitSearch1().setVisible(false);
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getjComboBox1().setVisible(false);
        this.framePembeli.getjComboBox2().setVisible(false);
        this.framePembeli.getjComboBox3().setVisible(false);
        this.framePembeli.getjComboBox4().setVisible(false);
        this.framePembeli.getKeterangan1().setVisible(false);
        this.framePembeli.getKeterangan2().setVisible(false);
        this.framePembeli.getTableDatarRumah().setVisible(true);
        //this.framePembeli.getTabelID().setVisible(true);
        //this.framePembeli.getTabelKodeAgensi().setVisible(true);
        this.framePembeli.getTabelAlamat().setVisible(true);
        this.framePembeli.getAlamatRumah().setVisible(true);
        this.framePembeli.getHarga().setVisible(true);
        this.framePembeli.getJumlahKamar().setVisible(true);
        this.framePembeli.getLuasBangunan().setVisible(true);
        this.framePembeli.getLuasTanah().setVisible(true);
        this.framePembeli.getJumlahParkir().setVisible(true);
        this.framePembeli.getJumlahToilet().setVisible(true);
        this.framePembeli.getJumlahLantai().setVisible(true);
        this.framePembeli.getTextFieldNama().setVisible(false);
        this.framePembeli.getjScrollPane1().setVisible(true);
        this.framePembeli.getNamaRumahField().setVisible(false);
        this.framePembeli.getWaktuJanjianField().setVisible(false);
        this.framePembeli.getTanggalJanjianField().setVisible(false);
        this.framePembeli.getLabelHarga().setVisible(false);
        this.framePembeli.getLabelNama().setVisible(false);
        this.framePembeli.getLabelJumlahKamar().setVisible(false);
        this.framePembeli.getTableForm().setVisible(false);
        this.framePembeli.getTablePengajuanForm().setVisible(false);
    }
    
    private void pilihanPembeliFP(){
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getTextFieldHarga().setVisible(false);
        this.framePembeli.getTextFieldJumlahKamar().setVisible(false);
        this.framePembeli.getSubmitForm().setVisible(true);
        this.framePembeli.getSubmitSearch1().setVisible(false);
        this.framePembeli.getTextFieldNamaRumah().setVisible(true);
        this.framePembeli.getjComboBox1().setVisible(true);
        this.framePembeli.getjComboBox2().setVisible(true);
        this.framePembeli.getjComboBox3().setVisible(true);
        this.framePembeli.getjComboBox4().setVisible(true);
        this.framePembeli.getKeterangan1().setVisible(false);
        this.framePembeli.getKeterangan2().setVisible(false);
        this.framePembeli.getTableDatarRumah().setVisible(true);
        //this.framePembeli.getTabelID().setVisible(false);
        //this.framePembeli.getTabelKodeAgensi().setVisible(false);
        this.framePembeli.getTabelAlamat().setVisible(false);
        this.framePembeli.getAlamatRumah().setVisible(false);
        this.framePembeli.getHarga().setVisible(false);
        this.framePembeli.getJumlahKamar().setVisible(false);
        this.framePembeli.getLuasBangunan().setVisible(false);
        this.framePembeli.getLuasTanah().setVisible(false);
        this.framePembeli.getJumlahParkir().setVisible(false);
        this.framePembeli.getJumlahToilet().setVisible(false);
        this.framePembeli.getJumlahLantai().setVisible(false);
        this.framePembeli.getTextFieldNama().setVisible(false);
        this.framePembeli.getjScrollPane1().setVisible(true);
        this.framePembeli.getNamaRumahField().setVisible(true);
        this.framePembeli.getWaktuJanjianField().setVisible(true);
        this.framePembeli.getTanggalJanjianField().setVisible(true);
        this.framePembeli.getLabelHarga().setVisible(false);
        this.framePembeli.getLabelNama().setVisible(false);
        this.framePembeli.getLabelJumlahKamar().setVisible(false);
        this.framePembeli.getTableForm().setVisible(false);
        this.framePembeli.getTablePengajuanForm().setVisible(false);
    }
    
    private void pilihanPembeliSearch(){
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getTextFieldHarga().setVisible(true);
        this.framePembeli.getTextFieldJumlahKamar().setVisible(true);
        this.framePembeli.getSubmitForm().setVisible(false);
        this.framePembeli.getSubmitSearch1().setVisible(true);
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getjComboBox1().setVisible(false);
        this.framePembeli.getjComboBox2().setVisible(false);
        this.framePembeli.getjComboBox3().setVisible(false);
        this.framePembeli.getjComboBox4().setVisible(false);
        this.framePembeli.getKeterangan1().setVisible(true);
        this.framePembeli.getKeterangan2().setVisible(true);
        this.framePembeli.getTableDatarRumah().setVisible(true);
        //this.framePembeli.getTabelID().setVisible(true);
        //this.framePembeli.getTabelKodeAgensi().setVisible(true);
        this.framePembeli.getTabelAlamat().setVisible(true);
        this.framePembeli.getAlamatRumah().setVisible(true);
        this.framePembeli.getHarga().setVisible(true);
        this.framePembeli.getJumlahKamar().setVisible(true);
        this.framePembeli.getLuasBangunan().setVisible(true);
        this.framePembeli.getLuasTanah().setVisible(true);
        this.framePembeli.getJumlahParkir().setVisible(true);
        this.framePembeli.getJumlahToilet().setVisible(true);
        this.framePembeli.getJumlahLantai().setVisible(true);
        this.framePembeli.getTextFieldNama().setVisible(true);
        this.framePembeli.getjScrollPane1().setVisible(true);
        this.framePembeli.getNamaRumahField().setVisible(false);
        this.framePembeli.getWaktuJanjianField().setVisible(false);
        this.framePembeli.getTanggalJanjianField().setVisible(false);
        this.framePembeli.getLabelHarga().setVisible(true);
        this.framePembeli.getLabelNama().setVisible(true);
        this.framePembeli.getLabelJumlahKamar().setVisible(true);
        this.framePembeli.getTableForm().setVisible(false);
        this.framePembeli.getTablePengajuanForm().setVisible(false);
        
    }

    private void pilihanPembeliLFP(){
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getTextFieldHarga().setVisible(false);
        this.framePembeli.getTextFieldJumlahKamar().setVisible(false);
        this.framePembeli.getSubmitForm().setVisible(false);
        this.framePembeli.getSubmitSearch1().setVisible(false);
        this.framePembeli.getTextFieldNamaRumah().setVisible(false);
        this.framePembeli.getjComboBox1().setVisible(false);
        this.framePembeli.getjComboBox2().setVisible(false);
        this.framePembeli.getjComboBox3().setVisible(false);
        this.framePembeli.getjComboBox4().setVisible(false);
        this.framePembeli.getKeterangan1().setVisible(false);
        this.framePembeli.getKeterangan2().setVisible(false);
        this.framePembeli.getTableDatarRumah().setVisible(false);
        //this.framePembeli.getTabelID().setVisible(false);
        //this.framePembeli.getTabelKodeAgensi().setVisible(false);
        this.framePembeli.getTabelAlamat().setVisible(false);
        this.framePembeli.getAlamatRumah().setVisible(false);
        this.framePembeli.getHarga().setVisible(false);
        this.framePembeli.getJumlahKamar().setVisible(false);
        this.framePembeli.getLuasBangunan().setVisible(false);
        this.framePembeli.getLuasTanah().setVisible(false);
        this.framePembeli.getJumlahParkir().setVisible(false);
        this.framePembeli.getJumlahToilet().setVisible(false);
        this.framePembeli.getJumlahLantai().setVisible(false);
        this.framePembeli.getTextFieldNama().setVisible(false);
        this.framePembeli.getjScrollPane1().setVisible(false);
        this.framePembeli.getNamaRumahField().setVisible(false);
        this.framePembeli.getWaktuJanjianField().setVisible(false);
        this.framePembeli.getTanggalJanjianField().setVisible(false);
        this.framePembeli.getLabelHarga().setVisible(false);
        this.framePembeli.getLabelNama().setVisible(false);
        this.framePembeli.getLabelJumlahKamar().setVisible(false);
        this.framePembeli.getTableForm().setVisible(true);
        this.framePembeli.getTablePengajuanForm().setVisible(true);
        
    }
    
    @Override
    public void submitKodeAgen() {
        // yang baru
        pegawaiDao.insertKodeAgensi(this.frameAdmin.getTextFieldInputKode().getText(), this.frameAdmin.getTextFieldInputNamaAgensi().getText());
        // yang baru
        JOptionPane.showMessageDialog(frameAdmin, "Kode Agensi berhasil di tambahkan");
        
    }
    
    @Override
    public void pilihanPembeli(){
        if(this.framePembeli.getSearch().isSelected()){
            pilihanPembeliSearch();
        }else if(this.framePembeli.getLihatDaftarRumah().isSelected()){
            pilihanPembeliLDR();
        }else if(this.framePembeli.getFormPengajuan().isSelected()){
            pilihanPembeliFP();
        }else if (this.framePembeli.getLihatFormPengajuan().isSelected()){
            pilihanPembeliLFP();
        }else{
            pilihanPembeliKosong();
        }
    }

    @Override
    public void isiFieldKonfirmasi(int row) {
        this.frameAdmin.getAlamat().setText("Alamat : " + listRumahPengajuan.get(row).getAlamat());
        this.frameAdmin.getDeskripsi().setText("Deskripsi : " + listRumahPengajuan.get(row).getDescription());
        //this.frameAdmin.get().setText("Kode Agensi : " + listRumah.get(row).getKodeAgensi());
        this.frameAdmin.getNamaRumah().setText("Nama Rumah : " + listRumahPengajuan.get(row).getNamaRumah());
        this.frameAdmin.getHarga().setText("Harga : " + listRumahPengajuan.get(row).getHarga());
        //this.frameAdmin.get().setText("Id Rumah : " + listRumah.get(row).getIdRumah());
        this.frameAdmin.getJumlahKamar().setText("Jumlah Kamar : " + listRumahPengajuan.get(row).getJmlhKamar());
        this.frameAdmin.getJumlahLantai().setText("Jumlah Lantai : " + listRumahPengajuan.get(row).getJmlhLantai());
        this.frameAdmin.getJumlahToilet().setText("Jumlah Toilet : " + listRumahPengajuan.get(row).getJmlhToilet());
        this.frameAdmin.getJumlahParkir().setText("Jumlah Parkir : " + listRumahPengajuan.get(row).getJmlhParkir());
        this.frameAdmin.getLuasBangunan().setText("Luas Bangunan : " + listRumahPengajuan.get(row).getLuasBangunan());
        this.frameAdmin.getLuasTanah().setText("Luas Tanah : " + listRumahPengajuan.get(row).getLuasTanah());
        
        pilihanAdminLDR();
    }

    @Override
    public void submitForm() {
        try {
            Form form = new Form();
            listRumah = pegawaiDao.getAllRumah();
            String idPembeli = null;
            for(int i = 0;i<listBuyer.size();i++){
                if(listBuyer.get(i).getUsername().equals(this.frameLogin.getUsername().getText())){
                    idPembeli = listBuyer.get(i).getIdPembeli();
                }
            }
            
            form.setIdForm(idPembeli + "-" +(listForm.size() + 1));
            form.setIdPembeli(idPembeli);
            for(int i = 0;i<listRumah.size();i++){
                if(listRumah.get(i).getNamaRumah().equals(this.framePembeli.getTextFieldNamaRumah().getText())){
                   form.setIdRumah(listRumah.get(i).getIdRumah());
                }
            }
            
            form.setLokasiJanjian("");
            //form.setLokasiJanjian(this.framePembeli.getTextFieldLokasiJanjian1().getText());
            form.setNamaRumah(this.framePembeli.getTextFieldNamaRumah().getText());
            form.setStatus("Menunggu Dikonfirmasi");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalJanjian = this.framePembeli.getjComboBox4().getSelectedItem() + "-" + this.framePembeli.getjComboBox3().getSelectedItem() + "-" + this.framePembeli.getjComboBox2().getSelectedItem();
            Date tanggal = dateFormatter.parse(tanggalJanjian);

            form.setTanggalJanjian(dateFormatter.format(tanggal));
            form.setUsername(this.frameLogin.getUsername().getText());
            form.setWaktuJanjian(String.valueOf(this.framePembeli.getjComboBox1().getSelectedItem()));

            pembeliDao.insertForm(form);
            listForm.add(form);
            JOptionPane.showMessageDialog(framePembeli, "Form berhasil diajukan");
        } catch (ParseException ex) {
            Logger.getLogger(ControllerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiComboBox(int row) {
        List<String> listWaktuTersedia = new ArrayList<>();

        for (int i = 0; i < listWaktuJanjian.size(); i++) {
            if (listWaktuJanjian.get(i).getKodeAgensi().equals(listWaktuJanjian.get(row).getKodeAgensi())) {
                listWaktuTersedia.add(listWaktuJanjian.get(i).getWaktuTersedia());
            }
        }

        ComboBoxListWaktu cblw = new ComboBoxListWaktu(listWaktuTersedia);
        this.framePembeli.getjComboBox1().setModel(cblw);

    }
    
    @Override
    public void inputWaktu() {
        WaktuTersediaForm waktu = new WaktuTersediaForm();
        waktu.setKodeAgensi(this.frameAdmin.getListKodeAgensi1().getSelectedValue());
        waktu.setWaktuTersedia(this.frameAdmin.getTextFieldInputWaktu1().getText());
        
        pegawaiDao.insertWaktuJanjian(waktu);
        
        JOptionPane.showMessageDialog(frameAdmin, "Waktu Baru telah ditambahkan");
    }

    @Override
    public void Delete() {
        //if (!this.frameAdmin.getTextFieldInputIdForm().getText().trim().isEmpty()) {
            pegawaiDao.deleteWaktu(this.frameAdmin.getLabelWaktuDipilih().getText());
        //} else {
            JOptionPane.showMessageDialog(frameAdmin, "Isi Waktu yang akan Dihapus");
        //}
    }
    
    public void Login(){
        this.frameLogin.setVisible(true);
        this.frameRegis.setVisible(false);
    }
    
    public void updateForm() {
        if (!this.frameAdmin.getTextFieldInputIdForm().getText().trim().isEmpty()) {

            List<Form> form =  pegawaiDao.getForm(this.frameAdmin.getTextFieldInputIdForm().getText());

            int response = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                // Tindakan jika tombol Yes ditekan
                form.get(0).setStatus("Diterima");
                pegawaiDao.updateFormStatus(form.get(0));
                JOptionPane.showMessageDialog(frameAdmin, "Form Diterima");
            } else if (response == JOptionPane.NO_OPTION) {
                // Tindakan jika tombol No ditekan
                form.get(0).setStatus("Ditolak");
                pegawaiDao.updateFormStatus(form.get(0));
                JOptionPane.showMessageDialog(frameAdmin, "Form Ditolak");

            }

        } else {
            JOptionPane.showMessageDialog(frameAdmin, "Isi FormID yang akan dikonfirmasi");

        }

    }
    private void isiTableCariRumah(String alamat, int jumlahKamar, Double harga) {
        listRumah = pembeliDao.getRumah(alamat, jumlahKamar, harga);
        TableDataRumah TDR = new TableDataRumah(listRumah);
        framePembeli.getTableDatarRumah().setModel(TDR);
    }
    
    private void isiTableCariRumahHarga(Double harga) {
        listRumah = pembeliDao.getRumah(harga);
        TableDataRumah TDR = new TableDataRumah(listRumah);
        framePembeli.getTableDatarRumah().setModel(TDR);
    }
    
    private void isiTableCariRumahJumlahKamar(int jumlahKamar) {
        listRumah = pembeliDao.getRumah(jumlahKamar);
        TableDataRumah TDR = new TableDataRumah(listRumah);
        framePembeli.getTableDatarRumah().setModel(TDR);
    }
    
    
    
    public void Search(){
        if (!framePembeli.getTextFieldNama().getText().trim().isEmpty() 
                && !framePembeli.getTextFieldHarga().getText().trim().isEmpty() 
                && !framePembeli.getTextFieldJumlahKamar().getText().trim().isEmpty()) {
            
            String Alamat = framePembeli.getTextFieldNama().getText();
            int JumlahKamar = Integer.parseInt(framePembeli.getTextFieldHarga().getText());
            double Harga = Double.parseDouble(framePembeli.getTextFieldJumlahKamar().getText());
            
            isiTableCariRumah(Alamat, JumlahKamar, Harga);
        } else if(!framePembeli.getTextFieldNama().getText().isEmpty() 
                && framePembeli.getTextFieldHarga().getText().isEmpty() 
                && framePembeli.getTextFieldJumlahKamar().getText().isEmpty()){
            
            String Alamat = framePembeli.getTextFieldNama().getText();
            int JumlahKamar = 999999;
            double Harga = 9999999;
            
            isiTableCariRumah(Alamat, JumlahKamar, Harga);
            
        } else if(framePembeli.getTextFieldNama().getText().isEmpty() 
                && !framePembeli.getTextFieldHarga().getText().isEmpty() 
                && framePembeli.getTextFieldJumlahKamar().getText().isEmpty()){
            
            double Harga = Double.parseDouble(framePembeli.getTextFieldHarga().getText());
            
            isiTableCariRumahHarga(Harga);
            
        } else if(framePembeli.getTextFieldNama().getText().isEmpty() 
                && framePembeli.getTextFieldHarga().getText().isEmpty() 
                && !framePembeli.getTextFieldJumlahKamar().getText().isEmpty()){
            
            
            int JumlahKamar = Integer.parseInt(framePembeli.getTextFieldJumlahKamar().getText());
            isiTableCariRumahJumlahKamar(JumlahKamar);
            
            
        }else {
            JOptionPane.showMessageDialog(frameAdmin, "Tidak inputan yang diterima kosng");
        }
    }
}
