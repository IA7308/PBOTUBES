package tp.tubespbo;

public class Pembeli extends Agensi{
   private long NoHP;
   private String Email;
   private String username;
   private String password;
   private String idPembeli ;
   private Promosi[] listPromosi ;
   private Form[] form ;
   
   public Pembeli(String idPembeli,String username, String password, long NoHP, String Email, Promosi[] LP, Form[] LF){
       this.idPembeli = idPembeli;
       this.Email = Email;
       this.NoHP = NoHP;
       this.password = password;
       this.username = username;
       this.listPromosi = LP;
       this.form = LF;
   }
   
   public Pembeli(){}

    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public String getIdPembeli() {
        return idPembeli;
    }   

    public void setListPromosi(tp.tubespbo.Promosi[] listPromosi) {
        this.listPromosi = listPromosi;
    }
   
   public void Register(String username, String password, long NoHP, String Email){
       this.Email = Email;
       this.NoHP = NoHP;
       this.password = password;
       this.username = username;
       System.out.println("Telah Berhasil Registrasi");
   }
   
    public boolean Login(String username, String password, Pembeli[] list){
        /*
        for(int i = 0; i <= list.length; i++){
            if(username.equals(list[i].getUsername()) && password.equals(list[i].getPassword()) && i < list.length){
                this.idPembeli = list[i].getIdPembeli();
                this.Email = list[i].Email;
                this.NoHP = list[i].NoHP;
                this.password = list[i].password;
                this.username = list[i].username;
                return true;
            }if(i == list.length){
                return false;
            }
        }
        */
        
        if(username.equals(this.username) && password.equals(this.password)){
            System.out.println("Anda berhasil Login sebagai Pembeli, " + this.username);
            return true;
        }else{
            System.out.println("Username atau Password tidak tersedia");
            return false;
        }
    }
   
    public void menampilkanSeluruhRumah(){
        for(int i = 0; i<super.DataRumah.length;i++){
            System.out.println(this.DataRumah[i].getNamaRumah());
        }
    }
    
    public void LihatDetailRumah(String NamaRumah){
       for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getNamaRumah().equals(NamaRumah)){
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
    }
    
   @Override
    public void lihatHistoryPromosi(String idPembeli){
        if(this.listPromosi != null){
            for(int i = 0 ; i <  this.listPromosi.length ; i++){
                if(idPembeli.equals(this.listPromosi[i].getIdPembeli())){
                    System.out.println("Waktu Promosi Dikirimkan : " + this.listPromosi[i].getWaktuPromosi());
                    System.out.println("Isi Pesan Promosi : " );
                    System.out.println(this.listPromosi[i].getPromosi());
                    System.out.println("Untuk pembeli dengan id : " + this.listPromosi[i].getIdPembeli());
                }
            }
        }else {
            System.out.println("Anda belum pernah mendapatkan promosi");
        }        
    }
    
    public void isiForm(Form formPembeli){
        Form[] tempForm = {formPembeli};
        if(form != null){
            Form[] temp = new Form[form.length + tempForm.length];
            for (int i = 0; i < form.length; i++) {
                temp[i] = form[i];
            }
            for (int i = 0; i < tempForm.length; i++) {
                temp[form.length + i] = tempForm[i];
            }
            this.form = temp;
            
            for(int i = 0;i<this.form.length; i++){
                if (this.form[i].getIdForm() == null) { // Memeriksa jika idRumah belum terisi
                    String idForm = this.idPembeli + "F00" + (i+1);
                    this.form[i].setIdForm(idForm);
                    this.form[i].setIdPembeli(this.idPembeli);
                    this.form[i].setUsername(this.username);
                }
            }
        }else{
            this.form = tempForm;
            for(int i = 0;i<this.form.length; i++){
                if (this.form[i].getIdForm() == null) { // Memeriksa jika idRumah belum terisi
                    String idForm = this.idPembeli + "F00" + (i+1);
                    this.form[i].setIdForm(idForm);
                    this.form[i].setIdPembeli(this.idPembeli);
                    this.form[i].setUsername(this.username);
                }
            }
        }
    }   

    public void lihatForm(){
        if(this.form != null){
            for(int i = 0 ; i <  this.form.length ; i++){
                if(this.form[i].getIdPembeli().equals(this.idPembeli)){
                    System.out.println("ID Form : " + this.form[i].getIdForm());
                    System.out.println("ID Rumah : " + this.form[i].getIdRumah());
                    System.out.println("Nama Rumah : " + this.form[i].getNamaRumah());
                    System.out.println("Nama Pembeli : " + this.form[i].getUsername());
                    System.out.println("Lokasi Janjian : " + this.form[i].getLokasiJanjian());
                    System.out.println("Waktu Janjian : " + this.form[i].getWaktuJanjian());                   
                }
            }
        }else {
            System.out.println("Anda belum pernah mengisi Form");
        }        
    }
    
    public Form[] getForm() {
        return form;
    }
    
    public void LihatRumahAlamat(String alamat){
        boolean ketemu = false;
        
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getAlamat().startsWith(alamat)){
                System.out.println(this.DataRumah[i].getNamaRumah());
                System.out.println("Alamat : " + this.DataRumah[i].getAlamat());
                System.out.println("Harga : Rp" + (int)this.DataRumah[i].getHarga());
                System.out.println("Kamar : " + this.DataRumah[i].getJmlhKamar() + ", Luas Bangunan : " 
                        + this.DataRumah[i].getLuasBangunan() +"m\u00B2, Luas Tanah : " 
                        + this.DataRumah[i].getLuasTanah() + "m\u00B2");
                System.out.println(this.DataRumah[i].getNamaRumah() + " " + this.DataRumah[i].getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + this.DataRumah[i].getJmlhParkir() + "\t Jumlah Lantai " +  this.DataRumah[i].getJmlhLantai());
                ketemu = true;
                
           }  
        }
        if(!ketemu){
            System.out.println("DATA TIDAK DITEMUKAN");
        }
        
    }
    
    public void LihatRumahHarga(double harga){
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getHarga()<=harga){
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
    }
    
    public void LihatRumahKamar(int jmlhkmr){
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getJmlhKamar()<=jmlhkmr){
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
    }
    
    public void LihatRumahParkir(int jmlhprk){
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getJmlhParkir()<=jmlhprk){
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
    }
    
    public void LihatRumahLantai(int lt){
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getJmlhLantai()<=lt){
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
    }
    
        public void LihatRumahToilet(int toilet){
        for(int i = 0; i<this.DataRumah.length;i++){
           if(DataRumah[i].getJmlhToilet()<=toilet){
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
    }
}
