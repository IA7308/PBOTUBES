package tp.tubespbo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Promosi {
    
    private String idPembeli;
    private String idAgensi;
    private String idPromosi ;
    public String promosi ;
    private LocalDateTime waktuPromosi ;

    public Promosi(String idPromosi,String idPembeli, String idAgensi, String promosi) {
        this.idPembeli = idPembeli;
        this.idAgensi = idAgensi;
        this.idPromosi = idPromosi;
        this.promosi = promosi;
        this.waktuPromosi = LocalDateTime.now();
    }
    
    public Promosi(String idPembeli, String idAgensi, String promosi) {
        this.idPembeli = idPembeli;
        this.idAgensi = idAgensi;
        this.idPromosi = null;
        this.promosi = promosi;
        this.waktuPromosi = LocalDateTime.now();
    }
    
    public Promosi(){}

    public LocalDateTime getWaktuPromosi() {
        return waktuPromosi;
    }

    public void setWaktuPromosi() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        this.waktuPromosi = LocalDateTime.parse(formattedDateTime, formatter);
    }

    public String getIdPembeli() {
        return idPembeli;
    }

    public String getIdAgensi() {
        return idAgensi;
    }

    
    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public void setIdAgensi(String idAgensi) {
        this.idAgensi = idAgensi;
    }

    
    public String getIdPromosi() {
        return idPromosi;
    }

    public void setIdPromosi(String idPromosi) {
        this.idPromosi = idPromosi;
    }

    public String getPromosi() {
        return promosi;
    }

    public void setPromosi(String promosi) {
        this.promosi = promosi;
    }
    
}
