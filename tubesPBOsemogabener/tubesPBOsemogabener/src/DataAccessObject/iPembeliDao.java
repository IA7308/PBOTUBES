package DataAccessObject;

import Model.*;
import java.util.List;

public interface iPembeliDao {
    public List<DataRumah> getRumah(String Alamat, int jumlahKamar, double harga);
    public List<DataRumah> getRumah(int jumlahKamar);
    public List<DataRumah> getRumah(double harga);
    public void insertForm(Form form);
    public List<Pembeli> getAllPembeli();
    public List<DataRumah> getAllRumah();
    public List<Form> getForm(Pembeli pembeli);  
}
