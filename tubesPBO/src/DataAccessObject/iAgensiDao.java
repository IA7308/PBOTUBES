package DataAccessObject;

import java.util.List;

import Model.*;

public interface iAgensiDao {
    public void insertRumahAgensi(DataRumah rumah);
    public List<Agensi> getAllAgensi();
    public List<DataRumah> getAllRumahAgensi(Agensi agen);
    public List<Form> getFormAgensi(Agensi agen);
}
