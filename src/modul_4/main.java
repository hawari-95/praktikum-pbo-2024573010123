package modul_4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("     SISTEM KARTU RENCANA STUDI (KRS)");
        System.out.println("===============================================");

        // Input data mahasiswa
        System.out.print("Nama Mahasiswa : ");
        String nama = input.nextLine();

        System.out.print("NIM            : ");
        String nim = input.nextLine();

        System.out.print("Jurusan        : ");
        String jurusan = input.nextLine();

        // Membuat objek Mahasiswa dan KartuRencanaStudi
        Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, 0.0);
        KartuRencanaStudi krs = new KartuRencanaStudi(mhs, 10);

        boolean running = true;



        while (running) {
            System.out.println("\n===============================================");
            System.out.println("                 MENU KRS");
            System.out.println("===============================================");
            System.out.println("1. Tambah Mata Kuliah");
            System.out.println("2. Input Nilai Mata Kuliah");
            System.out.println("3. Tampilkan KRS");
            System.out.println("4. Hapus Mata Kuliah");
            System.out.println("5. Tampilkan Nilai Terbaik & Terburuk");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- TAMBAH MATA KULIAH ---");
                    System.out.print("Kode Mata Kuliah : ");
                    String kode = input.nextLine();

                    System.out.print("Nama Mata Kuliah : ");
                    String namaMK = input.nextLine();

                    System.out.print("Jumlah SKS       : ");
                    int sks = input.nextInt();
                    input.nextLine();

                    MataKuliah matkul = new MataKuliah(kode, namaMK, sks);
                    krs.tambahMataKuliah(matkul);
                    break;

                case 2:
                    System.out.println("\n--- INPUT NILAI ---");
                    System.out.print("Masukkan Kode Mata Kuliah : ");
                    String kodeCari = input.nextLine();

                    MataKuliah mkCari = krs.cariMataKuliah(kodeCari);
                    if (mkCari != null) {
                        System.out.print("Masukkan Nilai (0-100): ");
                        double nilai = input.nextDouble();
                        input.nextLine();
                        mkCari.setNilai(nilai);
                        System.out.println("Nilai berhasil diinput!");
                    } else {
                        System.out.println("Mata kuliah tidak ditemukan!");
                    }
                    break;

                case 3:
                    krs.tampilkanKRS();
                    break;

                case 4:
                    System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
                    String kodeHapus = input.nextLine();
                    krs.hapusMataKuliah(kodeHapus);
                    break;

                case 5:
                    krs.tampilkanNilaiTerbaikDanTerburuk();
                    break;


                case 6:
                    System.out.println("\nTerima kasih telah menggunakan sistem KRS!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        input.close();
    }
}

