package DataAccessObject;

import Model.Agensi;
import Model.DataRumah;
import Model.Form;
import Model.Pegawai;
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
    
    @Override
    public void insertRumah(DataRumah rumah) {
        String sql = "INSERT INTO rumah (idRumah, alamat, namaRumah, Description, harga, JmlhKamar, LuasBangunan, LuasTanah, jmlhParkir, jmlhLanatai, jmlhToilet) " 
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, rumah.getIdRumah());
            statement.setString(2, rumah.getAlamat());
            statement.setString(3, rumah.getNamaRumah());
            statement.setDouble(4, rumah.getHarga());
            statement.setInt(5, rumah.getJmlhKamar());
            statement.setInt(6, rumah.getLuasBangunan());
            statement.setInt(7, rumah.getLuasTanah());
            statement.setInt(8, rumah.getJmlhParkir());
            statement.setInt(9, rumah.getJmlhLantai());
            statement.setInt(10, rumah.getJmlhToilet());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void insertKodeAgensi(String KodeAgensi) {
        String sql = "INSERT INTO Agensi (KodeAgensi) " 
               + "VALUES (?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, KodeAgensi);
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update() {
        String sql = "INSERT INTO rumah " +
                        "SELECT * FROM RumahPengajuan";
        try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String idRumah) {
        String sql = "DELETE FROM rumah WHERE idRumah=?";
        PreparedStatement statement;
        try {
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, idRumah);
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<DataRumah> getRumah(String idRumah) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE id= "+ idRumah;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    DataRumah rumah = new DataRumah();
                    // salin ke class kotak
                    rumah.setIdRumah(result.getString(1)); 
                    rumah.setAlamat(result.getString(2)); 
                    rumah.setNamaRumah(result.getString(3)); 
                    rumah.setHarga(result.getDouble(4));
                    rumah.setJmlhKamar(result.getInt(5));
                    rumah.setLuasBangunan(result.getInt(6));
                    rumah.setLuasTanah(result.getInt(7));
                    rumah.setJmlhParkir(result.getInt(8));
                    rumah.setJmlhLantai(result.getInt(9));
                    rumah.setJmlhToilet(result.getInt(10));
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
                    rumah.setIdRumah(result.getString(1)); 
                    rumah.setAlamat(result.getString(2)); 
                    rumah.setNamaRumah(result.getString(3)); 
                    rumah.setHarga(result.getDouble(4));
                    rumah.setJmlhKamar(result.getInt(5));
                    rumah.setLuasBangunan(result.getInt(6));
                    rumah.setLuasTanah(result.getInt(7));
                    rumah.setJmlhParkir(result.getInt(8));
                    rumah.setJmlhLantai(result.getInt(9));
                    rumah.setJmlhToilet(result.getInt(10));
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
                    // salin ke class kotak
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
        String sql = "SELECT * FROM form WHERE idForm= "+ idForm;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    Form form = new Form();
                    // salin ke class kotak
                    form.setIdForm(result.getString(1)); 
                    form.setIdRumah(result.getString(2)); 
                    form.setIdPembeli(result.getString(3));
                    form.setLokasiJanjian(result.getString(4));
                    form.setNamaRumah(result.getString(5));
                    form.setUsername(result.getString(6));
                    form.setWaktuJanjian(result.getString(7));
                    form.setStatus(result.getBoolean(8));
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
                form.setIdForm(result.getString(1));
                form.setIdRumah(result.getString(2));
                form.setIdPembeli(result.getString(3));
                form.setLokasiJanjian(result.getString(4));
                form.setNamaRumah(result.getString(5));
                form.setUsername(result.getString(6));
                form.setWaktuJanjian(result.getString(7));
                form.setStatus(result.getBoolean(8));
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
}
