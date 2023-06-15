package Model;

public class DataRumah {
    private int idRumah ;
    private String alamat;
    private String namaRumah;
    private String Description;
    private String KodeAgensi;
    private double harga;
    private int JmlhKamar;
    private int LuasBangunan;
    private int LuasTanah;
    private int JmlhParkir;
    private int JmlhLantai;
    private int JmlhToilet;
    
    public DataRumah(int idRumah,String alamat, String namaRumah, String Description, double harga, int JmlhKamar, int LuasBangunan, int LuasTanah, int JmlhParkir, int JmlhLantai, int JmlhToilet){
        this.idRumah = idRumah ;
        this.alamat = alamat;
        this.namaRumah = namaRumah;
        this.Description = Description;
        this.harga = harga;
        this.LuasTanah = LuasTanah;
        this.LuasBangunan = LuasBangunan;
        this.JmlhKamar = JmlhKamar;
        this.JmlhParkir = JmlhParkir;
        this.JmlhLantai = JmlhLantai;
        this.JmlhToilet = JmlhToilet;
        this.KodeAgensi = null;
    }

    public DataRumah(String alamat, String namaRumah, String Description, double harga, int JmlhKamar, int LuasBangunan, int LuasTanah, int JmlhParkir, int JmlhLantai, int JmlhToilet){
        this.idRumah = 0 ;
        this.alamat = alamat;
        this.namaRumah = namaRumah;
        this.Description = Description;
        this.harga = harga;
        this.LuasTanah = LuasTanah;
        this.LuasBangunan = LuasBangunan;
        this.JmlhKamar = JmlhKamar;
        this.JmlhParkir = JmlhParkir;
        this.JmlhLantai = JmlhLantai;
        this.JmlhToilet = JmlhToilet;
        this.KodeAgensi = null;
    }

    public String getKodeAgensi() {
        return KodeAgensi;
    }

    public void setKodeAgensi(String KodeAgensi) {
        this.KodeAgensi = KodeAgensi;
    }
    
    
    public int getIdRumah() {
        return idRumah;
    }

    public void setIdRumah(int idRumah) {
        this.idRumah = idRumah;
    }
    

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJmlhToilet() {
        return JmlhToilet;
    }

    public void setJmlhToilet(int JmlhToilet) {
        this.JmlhToilet = JmlhToilet;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaRumah() {
        return namaRumah;
    }

    public void setNamaRumah(String namaRumah) {
        this.namaRumah = namaRumah;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getJmlhKamar() {
        return JmlhKamar;
    }

    public void setJmlhKamar(int JmlhKamar) {
        this.JmlhKamar = JmlhKamar;
    }

    public int getLuasBangunan() {
        return LuasBangunan;
    }

    public void setLuasBangunan(int LuasBangunan) {
        this.LuasBangunan = LuasBangunan;
    }

    public int getLuasTanah() {
        return LuasTanah;
    }

    public void setLuasTanah(int LuasTanah) {
        this.LuasTanah = LuasTanah;
    }

    public int getJmlhParkir() {
        return JmlhParkir;
    }

    public void setJmlhParkir(int JmlhParkir) {
        this.JmlhParkir = JmlhParkir;
    }

    public int getJmlhLantai() {
        return JmlhLantai;
    }

    public void setJmlhLantai(int JmlhLantai) {
        this.JmlhLantai = JmlhLantai;
    }
    
    public DataRumah(){}
}
