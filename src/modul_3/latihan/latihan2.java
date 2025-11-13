package modul_3.latihan;

import java.util.Scanner;

public class latihan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Langkah 1: Deklarasi array 2D
        int[][] nilaiSiswa = new int[3][4];
        String[] namaSiswa = {"Alice", "Bob", "Charlie"};
        String[] mataPelajaran = {"Matematika", "B. Indo", "IPA", "IPS"};

        // Langkah 2: Input nilai
        System.out.println("======== INPUT NILAI SISWA ========");
        for (int i = 0; i < 3; i++) {
            System.out.println("Input nilai untuk " + namaSiswa[i] + ":");
            for (int j = 0; j < 4; j++) {
                System.out.print(mataPelajaran[j] + ": ");
                nilaiSiswa[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // Langkah 3: Menampilkan data dalam bentuk tabel
        System.out.println("================ TABEL NILAI SISWA ================");
        System.out.printf("%-12s", "Nama");
        for (String mapel : mataPelajaran) {
            System.out.printf("%-10s", mapel);
        }
        System.out.println("Rata-rata   | Nilai Tertinggi");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-12s", namaSiswa[i]);
            int total = 0;
            int nilaiTertinggiSiswa = -1;
            String mapelTertinggi = "";

            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", nilaiSiswa[i][j]);
                total += nilaiSiswa[i][j];

                // Fitur 1: Mencari nilai tertinggi per siswa
                if (nilaiSiswa[i][j] > nilaiTertinggiSiswa) {
                    nilaiTertinggiSiswa = nilaiSiswa[i][j];
                    mapelTertinggi = mataPelajaran[j];
                }
            }
            double rataRata = (double) total / 4.0;
            System.out.printf("%-11.2f | %s (%d)%n", rataRata, mapelTertinggi, nilaiTertinggiSiswa);
        }
        System.out.println("-------------------------------------------------------------------");

        // Fitur 2: Hitung rata-rata per mata pelajaran
        System.out.println("Rata-rata per Mata Pelajaran:");
        for (int j = 0; j < 4; j++) { // Loop per kolom (mata pelajaran)
            int totalMapel = 0;
            for (int i = 0; i < 3; i++) { // Loop per baris (siswa)
                totalMapel += nilaiSiswa[i][j];
            }
            double rataRataMapel = (double) totalMapel / 3.0;
            System.out.printf("- %-10s: %.2f%n", mataPelajaran[j], rataRataMapel);
        }
    }
}