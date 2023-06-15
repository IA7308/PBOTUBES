package DataAccessObject;

import java.util.List;

import Model.*;

public interface iAgensiDao {
    public void insertRumahAgensi(DataRumah rumah);
    public List<Agensi> getAllAgensi();
    public List<DataRumah> getAllRumahAgensi(String KodeAgen);
    public List<DataRumah> getAllRumahPengajuan(String KodeAgen);
    public List<Form> getFormAgensi(Agensi agen);
}
