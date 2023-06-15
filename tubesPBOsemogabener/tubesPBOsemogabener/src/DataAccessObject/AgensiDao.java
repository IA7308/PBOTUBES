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
    List<DataRumah> listRumahPengajuan;
    List<Form> listForm;
    
    @Override
    public void insertRumahAgensi(DataRumah rumah) {
        String sql = "INSERT INTO pengajuandatarumah (idRumah, kodeAgensi, alamatRumah, namaRumah, deskripsiRumah, `hargaRumah (juta)`, jumlahKamar, luasBangunan, luasTanah, jumlahParkir, jumlahLantai, jumlahToilet) " 
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
                Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<DataRumah> getAllRumahAgensi(String KodeAgen) {
        listRumah = new ArrayList<>();
        Statement statement;
        try {
            statement = DBConnection.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM rumah");
                
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
                    if(rumah.getKodeAgensi().matches(KodeAgen)){
                        listRumah.add(rumah);
                    }
                    
                }
                statement.close();
            
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
        String sql = "SELECT * FROM form WHERE id= 1";
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
    public List<DataRumah> getAllRumahPengajuan(String KodeAgen) {
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
                    if(rumah.getKodeAgensi().matches(KodeAgen)){
                        listRumahPengajuan.add(rumah);
                    }
                    
                }
                statement.close();
            
            return listRumahPengajuan;
        } catch (SQLException e) {
            Logger.getLogger(AgensiDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
