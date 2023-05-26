package tp.tubespbo;

public class Form{
    
    private String idForm ;
    private String username;
    private String idRumah ;
    private String namaRumah ;
    private String idPembeli;
    private String waktuJanjian ;
    private String lokasiJanjian ;

    public Form(String idRumah, String namaRumah, String waktuJanjian, String lokasiJanjian) {
        this.idForm = null;
        this.username = null;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = null;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    /*
    public Form( String idRumah, String namaRumah, String idPembeli, String waktuJanjian, String lokasiJanjian) {
        this.idForm = idForm;
        this.idRumah = idRumah;
        this.namaRumah = namaRumah;
        this.idPembeli = idPembeli;
        this.waktuJanjian = waktuJanjian;
        this.lokasiJanjian = lokasiJanjian;
    }*/

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getIdRumah() {
        return idRumah;
    }

    public void setIdRumah(String idRumah) {
        this.idRumah = idRumah;
    }

    public String getNamaRumah() {
        return namaRumah;
    }

    public void setNamaRumah(String namaRumah) {
        this.namaRumah = namaRumah;
    }

    public String getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public String getWaktuJanjian() {
        return waktuJanjian;
    }

    public void setWaktuJanjian(String waktuJanjian) {
        this.waktuJanjian = waktuJanjian;
    }

    public String getLokasiJanjian() {
        return lokasiJanjian;
    }

    public void setLokasiJanjian(String lokasiJanjian) {
        this.lokasiJanjian = lokasiJanjian;
    }            
}
