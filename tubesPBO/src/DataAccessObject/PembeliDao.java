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
    
    @Override
    public List<DataRumah> getRumah(String idRumah) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE idRumah= "+ idRumah;
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
            Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void insertForm(Form form) {
        String sql = "INSERT INTO form (idForm, username, idRumah, namaRumah, idPembeli, waktuJanjian, lokasiJanjian, status) " 
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, form.getIdForm());
            statement.setString(2, form.getUsername());
            statement.setString(3, form.getIdRumah());
            statement.setString(4, form.getNamaRumah());
            statement.setString(5, form.getIdPembeli());
            statement.setString(6, form.getWaktuJanjian());
            statement.setString(7, form.getLokasiJanjian());
            statement.setBoolean(8, form.isStatus());
            
            statement.executeUpdate();
            
            } catch (SQLException e) {
                Logger.getLogger(PembeliDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Pembeli> getAllPembeli() {
        listPembeli = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM pembeli");
            
            while (result.next()) {  // selama masih ada datanya 
                Pembeli pembeli  = new Pembeli();
                // salin ke class kotak
                pembeli.setNoHP(result.getLong("NoHP"));
                pembeli.setPassword(result.getString("Password"));
                pembeli.setUsername(result.getString("Username"));
                pembeli.setEmail(result.getString("Email"));
                pembeli.setFormList((ArrayList<Form>) getForm(pembeli));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Form> getForm(Pembeli pembeli) {
        listForm = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM form WHERE idPembeli like '%"+ pembeli.getIdPembeli() +"'";
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
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
