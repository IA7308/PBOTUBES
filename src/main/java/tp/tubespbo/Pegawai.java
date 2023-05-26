package tp.tubespbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pegawai {
    private String username;
    private String password;
    private List<String> kodeAgensiList;

    public Pegawai(String username, String password) {
        this.username = username;
        this.password = password;
         this.kodeAgensiList = new ArrayList<>();
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public void lihatDataRumah(List<DataRumah> dataRumahList) {
        if (dataRumahList.isEmpty()) {
            System.out.println("Belum ada data rumah yang diunggah.") ;
        } else {
            System.out.println("=== Data Rumah ===");
            for (DataRumah rumah : dataRumahList) {
                System.out.println("ID Rumah: " + rumah.getIdRumah());
                System.out.println("Alamat: " + rumah.getAlamat());
                System.out.println("Nama Rumah: " + rumah.getNamaRumah());
                System.out.println("Deskripsi: " + rumah.getDescription());
                System.out.println("Harga: " + rumah.getHarga());
                System.out.println("Jumlah Kamar: " + rumah.getJmlhKamar());
                System.out.println("Luas Bangunan: " + rumah.getLuasBangunan());
                System.out.println("Luas Tanah: " + rumah.getLuasTanah());
                System.out.println("Jumlah Parkir: " + rumah.getJmlhParkir());
                System.out.println("Jumlah Lantai: " + rumah.getJmlhLantai());
                System.out.println("Jumlah Toilet: " + rumah.getJmlhToilet());
                System.out.println("--------------------");
            }
        }
    }
    
    public void tambahKodeAgensi(String kodeAgensi) {
        kodeAgensiList.add(kodeAgensi);
        System.out.println("Kode agensi berhasil ditambahkan!");
    }

    public boolean cekKetersediaanKodeAgensi(String kodeAgensi) {
        return !kodeAgensiList.contains(kodeAgensi);
    }

    public List<String> getKodeAgensiList() {
        return kodeAgensiList;
    }
    
    public void lihatKodeAgensiList() {
        System.out.println("Daftar Kode Agensi:");
        for (String kodeAgensi : kodeAgensiList) {
            System.out.println(kodeAgensi);
        }
    }
    
    public void tambahWaktuTersedia(List<WaktuTersediaForm> waktuTersediaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan waktu tersedia yang ingin ditambahkan (tanggal): ");
        String waktuTambah = scanner.nextLine();

        // Create a new instance of WaktuTersediaForm and add it to the list
        WaktuTersediaForm waktuTersedia = new WaktuTersediaForm(waktuTambah);
        waktuTersediaList.add(waktuTersedia);

        System.out.println("Waktu tersedia berhasil ditambahkan.");
    }

    public void hapusWaktuTersedia(List<WaktuTersediaForm> waktuTersediaList) {
        // Print all available times
        System.out.println("=== Daftar Waktu Tersedia ===");
        for (int i = 0; i < waktuTersediaList.size(); i++) {
            WaktuTersediaForm waktuTersedia = waktuTersediaList.get(i);
            System.out.println("Index: " + i);
            System.out.println("Waktu Tersedia: " + waktuTersedia.getWaktuTersedia());
            System.out.println("--------------------");
        }

        // Prompt user to choose an index to remove
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan index waktu tersedia yang ingin dihapus: ");
        int indexHapus = scanner.nextInt();

        if (indexHapus >= 0 && indexHapus < waktuTersediaList.size()) {
            // Remove the chosen time from the list
            waktuTersediaList.remove(indexHapus);
            System.out.println("Waktu tersedia berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    
     public void aksesFormPengajuan(List<FormPengajuan> formList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Akses Form Pengajuan ===");
        System.out.print("Masukkan ID Form Pengajuan: ");
        String idFormPengajuan = scanner.nextLine();

        FormPengajuan formPengajuan = null;
        for (FormPengajuan form : formList) {
            if (form.getIdForm().equals(idFormPengajuan)) {
                formPengajuan = form;
                break;
            }
        }

        if (formPengajuan != null) {
            System.out.println("Detail Form Pengajuan:");
            System.out.println("ID Form: " + formPengajuan.getIdForm());
            System.out.println("Username: " + formPengajuan.getUsername());
            System.out.println("ID Rumah: " + formPengajuan.getIdRumah());
            System.out.println("Nama Rumah: " + formPengajuan.getNamaRumah());
            System.out.println("ID Pembeli: " + formPengajuan.getIdPembeli());
            System.out.println("Waktu Janjian: " + formPengajuan.getWaktuJanjian());
            System.out.println("Lokasi Janjian: " + formPengajuan.getLokasiJanjian());

            System.out.print("Apakah Anda menyetujui form pengajuan ini? (ya/tidak): ");
            String jawaban = scanner.nextLine();

            if (jawaban.equalsIgnoreCase("ya")) {
                formPengajuan.setStatus(true);
                System.out.println("Form pengajuan telah disetujui.");
            } else {
                formPengajuan.setStatus(false);
                System.out.println("Form pengajuan tidak disetujui.");
            }
        } else {
            System.out.println("Form Pengajuan dengan ID tersebut tidak ditemukan.");
        }
    }
}