package Model;

public class Form {
    private String idForm ;
    private String username;
    private String idRumah ;
    private String namaRumah ;
    private String idPembeli;
    private String waktuJanjian ;
    private String lokasiJanjian ;
    private boolean status ;

    public Form(String idRumah, String namaRumah, String waktuJanjian, String lokasiJanjian) {
        this.idForm = null;
        this.username = null;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = null;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
    }
    
    public Form(String idForm, String username, String idRumah, String namaRumah, String idPembeli, String waktuJanjian, String lokasiJanjian, boolean status) {
        this.idForm = idForm;
        this.username = username;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = idPembeli;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
        this.status = status;
    }

    public Form() {}
    
    
    public String getIdForm() {
        return idForm;
    }

    public String getUsername() {
        return username;
    }

    public String getIdRumah() {
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

    public void setIdRumah(String idRumah) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
