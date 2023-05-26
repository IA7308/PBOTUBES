package tp.tubespbo;

public class DataRmh {
    private String idRumah ;
    private String alamat;
    private String namaRumah;
    private String Description;
    private double harga;
    private int JmlhKamar;
    private int LuasBangunan;
    private int LuasTanah;
    private int JmlhParkir;
    private int JmlhLantai;
    private int JmlhToilet;
    
    public DataRmh(String idRumah,String alamat, String namaRumah, String Description, double harga, int JmlhKamar, int LuasBangunan, int LuasTanah, int JmlhParkir, int JmlhLantai, int JmlhToilet){
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
    }

    public DataRmh(String alamat, String namaRumah, String Description, double harga, int JmlhKamar, int LuasBangunan, int LuasTanah, int JmlhParkir, int JmlhLantai, int JmlhToilet){
        this.idRumah = null ;
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
    }
    
    public String getIdRumah() {
        return idRumah;
    }

    public void setIdRumah(String idRumah) {
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
    
    public DataRmh(){}
}
