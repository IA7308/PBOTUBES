package DataAccessObject;

import Model.*;
import java.util.List;

public interface iPembeliDao {
    public List<DataRumah> getRumah(int id);
    public List<Form> insertForm(Form form);
    public List<Pembeli> getAllPembeli();
    public List<DataRumah> getAllRumah();
    public List<Form> getForm(int id);
    public List<Form> getAllForm();   
}
