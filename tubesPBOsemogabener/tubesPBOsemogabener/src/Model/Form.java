package Model;

public class Form {
    private String idForm ;
    private String username;
    private int idRumah ;
    private String namaRumah ;
    private String idPembeli;
    private String TanggalJanjian;
    private String waktuJanjian ;
    private String lokasiJanjian ;
    private String status ;

    public Form(int idRumah, String namaRumah, String waktuJanjian, String lokasiJanjian) {
        this.idForm = null;
        this.username = null;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = null;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
    }
    
    public Form(String idForm, String username, int idRumah, String namaRumah, String idPembeli, String waktuJanjian, String lokasiJanjian, String status) {
        this.idForm = idForm;
        this.username = username;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = idPembeli;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Form() {}

    public String getTanggalJanjian() {
        return TanggalJanjian;
    }

    public void setTanggalJanjian(String TanggalJanjian) {
        this.TanggalJanjian = TanggalJanjian;
    }
      
    public String getIdForm() {
        return idForm;
    }

    public String getUsername() {
        return username;
    }

    public int getIdRumah() {
        return idRumah;
    }

    public String getNamaRumah() {
        return namaRumah;
    }

    public String getIdPembeli() {
        return idPembeli;
    }

    public String getWaktuJanjian() {
        return waktuJanjian;
    }

    public String getLokasiJanjian() {
        return lokasiJanjian;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdRumah(int idRumah) {
        this.idRumah = idRumah;
    }

    public void setNamaRumah(String namaRumah) {
        this.namaRumah = namaRumah;
    }

    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public void setWaktuJanjian(String waktuJanjian) {
        this.waktuJanjian = waktuJanjian;
    }

    public void setLokasiJanjian(String lokasiJanjian) {
        this.lokasiJanjian = lokasiJanjian;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
