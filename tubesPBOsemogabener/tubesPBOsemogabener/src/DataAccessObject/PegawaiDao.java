package DataAccessObject;

import Model.Agensi;
import Model.DataRumah;
import Model.Form;
import Model.Pegawai;
import Model.Pembeli;
import Model.WaktuTersediaForm;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiDao implements iPegawaiDao {

    List<Agensi> listAgen;
    List<Pegawai> listPegawai;
    List<DataRumah> listRumah;
    List<Form> listForm;
    List<WaktuTersediaForm> listWaktu;
    List<String> listKodeAgensi;
    List<String> listNamaAgensi;
    List<DataRumah> listRumahPengajuan;
    
    @Override
    public void insertRumah(DataRumah rumah) {
        String sql = "INSERT INTO rumah (idRumah, KodeAgensi, alamatRumah, namaRumah, deskripsiRumah, `hargaRumah (juta)`, jumlahKamar, luasBangunan, luasTanah, jumlahParkir, jumlahLantai, jumlahToilet) " 
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, rumah.getIdRumah());
            statement.setString(2, rumah.getKodeAgensi());
            statement.setString(3, rumah.getAlamat());
            statement.setString(4, rumah.getNamaRumah());
            statement.setString(5, rumah.getDescription());
            statement.setDouble(6, rumah.getHarga());
            statement.setInt(7, rumah.getJmlhKamar());
            statement.setInt(8, rumah.getLuasBangunan());
            statement.setInt(9, rumah.getLuasTanah());
            statement.setInt(10, rumah.getJmlhParkir());
            statement.setInt(11, rumah.getJmlhLantai());
            statement.setInt(12, rumah.getJmlhToilet());
            
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void insertKodeAgensi(String KodeAgensi, String namaAgensi) {
        String sql = "INSERT INTO agensi (idAgensi, namaAgensi) " 
               + "VALUES (?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, KodeAgensi);
            statement.setString(2, namaAgensi);
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void updateFormStatus(Form form) {
        String sql = "UPDATE form SET statusPengajuan=? WHERE idForm=?";
        try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, form.getStatus());
            statement.setString(2, form.getIdForm());
            
            
            statement.executeUpdate();
        } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(int idRumah) {
        String sql = "DELETE FROM rumah WHERE idRumah=?";
        PreparedStatement statement;
        try {
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, idRumah);
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<DataRumah> getRumah(int idRumah) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE id= "+ idRumah;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    DataRumah rumah = new DataRumah();
                    // salin ke class kotak
                    rumah.setIdRumah(result.getInt(1));
                    rumah.setKodeAgensi(result.getString(2));
                    rumah.setAlamat(result.getString(3)); 
                    rumah.setNamaRumah(result.getString(4)); 
                    rumah.setDescription(result.getString(5));
                    rumah.setHarga(result.getDouble(6));
                    rumah.setJmlhKamar(result.getInt(7));
                    rumah.setLuasBangunan(result.getInt(8));
                    rumah.setLuasTanah(result.getInt(9));
                    rumah.setJmlhParkir(result.getInt(10));
                    rumah.setJmlhLantai(result.getInt(11));
                    rumah.setJmlhToilet(result.getInt(12));
                    // tambahkan ke dalam list
                    listRumah.add(rumah);
                }
                statement.close();
            }
            return listRumah;
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<DataRumah> getAllRumah() {
        listRumah = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM rumah");
            
            while (result.next()) {  // selama masih ada datanya 
                DataRumah rumah = new DataRumah();
                    // salin ke class kotak
                    rumah.setIdRumah(result.getInt(1));
                    rumah.setKodeAgensi(result.getString(2));
                    rumah.setAlamat(result.getString(3)); 
                    rumah.setNamaRumah(result.getString(4)); 
                    rumah.setDescription(result.getString(5));
                    rumah.setHarga(result.getDouble(6));
                    rumah.setJmlhKamar(result.getInt(7));
                    rumah.setLuasBangunan(result.getInt(8));
                    rumah.setLuasTanah(result.getInt(9));
                    rumah.setJmlhParkir(result.getInt(10));
                    rumah.setJmlhLantai(result.getInt(11));
                    rumah.setJmlhToilet(result.getInt(12));
                    // tambahkan ke dalam list
                    listRumah.add(rumah);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listRumah;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Pegawai> getAllPegawai() {
        listPegawai = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM pegawai");
            
            while (result.next()) {  // selama masih ada datanya 
                Pegawai pegawai = new Pegawai();
                    // salin ke class kotak                    ;
                    pegawai.setUsername(result.getString(1)); 
                    pegawai.setPassword(result.getString(2));
                    
                    listPegawai.add(pegawai);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listPegawai;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Form> getForm(String idForm) {
        listForm = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM form WHERE idForm= '"+ idForm +"'";
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    Form form = new Form();
                    // salin ke class kotak
                    form.setIdForm(result.getString(2));
                    form.setIdRumah(result.getInt(4));
                    form.setIdPembeli(result.getString(6));
                    form.setTanggalJanjian(result.getString(7));
                    form.setNamaRumah(result.getString(5));
                    form.setUsername(result.getString(3));
                    form.setWaktuJanjian(result.getString(8));
                    form.setLokasiJanjian(result.getString(9));
                    form.setStatus(result.getString(10));
                    // tambahkan ke dalam list
                    listForm.add(form);
                }
                statement.close();
            }
            return listForm;
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Form> getAllForm() {
        listForm = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM form");

            while (result.next()) {  // selama masih ada datanya 
                Form form = new Form();
                // salin ke class kotak
                form.setIdForm(result.getString(2));
                form.setIdRumah(result.getInt(4));
                form.setIdPembeli(result.getString(6));
                form.setTanggalJanjian(result.getString(7));
                form.setNamaRumah(result.getString(5));
                form.setUsername(result.getString(3));
                form.setWaktuJanjian(result.getString(8));
                form.setLokasiJanjian(result.getString(9));
                form.setStatus(result.getString(10));
                // tambahkan ke dalam list
                listForm.add(form);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listForm;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    

    @Override
    public void insertAgen(Agensi agen) {
        String sql = "INSERT INTO Agen (KodeAgensi, unameAgen, pwAgen) " 
               + "VALUES (?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(2, agen.getUsername());
            statement.setString(3, agen.getPassword());
            statement.setString(1, agen.getKodeAgensi());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void insertPembeli(Pembeli pembeli) {
        String sql = "INSERT INTO pembeli (idPembeli, emailPembeli, noHPPembeli, unamePembeli, pwPembeli) " 
               + "VALUES (?, ?, ?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, pembeli.getIdPembeli());
            statement.setString(4, pembeli.getUsername());
            statement.setString(5, pembeli.getPassword());
            statement.setString(2, pembeli.getEmail());
            statement.setString(3, pembeli.getNoHP());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void insertWaktuJanjian(WaktuTersediaForm waktu) {
        String sql = "INSERT INTO waktuform (jadwal, kode_agen) " 
               + "VALUES (?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, waktu.getWaktuTersedia());
            statement.setString(2, waktu.getKodeAgensi());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<WaktuTersediaForm> getAllWaktuJanjian() {
        listWaktu = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM waktuform");
            
            while (result.next()) {  // selama masih ada datanya 
                WaktuTersediaForm waktu = new WaktuTersediaForm();
                // salin ke class kotak
                waktu.setWaktuTersedia(result.getString(2));
                waktu.setKodeAgensi(result.getString(3));
                
                // tambahkan ke dalam list
                listWaktu.add(waktu);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listWaktu;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<String> getAllKodeAgensi() {
        listKodeAgensi = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT idAgensi FROM agensi");
            
            while (result.next()) {  // selama masih ada datanya 
                String Kode = result.getString(1);
                                              
                // tambahkan ke dalam list
                listKodeAgensi.add(Kode);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listKodeAgensi;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<Agensi> getAllAgensi() {
        listAgen = new ArrayList<>();
        Statement statement;
        String sql = "select * from agen";
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {  // selama masih ada datanya 
                Agensi agen  = new Agensi();
                // salin ke class kotak
                agen.setKodeAgensi(result.getString(2));
                agen.setUsername(result.getString(3));
                agen.setPassword(result.getString(4));                
                agen.setRegistered(true);
                // masukkan kotak ke dalam list
                listAgen.add(agen);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listAgen;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<DataRumah> getAllRumahPengajuan() {
        listRumahPengajuan = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM pengajuandatarumah");

            while (result.next()) { // kalau ada 

                DataRumah rumah = new DataRumah();
                // salin ke class kotak
                rumah.setIdRumah(result.getInt(1));
                rumah.setKodeAgensi(result.getString(2));
                rumah.setAlamat(result.getString(3));
                rumah.setNamaRumah(result.getString(4));
                rumah.setDescription(result.getString(5));
                rumah.setHarga(result.getDouble(6));
                rumah.setJmlhKamar(result.getInt(7));
                rumah.setLuasBangunan(result.getInt(8));
                rumah.setLuasTanah(result.getInt(9));
                rumah.setJmlhParkir(result.getInt(10));
                rumah.setJmlhLantai(result.getInt(11));
                rumah.setJmlhToilet(result.getInt(12));
                // tambahkan ke dalam list

                listRumahPengajuan.add(rumah);

            }
            statement.close();

            return listRumahPengajuan;
        } catch (SQLException e) {
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void deleteWaktu(String waktu) {
        String sql = "DELETE FROM waktuform WHERE jadwal=?";
        PreparedStatement statement;
        try {
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, waktu);
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<String> getAllNamaAgensi() {
        listNamaAgensi = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT namaAgensi FROM agensi");
            
            while (result.next()) {  // selama masih ada datanya 
                String Kode = result.getString(1);
                                              
                // tambahkan ke dalam list
                listNamaAgensi.add(Kode);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listNamaAgensi;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Form> getFormId(String idPembeli) {
        listForm = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM form WHERE idPembeli='" + idPembeli + "'";
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    Form form = new Form();
                    // salin ke class kotak
                    form.setIdForm(result.getString(2));
                    form.setIdRumah(result.getInt(4));
                    form.setIdPembeli(result.getString(6));
                    form.setTanggalJanjian(result.getString(7));
                    form.setNamaRumah(result.getString(5));
                    form.setUsername(result.getString(3));
                    form.setWaktuJanjian(result.getString(8));
                    form.setLokasiJanjian(result.getString(9));
                    form.setStatus(result.getString(10));
                    // tambahkan ke dalam list
                    listForm.add(form);
                }
                statement.close();
            }
            return listForm;
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
