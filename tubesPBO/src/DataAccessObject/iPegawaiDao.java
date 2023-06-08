package DataAccessObject;

import java.util.List;

import Model.*;

public interface iPegawaiDao {
    public void insertRumah(DataRumah rumah);
    public void insertKodeAgensi(String KodeAgensi);
    public void update();
    public void delete(String idRumah);
    public List<DataRumah> getRumah(String idRumah);
    public List<DataRumah> getAllRumah();
    public List<Pegawai> getAllPegawai();
    public List<Form> getForm(String idForm);
    public List<Form> getAllForm();
    
}
