package DataAccessObject;

import Model.Agensi;
import Model.DataRumah;
import Model.Form;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgensiDao implements iAgensiDao{

    List<Agensi> listAgen;
    List<DataRumah> listRumah;
    List<Form> listForm;
    
    @Override
    public void insertRumahAgensi(DataRumah rumah) {
        String sql; 
        sql = "INSERT INTO RumahPengajuan (idRumah, alamat, namaRumah, Description, harga, JmlhKamar, LuasBangunan, LuasTanah, jmlhParkir, jmlhLanatai, jmlhToilet) " 
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
                Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Agensi> getAllAgensi() {
        listAgen = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM agensi");
            
            while (result.next()) {  // selama masih ada datanya 
                Agensi agen  = new Agensi();
                // salin ke class kotak
                agen.setKodeAgensi(result.getString("KodeAgensi"));
                agen.setPassword(result.getString("Password"));
                agen.setUsername(result.getString("Username"));
                agen.setRegistered(result.getBoolean("Registered"));
                // masukkan kotak ke dalam list
                listAgen.add(agen);
            }
            statement.close();
            result.close();
            // connection tidak perlu di close 
            
            // menghasilkan list kotak yang berisikan tabel kotak
            return listAgen;
        } catch (SQLException ex) {
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<DataRumah> getAllRumahAgensi(Agensi agen) {
        listRumah = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM rumah WHERE idRumah like '%"+ agen.getKodeAgensi() + "'";
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
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Form> getFormAgensi(Agensi agen) {
        listForm = new ArrayList<>();
        Statement statement;
        String sql = "SELECT * FROM form WHERE id= "+ agen.getKodeAgensi();
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
