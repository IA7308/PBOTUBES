package DataAccessObject;

import Model.*;
import java.util.List;

public interface iPembeliDao {
    public List<DataRumah> getRumah(String idRumah);
    public void insertForm(Form form);
    public List<Pembeli> getAllPembeli();
    public List<DataRumah> getAllRumah();
    public List<Form> getForm(Pembeli pembeli);  
}
