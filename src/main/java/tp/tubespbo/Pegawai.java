package tp.tubespbo;

public class Pegawai extends Promosi{
    
    private String password;
    private String username;
    private DataRmh[] DataRumah;
    protected String[] ListKodeAgensi;
    private Promosi[] listPromosi ;
    //private String[] ChatBox;
    
    
    public Pegawai(String username, String password){
        this.ListKodeAgensi = null;
        this.password = password;
        this.username = username;
        
    }
    
    public Pegawai(){}
    
    public void register(String username, String Pasword, String KodeAgensi){}
    
    public boolean Login(String username, String password){
        if(username.equals(this.username) && password.equals(this.password)){
            System.out.println("Anda berhasil Login sebagai Pegawai, " + this.username);
            return true;
        }else{
            System.out.println("Username atau Password tidak tersedia");
            return false;
        }
    }

    public DataRmh[] getDataRumah() {
        return DataRumah;
    }
    
    public void lihatDataRumah(){
        for(int i = 0; i<this.DataRumah.length; i++){
            System.out.println(this.DataRumah[i].getNamaRumah());
            System.out.println("Alamat : " + this.DataRumah[i].getAlamat());
            System.out.println("Harga : Rp" + (int)this.DataRumah[i].getHarga());
            System.out.println("Kamar : " + this.DataRumah[i].getJmlhKamar() + ", Luas Bangunan : " 
                    + this.DataRumah[i].getLuasBangunan() +"m\u00B2, Luas Tanah : " 
                    + this.DataRumah[i].getLuasTanah() + "m\u00B2");
            System.out.println(this.DataRumah[i].getNamaRumah() + " " + this.DataRumah[i].getDescription());
            System.out.println("Rincian ");
            System.out.println("Lahan Parkir : " + this.DataRumah[i].getJmlhParkir() + "\t Jumlah Lantai " +  this.DataRumah[i].getJmlhLantai());
        }
    }
    
    public void editDataRumah(DataRmh[] DataRumah){
        
        if(this.DataRumah != null){
        // Menghitung jumlah data yang baru ingin ditambahkan
        int newDataLength = 0;
        for (int i = 0; i < DataRumah.length; i++) {
            boolean exists = false;
            for (int j = 0; j < this.DataRumah.length; j++) {
                if (DataRumah[i].getIdRumah().equals(this.DataRumah[j].getIdRumah())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                newDataLength++;
            }
        }

        // Menambahkan data baru ke array this.DataRumah
        DataRmh[] newChatBox = new DataRmh[this.DataRumah.length + newDataLength];
        for (int i = 0; i < this.DataRumah.length; i++) {
            newChatBox[i] = this.DataRumah[i];
        }
        int newIndex = this.DataRumah.length;
        for (int i = 0; i < DataRumah.length; i++) {
            boolean exists = false;
            for (int j = 0; j < this.DataRumah.length; j++) {
                if (DataRumah[i].getIdRumah().equals(this.DataRumah[j].getIdRumah())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                newChatBox[newIndex++] = DataRumah[i];
            }
        }
        this.DataRumah = newChatBox;
    } else {
        this.DataRumah = DataRumah;
    }

        
        /*
        if(this.DataRumah!=null){
            DataRmh[] newChatBox = new DataRmh[this.DataRumah.length + DataRumah.length];
            for (int i = 0; i < this.DataRumah.length; i++) {
                newChatBox[i] = this.DataRumah[i];
            }
            for (int i = 0; i < DataRumah.length; i++) {
                newChatBox[this.DataRumah.length + i] = DataRumah[i];
            }
            this.DataRumah = newChatBox;
        }else{
            this.DataRumah = DataRumah;
        }*/
    }
    
    public void newAgensi(String Kode){
        String[] tempList = {Kode};
        //this.ListKodeAgensi = new String[];
        if(this.ListKodeAgensi != null){
            String[] TempList = new String[ListKodeAgensi.length + tempList.length];
            for (int i = 0; i < ListKodeAgensi.length; i++) {
                TempList[i] = ListKodeAgensi[i];
            }
            for (int i = 0; i < tempList.length; i++) {
                TempList[ListKodeAgensi.length + i] = tempList[i];
            }
            this.ListKodeAgensi = TempList;
        }else{
            this.ListKodeAgensi = tempList;
        }
    }
 /*
    public void chat(String Pesan){
        String[] Chat = {Pesan};
        if(ChatBox != null){
            String[] newChatBox = new String[ChatBox.length + Chat.length];
            for (int i = 0; i < ChatBox.length; i++) {
                newChatBox[i] = ChatBox[i];
            }
            for (int i = 0; i < Chat.length; i++) {
                newChatBox[ChatBox.length + i] = Chat[i];
            }
            ChatBox = newChatBox;
            for(int i = 0; i<this.ChatBox.length; i++){
                System.out.println("Agensi " + this.username + " : " + ChatBox[i]);
            }
        }else{
            ChatBox = Chat;
            System.out.println("Agensi " + this.username + " : " + Pesan);
        }
    }
*/
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
        }else{
            this.DataRumah = tempDataRumah;            
        }
    }
    
    public void editDataRumahAlamat(DataRmh[] dataRumah,int index, String alamat){
        this.DataRumah = dataRumah;
        dataRumah[index].setAlamat(alamat);
       
    }
    
    public void editDataRumahNamRumah(DataRmh[] dataRumah,int index, String namaRumah){
        this.DataRumah = dataRumah;
        dataRumah[index].setNamaRumah(namaRumah);
       
    }
    
    public void editDataRumahAlamatDesc(DataRmh[] dataRumah,int index, String desc){
        this.DataRumah = dataRumah;
        dataRumah[index].setDescription(desc);
       
    }
    
    public void editDataRumahAlamatHarga(DataRmh[] dataRumah,int index, double harga){
        this.DataRumah = dataRumah;
        dataRumah[index].setHarga(harga);
       
    }
    
    public void editDataRumahJumlahKamar(DataRmh[] dataRumah,int index, int jmlKamar){
        this.DataRumah = dataRumah;
        dataRumah[index].setJmlhKamar(jmlKamar);
       
    }
    
    public void editDataRumahAlamatLuasBangunan(DataRmh[] dataRumah,int index, int LuasBangunan){
        this.DataRumah = dataRumah;
        dataRumah[index].setLuasBangunan(LuasBangunan);
       
    }
    
    public void editDataRumahAlamatLuasTanah(DataRmh[] dataRumah,int index, int LuasTanah){
        this.DataRumah = dataRumah;
        dataRumah[index].setLuasTanah(LuasTanah);
       
    }
    
    public void editDataRumahAlamatJumlahParkir(DataRmh[] dataRumah,int index, int jmlParkir){
        this.DataRumah = dataRumah;
        dataRumah[index].setJmlhParkir(jmlParkir);
       
    }
    
    public void editDataRumahAlamatJumlahLantai(DataRmh[] dataRumah,int index, int jmlLantai){
        this.DataRumah = dataRumah;
        dataRumah[index].setJmlhLantai(jmlLantai);
       
    }
    
    public void editDataRumahAlamatJumlahToilet(DataRmh[] dataRumah,int index, int jmlToilet){
        this.DataRumah = dataRumah;
        dataRumah[index].setJmlhToilet(jmlToilet);
       
    }
    
}
