package tp.tubespbo;

public class Agensi extends Pegawai  {
    
    private String password;
    private String username;
    private String kodeAgensi;
    protected DataRmh[] DataRumah;
    private Pembeli[] listPembeli;
    private Promosi[] listPromosi;
    private Form[] listForm;
    private Object Promosi;

    
    public Agensi(String password, String username, DataRmh[] DataRumah, String KodeAgensi, Promosi[] listPromosi){
        this.username = username;   
        this.password = password;
        this.kodeAgensi = KodeAgensi;
        this.DataRumah = DataRumah;
        /*for(int i = 0;i<this.DataRumah.length; i++){
            String idRumah = this.kodeAgensi + "00" + (i+1);
            this.DataRumah[i].setIdRumah(idRumah);
        }*/
        this.listForm = null;
        this.listPromosi = listPromosi ;
    }
    
    
    public Agensi(){}
    
    @Override
    public void register(String username, String Pasword, String KodeAgensi){
        for(int i = 0; i<super.ListKodeAgensi.length; i++){
            if(super.ListKodeAgensi[i].equals(KodeAgensi)){
                this.username = username;
                this.password = Pasword;
                this.kodeAgensi = KodeAgensi;
                System.out.println("Akun " + this.username + " berhasil ter-registrasi");
            }else{
                System.out.println("Username atau Password tidak tersedia");
            }    
        }      
    }
    
    
    public boolean Login(String username, String password, String KodeAgensi){
        if(username.equals(this.username) && password.equals(this.password) && KodeAgensi.equals(this.kodeAgensi)){
            System.out.println("Anda berhasil Login sebagai Agensi, " + this.username);
            return true;
        }else{
            System.out.println("Username atau Password tidak tersedia");
            return false;
        }
    }

    @Override
    public DataRmh[] getDataRumah() {
        return DataRumah;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDataRumah(DataRmh[] DataRumah) {
        this.DataRumah = DataRumah;
    }
       
    @Override
    public void lihatDataRumah(){
        for(int i = 0; i<this.DataRumah.length; i++){
            String Kode = this.kodeAgensi + "00" + (i+1);
            if(this.DataRumah[i].getIdRumah().equals(Kode)){
                System.out.println("Id RUmah : " + this.DataRumah[i].getIdRumah());
                System.out.println(this.DataRumah[i].getNamaRumah());
                System.out.println("Alamat : " + this.DataRumah[i].getAlamat());
                System.out.println("Harga : Rp" + (int)this.DataRumah[i].getHarga());
                System.out.println("Kamar : " + this.DataRumah[i].getJmlhKamar() + ", Luas Bangunan : " 
                        + this.DataRumah[i].getLuasBangunan() +"m\u00B2, Luas Tanah : " 
                        + this.DataRumah[i].getLuasTanah() + "m\u00B2");
                System.out.println(this.DataRumah[i].getNamaRumah() + " " + this.DataRumah[i].getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + this.DataRumah[i].getJmlhParkir() + "\t Jumlah Lantai " +  this.DataRumah[i].getJmlhLantai());
                System.out.println("Jumlah Toilet : " + this.DataRumah[i].getJmlhToilet());
            }
        }
    }

    @SuppressWarnings("empty-statement")
    public void addPromosi(Promosi historyPromosi) {
        Promosi[] tempHistoryPromosi = {historyPromosi};
        if(listPromosi != null){
            Promosi[] temp = new Promosi[listPromosi.length + tempHistoryPromosi.length];
            for (int i = 0; i < listPromosi.length; i++) {
                temp[i] = listPromosi[i];
            }
            for (int i = 0; i < tempHistoryPromosi.length; i++) {
                temp[listPromosi.length + i] = tempHistoryPromosi[i];
            }
            this.listPromosi = temp;
            
            for(int i = 0;i<this.listPromosi.length; i++){
                if (this.listPromosi[i].getIdPromosi() == null) { // Memeriksa jika idRumah belum terisi
                    String idPromosi = this.kodeAgensi + "P00" + (i+1);
                    this.listPromosi[i].setIdPromosi(idPromosi);
                }
            }
        }else{
            this.listPromosi = tempHistoryPromosi;          
        }
//        if(Promotions != null){
//            String[] newChatBox = new String[Promotions.length + Chat.length];
//            for (int i = 0; i < Promotions.length; i++) {
//                newChatBox[i] = Promotions[i];
//            }
//            for (int i = 0; i < Chat.length; i++) {
//                newChatBox[Promotions.length + i] = Chat[i];
//            }
//            Promotions = newChatBox;
//            for(int i = 0; i<this.Promotions.length; i++){
//                System.out.println("Agensi " + this.username + " : " + Promotions[i]);
//            }
//        }else{
//            Promotions = Chat;
//            System.out.println("Agensi " + this.username + " : " + Pesan);
//        }
    }

    public Promosi[] getListPromosi() {
        return listPromosi;
    }
    
    
    public void lihatHistoryPromosi(String idAgensi){
        if(listPromosi != null){
            for(int i = 0 ; i <  listPromosi.length ; i++){
            if(idAgensi.equals(listPromosi[i].getIdAgensi())){
                System.out.println("Waktu Promosi Dikirimkan : " + listPromosi[i].getWaktuPromosi());
                System.out.println("Isi Pesan Promosi : " );
                System.out.println(listPromosi[i].getPromosi());
                System.out.println("Untuk pembeli dengan id : " + listPromosi[i].getIdPembeli());
            }
        }
        }else {
            System.out.println("Anda belum pernah memberikan promosi kepada pembeli");
        }
        
    }
  
    @Override
    public void uploadDataRumah(DataRmh dataRumah){
        DataRmh[] tempDataRumah = {dataRumah};
        if(DataRumah != null){
            DataRmh[] temp = new DataRmh[DataRumah.length + tempDataRumah.length];
            for (int i = 0; i < DataRumah.length; i++) {
                temp[i] = DataRumah[i];
            }
            for (int i = 0; i < tempDataRumah.length; i++) {
                temp[DataRumah.length + i] = tempDataRumah[i];
            }
            this.DataRumah = temp;
            for(int i = 0;i<this.DataRumah.length; i++){
                if (this.DataRumah[i].getIdRumah() == null) { // Memeriksa jika idRumah belum terisi
                    String idRumah = this.kodeAgensi + "00" + (i+1);
                    this.DataRumah[i].setIdRumah(idRumah);
                }
            }
        }else{
            this.DataRumah = tempDataRumah;            
        }
    }

    public String getKodeAgensi() {
        return kodeAgensi;
    }
    
    public boolean cariIdPembeli(Pembeli[] listPembeli,String idPembeliPromosi){
        
        boolean found = false ;
        for(int i = 0 ; i < listPembeli.length ; i++ ){
            if(idPembeliPromosi.equals(listPembeli[i].getIdPembeli())){
                found = true ;
            }
        }
        return found ;
    }

    public Pembeli[] getListPembeli() {
        return listPembeli;
    }

    public void setListPembeli(Pembeli[] listPembeli) {
        this.listPembeli = listPembeli;
    }

    public void setListForm(Form[] listForm) {
        this.listForm = listForm;
    }        
    
}
