package Model;

import java.util.List;
import java.util.Scanner;

public class Agensi {

    
    private String username;
    private String password;
    private String kodeAgensi;
    private boolean registered;

    public Agensi(){}
    public Agensi(String username, String password, String kodeAgensi) {
        this.username = username;
        this.password = password;
        this.kodeAgensi = kodeAgensi;
        this.registered = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKodeAgensi() {
        return kodeAgensi;
    }

    public void setKodeAgensi(String kodeAgensi) {
        this.kodeAgensi = kodeAgensi;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
    
    public boolean registrasi(Scanner scanner, Pegawai pegawai) {
    if (!registered) {
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();
        System.out.print("Masukkan kode agensi: ");
        String inputKodeAgensi = scanner.nextLine();
        for(int i = 0 ; i < pegawai.getKodeAgensiList().size();i++){
            if(pegawai.getKodeAgensiList().get(i).equals(inputKodeAgensi)){
                username = inputUsername;
                password = inputPassword;
                kodeAgensi = inputKodeAgensi;
                registered = true;
                System.out.println("Registrasi agensi berhasil!");
                return true;
            } else {
                System.out.println("Registrasi agensi gagal! Kode agensi salah.");
            }
        } 
    } else {
        System.out.println("Anda sudah terdaftar sebagai agensi.");
    }
    return false;
}


    public boolean login(Scanner scanner) {
        if (registered) {
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();
            System.out.print("Masukkan kode agensi: ");
            String inputKodeAgensi = scanner.nextLine();
            
            if (inputUsername.equals(username) && inputPassword.equals(password) && inputKodeAgensi.equals(kodeAgensi)) {
                System.out.println("Login agensi berhasil!");
                return true;
            } else {
                System.out.println("Login agensi gagal! Username, password, atau kode agensi salah.");
            }
        } else {
            System.out.println("Anda belum terdaftar sebagai agensi.");
        }
        return false;
    }
    
    
    public void tambahDataRumah(Scanner scanner,List<DataRumah> dataRumahList) {
        System.out.println("Masukkan Data Rumah Baru");
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Nama Rumah: ");
        String namaRumah = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String description = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Jumlah Kamar: ");
        int jmlhKamar = scanner.nextInt();
        System.out.print("Luas Bangunan: ");
        int luasBangunan = scanner.nextInt();
        System.out.print("Luas Tanah: ");
        int luasTanah = scanner.nextInt();
        System.out.print("Jumlah Parkir: ");
        int jmlhParkir = scanner.nextInt();
        System.out.print("Jumlah Lantai: ");
        int jmlhLantai = scanner.nextInt();
        System.out.print("Jumlah Toilet: ");
        int jmlhToilet = scanner.nextInt();
        scanner.nextLine(); 

        String idRumah = generateIDRumah(dataRumahList);
        DataRumah dataRumah = new DataRumah(idRumah, alamat, namaRumah, description, harga, jmlhKamar, luasBangunan, luasTanah, jmlhParkir, jmlhLantai, jmlhToilet);
        dataRumahList.add(dataRumah);
       
        
    }

    private String generateIDRumah(List<DataRumah> dataRumahList) {
        if(dataRumahList == null){
            return kodeAgensi + "-"+"1";
        }else {
            int rumahKe = dataRumahList.size() + 1;
        return kodeAgensi + "-" + rumahKe;
        }
        
    }
    
    public void lihatDaftarRumah(List<DataRumah> dataRumahList) {
        System.out.println("Daftar Rumah:");
        for (DataRumah dataRumah : dataRumahList) {
            System.out.println("ID Rumah: " + dataRumah.getIdRumah());
            System.out.println("Alamat: " + dataRumah.getAlamat());
            System.out.println("Nama Rumah: " + dataRumah.getNamaRumah());
            System.out.println("Deskripsi: " + dataRumah.getDescription());
            System.out.println("Harga: " + dataRumah.getHarga());
            System.out.println("Jumlah Kamar: " + dataRumah.getJmlhKamar());
            System.out.println("Luas Bangunan: " + dataRumah.getLuasBangunan());
            System.out.println("Luas Tanah: " + dataRumah.getLuasTanah());
            System.out.println("Jumlah Parkir: " + dataRumah.getJmlhParkir());
            System.out.println("Jumlah Lantai: " + dataRumah.getJmlhLantai());
            System.out.println("Jumlah Toilet: " + dataRumah.getJmlhToilet());
            System.out.println("---------------------------");
        }
    }
    
}

