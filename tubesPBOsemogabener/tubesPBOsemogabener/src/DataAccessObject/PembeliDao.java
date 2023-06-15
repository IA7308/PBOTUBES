package DataAccessObject;

import Model.Agensi;
import Model.DataRumah;
import Model.Form;
import Model.Pegawai;
import Model.Pembeli;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PembeliDao implements iPembeliDao{

    List<Agensi> listAgen;
    List<Pegawai> listPegawai;
    List<Pembeli> listPembeli;
    List<DataRumah> listRumah;
    List<Form> listForm;
    
    public List<DataRumah> getRumah(String Alamat, int jumlahKamar, double harga) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE alamatRumah LIKE '%" + Alamat +"%' AND jumlahKamar < "+ jumlahKamar +" AND `hargaRumah (juta)` < " + harga;
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
            Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public void insertForm(Form form) {
        String sql = "INSERT INTO form (idForm, unamePembeli, idRumah, namaRumah, idPembeli, tanggalJanjian, waktuJanjian, lokasiJanjian, statusPengajuan) " 
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, form.getIdForm());
            statement.setString(2, form.getUsername());
            statement.setInt(3, form.getIdRumah());
            statement.setString(4, form.getNamaRumah());
            statement.setString(5, form.getIdPembeli());
            statement.setString(6, form.getTanggalJanjian());
            statement.setString(7, form.getWaktuJanjian());
            statement.setString(8, form.getLokasiJanjian());
            statement.setString(9, form.getStatus());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Pembeli> getAllPembeli() {
        listPembeli = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM pembeli");
            
            while (result.next()) {  // selama masih ada datanya 
                Pembeli pembeli  = new Pembeli();
                // salin ke class kotak
                pembeli.setNoHP(result.getString(3));
                pembeli.setEmail(result.getString(2));                
                pembeli.setUsername(result.getString(4));
                pembeli.setPassword(result.getString(5));
                pembeli.setIdPembeli(result.getString(1));
                //pembeli.setFormList((ArrayList<Form>) getForm(pembeli));
                // masukkan kotak ke dalam list
                listPembeli.add(pembeli);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listPembeli;
        } catch (SQLException ex) {
            Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Form> getForm(Pembeli pembeli) {
        listForm = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM form WHERE idPembeli="+ pembeli.getIdPembeli();
        try {
            statement = DBConnection.getConnection().createStatement();
            
            try (ResultSet result = statement.executeQuery(sql)) {
                
                while (result.next()) { // kalau ada 
                    
                    Form form = new Form();
                    // salin ke class kotak
                    form.setIdForm(result.getString(2));
                    form.setIdRumah(result.getInt(3));
                    form.setIdPembeli(result.getString(4));
                    form.setLokasiJanjian(result.getString(5));
                    form.setNamaRumah(result.getString(6));
                    form.setUsername(result.getString(7));
                    form.setWaktuJanjian(result.getString(8));
                    form.setStatus(result.getString(9));
                    // tambahkan ke dalam list
                    listForm.add(form);
                }
                statement.close();
            }
            return listForm;
        } catch (SQLException e) {
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<DataRumah> getRumah(int jumlahKamar) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE jumlahKamar < "+ jumlahKamar;
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
            Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<DataRumah> getRumah(double harga) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE `hargaRumah (juta)` < " + harga;
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
            Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
