package DataAccessObject;

import java.util.List;

import Model.*;

public interface iPegawaiDao {
    public void insertRumah(DataRumah rumah);
    public void insertKodeAgensi(String KodeAgensi, String namaAgensi);
    public void insertAgen(Agensi agen);
    public void insertPembeli(Pembeli pembeli);
    public void insertWaktuJanjian(WaktuTersediaForm waktu);
    public void updateFormStatus(Form form);
    public void delete(int idRumah);
    public void deleteWaktu(String waktu);
    public List<DataRumah> getRumah(int idRumah);
    public List<DataRumah> getAllRumah();
    public List<Pegawai> getAllPegawai();
    public List<Form> getForm(String idForm);
    public List<Form> getAllForm();
    public List<Form> getFormId(String idPembeli);
    public List<WaktuTersediaForm> getAllWaktuJanjian();
    public List<String> getAllKodeAgensi();
    public List<Agensi> getAllAgensi();
    public List<DataRumah> getAllRumahPengajuan();
    public List<String> getAllNamaAgensi();
}
