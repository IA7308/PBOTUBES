package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli {

    private long NoHP;
    private String Email;
    private String username;
    private String password;
    private String idPembeli;
    private ArrayList<Form> formList;

    public Pembeli(long NoHP, String Email, String username, String password, String idPembeli) {
        this.NoHP = NoHP;
        this.Email = Email;
        this.username = username;
        this.password = password;
        this.idPembeli = idPembeli;
        formList = new ArrayList<Form>();
    }

    public Pembeli() {
    }

    public long getNoHP() {
        return NoHP;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdPembeli() {
        return idPembeli;
    }

    public void setNoHP(long NoHP) {
        this.NoHP = NoHP;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public ArrayList<Form> getFormList() {
        return formList;
    }

    public void setFormList(ArrayList<Form> formList) {
        this.formList = formList;
    }

    public boolean registrasi(Scanner scanner) {
        System.out.print("Masukkan nomor HP: ");
        NoHP = scanner.nextLong();
        scanner.nextLine(); // Membersihkan new line character
        System.out.print("Masukkan email: ");
        Email = scanner.nextLine();
        System.out.print("Masukkan username: ");
        username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        password = scanner.nextLine();
        System.out.print("Masukkan ID Pembeli: ");
        idPembeli = scanner.nextLine();
        System.out.println("Registrasi berhasil!");
        return true;
    }

    public boolean login(Scanner scanner) {
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Login gagal! Username atau password salah.");
            return false;
        }
    }

    public void lihatDaftarRumah(ArrayList<DataRumah> dataRumahList) {
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

    public void isiFormPengajuan(Scanner scanner, ArrayList<DataRumah> dataRumahList, ArrayList<WaktuTersediaForm> waktuTersediaList) {
        // Prompt the user to choose a house
        System.out.print("Masukkan Nama Rumah yang ingin diajukan: ");
        String namaRumah = scanner.nextLine();

        // Find the chosen house
        DataRumah dataRumah = null;
        for (DataRumah rumah : dataRumahList) {
            if (rumah.getNamaRumah().equalsIgnoreCase(namaRumah)) {
                dataRumah = rumah;
                break;
            }
        }

        if (dataRumah == null) {
            System.out.println("Nama Rumah tidak valid.");
            return;
        }

        // Prompt the user to choose an available time
        System.out.println("=== Waktu Tersedia ===");
        for (int i = 0; i < waktuTersediaList.size(); i++) {
            WaktuTersediaForm waktuTersedia = waktuTersediaList.get(i);
            System.out.println("Index: " + i);
            System.out.println("Waktu Tersedia: " + waktuTersedia.getWaktuTersedia());
            System.out.println("--------------------");
        }

        System.out.println("=== Lokasi Tersedia ===");

        System.out.print("Masukkan index waktu tersedia yang dipilih: ");
        int indexWaktu = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (indexWaktu >= 0 && indexWaktu < waktuTersediaList.size()) {
            // Get the chosen available time
            WaktuTersediaForm waktuTersedia = waktuTersediaList.get(indexWaktu);

            // Generate a unique ID for the form
            String idForm;
            if (formList == null) {
                idForm = "id" + 1;
            } else {
                idForm = "id" + (formList.size() + 1);
            }

            // Get the ID of the buyer
            String idPembeli = getIdPembeli();

            // Get the selected time
            String waktuJanjian = waktuTersedia.getWaktuTersedia();

            // Get the location
            String lokasiJanjian = "Lokasi Kantor Pemasaran :" + dataRumah.getAlamat();

            boolean status = false;

            // Create a new FormPengajuan with the selected house and time
            Form formPengajuan = new Form(idForm, getUsername(), dataRumah.getIdRumah(), namaRumah, idPembeli, waktuJanjian, lokasiJanjian, status);

            // Add the form to the list
            formList.add(formPengajuan);

            System.out.println("Form pengajuan berhasil diisi.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    private void LihatRumahAlamat(String alamat, ArrayList<DataRumah> listRumah) {
        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getAlamat().startsWith(alamat)) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;

            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }

    }

    private void LihatRumahHarga(double harga, ArrayList<DataRumah> listRumah) {

        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getHarga() <= harga) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    private void LihatRumahKamar(int jmlhkmr, ArrayList<DataRumah> listRumah) {

        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getJmlhKamar() <= jmlhkmr) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    private void LihatRumahParkir(int jmlhprk, ArrayList<DataRumah> listRumah) {

        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getJmlhParkir() <= jmlhprk) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    private void LihatRumahLantai(int lt, ArrayList<DataRumah> listRumah) {

        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getJmlhLantai() <= lt) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    private void LihatRumahToilet(int toilet, ArrayList<DataRumah> listRumah) {

        boolean ketemu = false;

        for (int i = 0; i < listRumah.size(); i++) {
            if (listRumah.get(i).getJmlhToilet() <= toilet) {
                System.out.println(listRumah.get(i).getNamaRumah());
                System.out.println("Alamat : " + listRumah.get(i).getAlamat());
                System.out.println("Harga : Rp" + (int) listRumah.get(i).getHarga());
                System.out.println("Kamar : " + listRumah.get(i).getJmlhKamar() + ", Luas Bangunan : "
                        + listRumah.get(i).getLuasBangunan() + "m\u00B2, Luas Tanah : "
                        + listRumah.get(i).getLuasTanah() + "m\u00B2");
                System.out.println(listRumah.get(i).getNamaRumah() + " " + listRumah.get(i).getDescription());
                System.out.println("Rincian ");
                System.out.println("Lahan Parkir : " + listRumah.get(i).getJmlhParkir() + "\t Jumlah Lantai "
                        + listRumah.get(i).getJmlhLantai());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    public void Search(ArrayList<DataRumah> ListRumah) {
        Scanner input = new Scanner(System.in);

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
                LihatRumahAlamat(newAlamat, ListRumah);
            }
            case 2 -> {
                System.out.print("Masukkan Harga Maksimal : ");
                double newHarga = input.nextDouble();
                LihatRumahHarga(newHarga, ListRumah);

            }
            case 3 -> {
                System.out.print("Masukkan Jumlah Kamar : ");
                int newJmlKamar = input.nextInt();
                LihatRumahKamar(newJmlKamar, ListRumah);
            }
            case 4 -> {
                System.out.print("Masukkan Jumlah parkir : ");
                int newJmlprk = input.nextInt();
                LihatRumahParkir(newJmlprk, ListRumah);
            }
            case 5 -> {
                System.out.print("Masukkan Jumlah Lantai : ");
                int newJmlLt = input.nextInt();
                LihatRumahLantai(newJmlLt, ListRumah);
            }
            case 6 -> {
                System.out.print("Masukkan Jumlah Kamar : ");
                int newJmlToilet = input.nextInt();
                LihatRumahToilet(newJmlToilet, ListRumah);
            }
            case 0 -> {
                break;
            }
        }
    }

}
