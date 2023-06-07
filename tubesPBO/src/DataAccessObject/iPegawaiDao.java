package DataAccessObject;

import java.util.List;

import Model.*;

public interface iPegawaiDao {
    public void insertRumah(DataRumah rumah);
    public void insertKodeAgensi(String KodeAgensi);
    public void update(DataRumah rumah);
    public void delete(int idx);
    public List<DataRumah> getRumah(int id);
    public List<DataRumah> getAllRumah();
    public List<Pegawai> getAllPegawai();
    public List<Form> getForm(int id);
    public List<Form> getAllForm();
    
}
