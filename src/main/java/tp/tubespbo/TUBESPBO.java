package tp.tubespbo;

import java.util.Scanner;

public class TUBESPBO {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        
        DataRmh Rmh1 = new DataRmh("JALAN DIRGANTARA RAYA, JATISARI JATIASIH, BEKASI", 
                "Taman Jatisari Permai Tipe 40", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 40, 73, 1, 1, 1);
        
        DataRmh Rmh2 = new DataRmh("JALAN DIRGANTARA RAYA, JATISARI JATIASIH, BEKASI", 
                "Taman Jatisari Permai Tipe 43", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 40, 73, 1, 1, 1);
        
        DataRmh Rmh3 = new DataRmh("JALAN DIRGANTARA RAYA, JATISARI JATIASIH, BEKASI", 
                "Taman Jatisari Permai Tipe 45", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 40, 73, 1, 1, 1);
        
        DataRmh[] ListRumah = {Rmh1, Rmh2, Rmh3};
        Promosi[] listPromosi = null;
        Form[] listForm = null;
        
        Agensi Agen1 = new Agensi();
        
                
        Pegawai Pegawai1 = new Pegawai("ADMIN", "ADMIN");
        Pegawai1.newAgensi("FBI");
        
        Pembeli pembeli = new Pembeli("Cust0","testing1","testing1",8777777,"test@gmail.com", listPromosi, listForm);
        Pembeli pembeli1 = new Pembeli("Cust1","testing2","testing2",8777777,"test@gmail.com", listPromosi, listForm);
        Pembeli pembeli2 = new Pembeli("Cust2","testing3","testing3",8777777,"test@gmail.com", listPromosi, listForm);
        Pembeli[] listPembeli = {pembeli,pembeli1,pembeli2};
        
        Agen1.setListPembeli(listPembeli);
        pembeli.setDataRumah(ListRumah);
        String pilihan = ",";
        
        
        for(int i = 0 ; i < listPembeli.length ; i++){
            System.out.println("ID PEMBELI " + listPembeli[i].getIdPembeli());
        }
        
