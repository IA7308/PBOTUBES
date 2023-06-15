package Model;

public class WaktuTersediaForm {
    private String waktuTersedia;
    private String KodeAgensi;

    public WaktuTersediaForm() {
    }

    public WaktuTersediaForm(String waktuTersedia) {
        this.waktuTersedia = waktuTersedia;
    }
    
    public String getWaktuTersedia() {
        return waktuTersedia;
    }

    public String getKodeAgensi() {
        return KodeAgensi;
    }

    public void setKodeAgensi(String KodeAgensi) {
        this.KodeAgensi = KodeAgensi;
    }

    public void setWaktuTersedia(String waktuTersedia) {
        this.waktuTersedia = waktuTersedia;
    }
}
