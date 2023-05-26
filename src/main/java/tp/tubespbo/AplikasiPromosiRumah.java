package tp.tubespbo;

import java.util.Scanner;
import java.util.ArrayList;
public class AplikasiPromosiRumah {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<DataRumah> dataRumahList = new ArrayList<DataRumah>();
        ArrayList<FormPengajuan> formList = new ArrayList<FormPengajuan>();
        ArrayList<WaktuTersediaForm> waktuList = new ArrayList<WaktuTersediaForm>();
        
        dataRumahList.add(new DataRumah("JALAN DIRGANTARA RAYA, JATISARI JATIASIH, BEKASI", 
                "Taman Jatisari Permai Tipe 40", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 40, 73, 1, 1, 1));

        dataRumahList.add(new DataRumah("BANDUNG, JATINANGOR SAMPING ITB", 
                "Rumah Lama Berjuta Kenangan", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 52, 123, 1, 1, 1));
        
        dataRumahList.add(new DataRumah("BANDUNG, BOJONGSOANG SAMPING UNTEL", 
                "Rumah Tua Penuh Makna", 
                "Merupakan tiper rumah 1 lantai ...", 400000000,2, 99, 75, 1, 1, 1));
        
        Pegawai pegawai = new Pegawai("ADMIN", "ADMIN");
        pegawai.tambahKodeAgensi("FBI");
        Agensi agensi = new Agensi();

        Pembeli pembeli = new Pembeli();

        int choice;
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("=== MENU ===");
                System.out.println("1. Registrasi Agensi");
                System.out.println("2. Login Agensi");
                System.out.println("3. Login Pegawai");
                System.out.println("4. Registrasi Pembeli");
                System.out.println("5. Login Pembeli");
                System.out.println("6. Exit");
                System.out.print("Pilihan: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Membaca newline setelah membaca angka

                switch (choice) {
                    case 1:
                        agensi.registrasi(scanner, pegawai);
                        break;
                    case 2:
                        if (agensi.login(scanner)) {
                            boolean logout = false;
                            while (!logout) {
                                System.out.println("\n=== MENU AGENSI ===");
                                System.out.println("1. Tambah Data Rumah");
                                System.out.println("2. Lihat Daftar Rumah");
                                System.out.println("3. Logout");
                                System.out.print("Pilihan: ");
                                int agensiChoice = scanner.nextInt();
                                scanner.nextLine(); // Membaca newline setelah membaca angka

                                switch (agensiChoice) {
                                    case 1:
                                        agensi.tambahDataRumah(scanner, dataRumahList);
                                        break;
                                    case 2:
                                        agensi.lihatDaftarRumah(dataRumahList);
                                        break;
                                    case 3:
                                        logout = true;
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan username pegawai: ");
                        String inputUsername = scanner.nextLine();
                        System.out.print("Masukkan password pegawai: ");
                        String inputPassword = scanner.nextLine();

                        if (pegawai.login(inputUsername, inputPassword)) {
                            boolean logout = false;
                            while (!logout) {
                                System.out.println("\n=== MENU PEGAWAI ===");
                                System.out.println("1. Lihat Data Rumah");
                                System.out.println("2. Tambah Kode Agensi");
                                System.out.println("3. Lihat Kode Agensi");
                                System.out.println("4. Menambahkan Waktu Baru Pada Form");
                                System.out.println("5. Menyunting Waktu Pada Form");
                                System.out.println("6. Mengkonfirmasi Pengajuan Form");
                                System.out.println("7. Logout");
                                System.out.print("Pilihan: ");
                                int pegawaiChoice = scanner.nextInt();
                                scanner.nextLine(); // Membaca newline setelah membaca angka

                                switch (pegawaiChoice) {
                                    case 1:
                                        pegawai.lihatDataRumah(dataRumahList);
                                        break;
                                    case 2:
                                        System.out.print("Masukkan Kode Agensi Baru: ");
                                        String newKodeAgensi = scanner.nextLine();
                                        pegawai.tambahKodeAgensi(newKodeAgensi);
                                        break;
                                    case 3:
                                        pegawai.lihatKodeAgensiList();
                                        break;
                                    case 4 :
                                        pegawai.tambahWaktuTersedia(waktuList);
                                        break;
                                    case 5 :
                                        pegawai.hapusWaktuTersedia(waktuList);
                                        break ;
                                    case 6 :
                                        pegawai.aksesFormPengajuan(formList);
                                    case 7:
                                        logout = true;
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Username atau password pegawai salah.");
                        }
                        break;
                    case 4:
                        pembeli.registrasi(scanner);
                        break;
                    case 5:
                        if (pembeli.login(scanner)) {
                            boolean logout = false;
                            while (!logout) {
                                System.out.println("\n=== MENU PEMBELI ===");
                                System.out.println("1. Lihat Daftar Rumah");
                                System.out.println("2. Isi Form Pengajuan");
                                System.out.println("3. Search");
                                System.out.println("4. Logout");
                                System.out.print("Pilihan: ");
                                int pembeliChoice = scanner.nextInt();
                                scanner.nextLine(); // Membaca newline setelah membaca angka

                                switch (pembeliChoice) {
                                    case 1:
                                        pembeli.lihatDaftarRumah(dataRumahList);
                                        break;
                                    case 2:
                                        pembeli.isiFormPengajuan(scanner, dataRumahList, waktuList);
                                        break;
                                    case 3:
                                        pembeli.Search(dataRumahList);
                                    case 4:
                                        logout = true;
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Username atau password pembeli salah.");
                        }
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Terima kasih! Program berakhir.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan newline character
            }
        }
    }
}