        while(!".".equals(pilihan)){
            System.out.println("Login/Register Sebagai (Agensi/Pegawai/Pembeli)");
            pilihan = input.nextLine();
            
            if("Agensi".equals(pilihan)){
            
                System.out.print("Masukkan Username : ");
                String Username = input.nextLine();
                System.out.print("Masukkan Password : ");
                String Password = input.nextLine();
                System.out.print("Masukkan KodeAgensi : ");
                String kodeAgensi = input.nextLine();

                boolean LoginStatus = Agen1.Login(Username, Password, kodeAgensi);
                if(LoginStatus){
                    System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                    String Pilihan = ".";

                    while(!"LogOut".equals(Pilihan)){

                        Pilihan = input.nextLine();
                        if("LihatDataRumah".equals(Pilihan)){
                            Agen1.lihatDataRumah();
                            System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                        }else if("InputRumahBaru".equals(Pilihan)){
                            String Masukkan = ",";
                            while(!".".equals(Masukkan)){
                                System.out.println("Ketik '.' untuk Berhenti menambahkan Rumah, Ketik + untuk menambahkan Data Rumah");
                                Masukkan = input.nextLine();
                                if("+".equals(Masukkan)){
                                    System.out.print("Masukkan Nama Rumah : ");
                                    String NamaRumah = input.nextLine();
                                    System.out.print("Masukkan Alamat : ");
                                    String alm = input.nextLine();
                                    System.out.print("Masukkan Deskripsi : ");
                                    String Desc = input.nextLine();
                                    System.out.print("Masukkan Harga : ");
                                    int Hrg = input.nextInt();
                                    System.out.print("Masukkan Jumlah Kamar : ");
                                    int jmlhKamar = input.nextInt();
                                    System.out.print("Masukkan Jumlah Parkir : ");
                                    int jmlhPark = input.nextInt();
                                    System.out.print("Masukkan Jumlah Lantai : ");
                                    int jmlhLT = input.nextInt();
                                    System.out.print("Masukkan Jumlah Toilet : ");
                                    int jmlhToilet = input.nextInt();
                                    System.out.print("Masukkan Luas Lahan : ");
                                    int LL = input.nextInt();
                                    System.out.print("Masukkan Luas Bangunan : ");
                                    int LB = input.nextInt();
                                    
                                    DataRmh rmh = new DataRmh(alm, NamaRumah, Desc, Hrg, jmlhKamar, LB, LL, jmlhPark, jmlhLT, jmlhToilet);
                                    Agen1.uploadDataRumah(rmh);
                                }
                            }                                                               
                            System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                        }else if("Promosi".equals(Pilihan)){
                            for(int i = 0 ; i < listPembeli.length ; i++){
                                System.out.println("ID PEMBELI " + listPembeli[i].getIdPembeli());
                            }
                            System.out.print("Masukkan ID Pembeli yang ingin anda kirimkan promosi : ");
                            String idPembeliPromosi = input.nextLine();
                            
                            for(int i = 0 ; i < listPembeli.length ; i ++){
                                    System.out.println("ID tersedia : " + listPembeli[i].getIdPembeli());
                                }
                                if(Agen1.cariIdPembeli(listPembeli,idPembeliPromosi)){
                                    System.out.println("ID Pembeli yang ingin dituju ditemukan, Silahkan masukkan pesan promosi ");
                                    String Pesan = input.nextLine();
                                    
                                    Promosi historyPromosi = new Promosi(idPembeliPromosi, kodeAgensi, Pesan);
                                    historyPromosi.setWaktuPromosi();
                                    Agen1.addPromosi(historyPromosi);
                                    listPromosi = Agen1.getListPromosi();
                                    for(int i = 0; i<listPromosi.length;i++){
                                        System.out.println(listPromosi[i].getPromosi());
                                    }
                                }else {
                                    System.out.println("ID Pembeli yang ingin anda tuju tidak ditemukan, silahkan masukkan id Pembeli kembali ");
                                }
                                
                                Agen1.lihatHistoryPromosi(kodeAgensi);

                            System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                        }else if("Edit".equals(Pilihan)){
                            System.out.println("Tulisakn ID Rumah yang ingin anda edit");
                            String idRumahEdit = input.nextLine();
                            boolean found = false ;
                            int idx = -1;
                            int i ;
                            DataRmh[] tempListRumah = Agen1.getDataRumah();
                            for(i = 0 ;i < tempListRumah.length;i++ ){
                                String cekKode = Agen1.getKodeAgensi() + "00" + (i+1);
                                if(idRumahEdit.equals(tempListRumah[i].getIdRumah()) && idRumahEdit.equals(cekKode)){
                                    found = true ;
                                    idx = i ;
                                    break ;
                                }
                                
                            }if(true == found){
                                if(idRumahEdit.substring(0,3).equals(Agen1.getKodeAgensi())){
                                    System.out.println("ID Rumah berhasil ditemukan, data rumah apa yang ingin anda edit ? ");
                                    System.out.println("1. Alamat");
                                    System.out.println("2. Nama Rumah");
                                    System.out.println("3. Deskripsi");
                                    System.out.println("4. Harga");
                                    System.out.println("5. Jumlah Kamar");
                                    System.out.println("6. Luas Bangunan");
                                    System.out.println("7. Luas Tanah");
                                    System.out.println("8. Jumlah Parkir");
                                    System.out.println("9. Jumlah Lantai");
                                    System.out.println("10.Jumlah Toilet");
                                    System.out.println("0. EXIT");
                                    System.out.println("Note : cukup ketikkan angkanya saja");
                                
                                int selectData = 0 ;
                                selectData = input.nextInt();
                                input.nextLine();
                                switch (selectData) {
                                    case 1 -> {
                                        System.out.print("Alamat Baru : ");
                                        String newAlamat = input.nextLine();
                                        Agen1.editDataRumahAlamat(Agen1.getDataRumah(), idx, newAlamat);
                                    }
                                    case 2 -> {
                                        System.out.print("Nama Rumah Baru : ");
                                        String newNama = input.nextLine();
                                        Agen1.editDataRumahNamRumah(Agen1.getDataRumah(), idx, newNama);
                                    }
                                    case 3 -> {
                                        System.out.print("Deskripsi Baru : ");
                                        String newDeskripsi = input.nextLine();
                                        Agen1.editDataRumahAlamatDesc(Agen1.getDataRumah(), idx, newDeskripsi);
                                    }
                                    case 4 -> {
                                        System.out.print("Harga Baru : ");
                                        double newHarga = input.nextDouble();
                                        Agen1.editDataRumahAlamatHarga(Agen1.getDataRumah(), idx, newHarga);
                                    }
                                    case 5 -> {
                                        System.out.print("Jumlah Kamar Baru : ");
                                        int newJmlKamar = input.nextInt();
                                        Agen1.editDataRumahJumlahKamar(Agen1.getDataRumah(), idx, newJmlKamar);
                                    }
                                    case 6 -> {
                                        System.out.print("Luas Bangunan Baru :");
                                        int newLuasBangunan = input.nextInt();
                                        Agen1.editDataRumahAlamatLuasBangunan(Agen1.getDataRumah(), idx, newLuasBangunan);
                                    }
                                    case 7 -> {
                                        System.out.print("Luas Tanah Baru : ");
                                        int newLuasTanah = input.nextInt();
                                        Agen1.editDataRumahAlamatLuasTanah(Agen1.getDataRumah(), idx, newLuasTanah);
                                    }
                                    case 8 -> {
                                        System.out.print("Jumlah Parkir Baru : ");
                                        int newJmlParkir = input.nextInt();
                                        Agen1.editDataRumahAlamatJumlahParkir(Agen1.getDataRumah(), idx, newJmlParkir);
                                    }
                                    case 9 -> {
                                        System.out.print("Jumlah Lantai Baru : ");
                                        int newJmlLantai = input.nextInt() ;
                                        Agen1.editDataRumahAlamatJumlahLantai(Agen1.getDataRumah(), idx, newJmlLantai);
                                    }
                                    case 10 -> {
                                        System.out.print("Jumlah Toilet Baru : " );
                                        int newJmlToilet = input.nextInt();
                                        Agen1.editDataRumahAlamatJumlahToilet(Agen1.getDataRumah(), idx, newJmlToilet);
                                    }
                                    case 0 ->{
                                        break;
                                    }
                                }
                                    
                         
                                }else {
                                    System.out.println("Anda Tidak Memiliki Akses pada Agensi Ini ");
                                }
                                System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                            }else{
                                System.out.println("Data Tidak Ditemukan atau Kode Agensi yang di edit Tidak Sesuai dengan kode yang dimiliki");
                                System.out.println("Menu InputRumahBaru/LihatDataRumah/Promosi/Edit");
                            }
                        }
                    }
                }else{
                    System.out.println("Register");
                    System.out.print("Masukkan Username : ");
                    Username = input.nextLine();
                    System.out.print("Masukkan Password : ");
                    Password = input.nextLine();
                    System.out.print("Masukkan KodeAgensi : ");
                    kodeAgensi = input.nextLine();
                    Agen1 = new Agensi(Username, Password, ListRumah, kodeAgensi, listPromosi);
                    Agen1.ListKodeAgensi = Pegawai1.ListKodeAgensi;
                    Agen1.register(Username, Password, kodeAgensi);                
                }
            }else if ("Pembeli".equals(pilihan)){

                System.out.print("Masukkan Username : ");
                String Username = input.nextLine();
                System.out.print("Masukkan Password : ");
                String Password = input.nextLine();



                boolean LoginStatus = pembeli.Login(Username, Password, listPembeli);
                if(LoginStatus){

                    String Pilihan = ".";
                                      
                    while(!"LogOut".equals(Pilihan)){
                        System.out.println("Menu PilihRumah/LihatSeluruhRumah/LihatPromosi/IsiForm/LihatForm/SearchBarRumah");
                        Pilihan = input.nextLine();
                        if("LihatSeluruhRumah".equals(Pilihan)){
                            if(pembeli.DataRumah!= null){
                                pembeli.menampilkanSeluruhRumah();
                            }else{
                                System.out.println("Data Rumah Masih Kosong");
                            }
                            
                        }else if("LihatForm".equals(Pilihan)){                            
                            pembeli.lihatForm();                                                
                        }else if("PilihRumah".equals(Pilihan)){
                            System.out.println("Tuliskan Nama Rumah");
                            String NamaRumah = input.nextLine();
                            pembeli.LihatDetailRumah(NamaRumah);
                        }else if("LihatPromosi".equals(Pilihan)){
                            pembeli.setListPromosi(listPromosi);
                            String idPembeli = pembeli.getIdPembeli();
                            pembeli.lihatHistoryPromosi(idPembeli);
                        }else if("IsiForm".equals(Pilihan)){
                            System.out.println("Silahkan Isi Form berikut ");
                            
                            System.out.println("id Rumah yang ingin dipilih? (lihat pada katalog rumah)");
                            String idRumahSelect = input.nextLine();
                            
                            System.out.println("Nama rumah yang ingin dipilih? (lihat pada katalog rumah)");
                            String namaRumahSelect = input.nextLine();
                            
                            //System.out.println("Sebutkan username anda");
                            //String usernameSelect = input.nextLine();
                            
                            System.out.println("Waktu Janjian yang ingin dipilih? (untuk jamnya akan dilakukan pada jam 10 pagi");
                            System.out.println("1. Senin");
                            System.out.println("2. Selasa");
                            System.out.println("3.Rabu");
                            String selectHari = input.nextLine();
                            
                            System.out.println("Lokasi janjian yang ingin anda pilih ?");
                            System.out.println("1. Kantor Agensi");
                            System.out.println("2. Lokasi Pemasaran Rumah ( Jika ada )");
                            String selectLokasi = input.nextLine();
                            
                            Form form = new Form(idRumahSelect, namaRumahSelect, selectHari, selectLokasi);                        
                            pembeli.isiForm(form);
                            listForm = pembeli.getForm();
                        }else if("SearchBarRumah".equals(Pilihan)){
                            System.out.println("1. Alamat");
                            System.out.println("2. Harga");
                            System.out.println("3. Jumlah Kamar");
                            System.out.println("4. Jumlah Parkir");
                            System.out.println("5. Jumlah Lantai");
                            System.out.println("6.Jumlah Toilet");
                            System.out.println("0. EXIT");
                            System.out.println("Note : cukup ketikkan angkanya saja");

                            int selectData = 0;
                            selectData = input.nextInt();
                            input.nextLine();
                            switch (selectData) {
                                case 1 -> {
                                    System.out.print("Masukkan Alamat : ");
                                    String newAlamat = input.nextLine();
                                    pembeli.LihatRumahAlamat(newAlamat);
                                }
                                case 2 -> {
                                    System.out.print("Masukkan Harga Maksimal : ");
                                    double newHarga = input.nextDouble();
                                    pembeli.LihatRumahHarga(newHarga);
                                    
                                }
                                case 3 -> {
                                    System.out.print("Masukkan Jumlah Kamar : ");
                                    int newJmlKamar = input.nextInt();
                                    pembeli.LihatRumahKamar(newJmlKamar);
                                }
                                case 4 -> {
                                    System.out.print("Masukkan Jumlah parkir : ");
                                    int newJmlprk = input.nextInt();
                                    pembeli.LihatRumahParkir(newJmlprk);
                                }
                                case 5 -> {
                                    System.out.print("Masukkan Jumlah Lantai : ");
                                    int newJmlLt = input.nextInt();
                                    pembeli.LihatRumahLantai(newJmlLt);
                                }
                                case 6 -> {
                                    System.out.print("Masukkan Jumlah Kamar : ");
                                    int newJmlToilet = input.nextInt();
                                    pembeli.LihatRumahToilet(newJmlToilet);
                                }
                                case 0 -> {
                                    break;
                                }
                            }
                        }

                    }
                }else{
                    System.out.println("Register");
                    System.out.print("Masukkan Username : ");
                    Username = input.nextLine();
                    System.out.print("Masukkan Password : ");
                    Password = input.nextLine();
                    System.out.print("Masukkan Email : ");
                    String Email = input.nextLine();
                    System.out.print("Masukkan NoHP : ");
                    String NoHP = input.nextLine();
                    
                    int maxPembeli = listPembeli.length;
                    String idPembeli = "Cust" + maxPembeli;
                    pembeli = new Pembeli(idPembeli,Username, Password, Long.parseLong(NoHP), Email, listPromosi, listForm);
                    pembeli.Register(Username, Password, Long.parseLong(NoHP), Email);   

                    Pembeli[] newListPembeli = new Pembeli[maxPembeli + 1];
                    for(int i = 0; i < maxPembeli; i++) {
                        newListPembeli[i] = listPembeli[i];
                    }
                    newListPembeli[maxPembeli] = pembeli;
                    listPembeli = newListPembeli;

                }
            }else if("Pegawai".equals(pilihan)){
                
                System.out.print("Masukkan Username : ");
                String Username = input.nextLine();
                System.out.print("Masukkan Password : ");
                String Password = input.nextLine();



                boolean LoginStatus = Pegawai1.Login(Username, Password);
                if(LoginStatus){

                    String Pilihan = ".";

                    while(!"LogOut".equals(Pilihan)){
                        System.out.println("Menu UploadDataRumah/LihatSeluruhRumah/TambahAgensi/Edit");
                        Pilihan = input.nextLine();
                        if("LihatSeluruhRumah".equals(Pilihan)){
                            if(Pegawai1.getDataRumah() == null){
                                System.out.println("Data Rumah Masih Kosong");
                            }else{
                                Pegawai1.lihatDataRumah();
                            }
                        }else if("UploadDataRumah".equals(Pilihan)){
                            Pegawai1.editDataRumah(Agen1.getDataRumah());
                            pembeli.DataRumah = Pegawai1.getDataRumah();
                        }else if("TambahAgensi".equals(Pilihan)){
                            System.out.print("Masukkan Kode Agensi yang akan ditambahkan : ");
                            String kode = input.nextLine();
                            Pegawai1.newAgensi(kode);
                        }else if("Edit".equals(Pilihan)){
                            System.out.println("Tulisakn ID Rumah yang ingin anda edit");
                            String idRumahEdit = input.nextLine();
                            boolean found = false ;
                            int idx = -1 ;
                            int i ;
                            DataRmh[] tempListRumah = Pegawai1.getDataRumah();
                            for(i = 0 ;i < tempListRumah.length;i++ ){
                                
                                if(idRumahEdit.equals(tempListRumah[i].getIdRumah())){
                                    found = true ;
                                    idx = i ;
                                    break ;
                                }
                                
                            }if(true == found){
                                System.out.println("ID Rumah berhasil ditemukan, data rumah apa yang ingin anda edit ? ");
                                System.out.println("1. Alamat");
                                System.out.println("2. Nama Rumah");
                                System.out.println("3. Deskripsi");
                                System.out.println("4. Harga");
                                System.out.println("5. Jumlah Kamar");
                                System.out.println("6. Luas Bangunan");
                                System.out.println("7. Luas Tanah");
                                System.out.println("8. Jumlah Parkir");
                                System.out.println("9. Jumlah Lantai");
                                System.out.println("10.Jumlah Toilet");
                                System.out.println("0. EXIT");
                                System.out.println("Note : cukup ketikkan angkanya saja");
                                
                                int selectData = 0 ;
                                selectData = input.nextInt();
                                input.nextLine(); // Membersihkan buffer input
                                switch (selectData) {
                                    case 1 -> {
                                        System.out.print("Alamat Baru : ");
                                        String newAlamat = input.nextLine();
                                        Agen1.editDataRumahAlamat(ListRumah, idx, newAlamat);
                                    }
                                    case 2 -> {
                                        System.out.print("Nama Rumah Baru : ");
                                        String newNama = input.nextLine();
                                        Agen1.editDataRumahNamRumah(ListRumah, idx, newNama);
                                    }
                                    case 3 -> {
                                        System.out.print("Deskripsi Baru : ");
                                        String newDeskripsi = input.nextLine();
                                        Agen1.editDataRumahAlamatDesc(ListRumah, idx, newDeskripsi);
                                    }
                                    case 4 -> {
                                        System.out.print("Harga Baru : ");
                                        double newHarga = input.nextDouble();
                                        Agen1.editDataRumahAlamatHarga(ListRumah, idx, newHarga);
                                    }
                                    case 5 -> {
                                        System.out.print("Jumlah Kamar Baru : ");
                                        int newJmlKamar = input.nextInt();
                                        Agen1.editDataRumahJumlahKamar(ListRumah, idx, newJmlKamar);
                                    }
                                    case 6 -> {
                                        System.out.print("Luas Bangunan Baru :");
                                        int newLuasBangunan = input.nextInt();
                                        Agen1.editDataRumahAlamatLuasBangunan(ListRumah, idx, newLuasBangunan);
                                    }
                                    case 7 -> {
                                        System.out.print("Luas Tanah Baru : ");
                                        int newLuasTanah = input.nextInt();
                                        Agen1.editDataRumahAlamatLuasTanah(ListRumah, idx, newLuasTanah);
                                    }
                                    case 8 -> {
                                        System.out.print("Jumlah Parkir Baru : ");
                                        int newJmlParkir = input.nextInt();
                                        Agen1.editDataRumahAlamatJumlahParkir(ListRumah, idx, newJmlParkir);
                                    }
                                    case 9 -> {
                                        System.out.print("Jumlah Lantai Baru : ");
                                        int newJmlLantai = input.nextInt() ;
                                        Agen1.editDataRumahAlamatJumlahLantai(ListRumah, idx, newJmlLantai);
                                    }
                                    case 10 -> {
                                        System.out.print("Jumlah Toiler Baru : " );
                                        int newJmlToilet = input.nextInt();
                                        Agen1.editDataRumahAlamatJumlahToilet(ListRumah, idx, newJmlToilet);
                                    }
                                    case 0 ->{
                                        break;
                                    }
                                        
                                }
                                System.out.println("Menu UploadRumahBaru/LihatDataRumah/Promosi/Edit");
                            }
                        }
                    }
                }else{
                    System.out.println("Anda gagal Login sebagai Pegawai");
                }
            }
        }
    }
}
