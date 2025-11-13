package modul_3.latihan;

import java.util.Scanner;

public class latihan1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Buat array untuk 10 siswa
        int[] nilaiSiswa = new int[10];
        int totalNilai = 0;
        int nilaiTertinggi = Integer.MIN_VALUE;
        int nilaiTerendah = Integer.MAX_VALUE;

        System.out.println("Masukkan nilai ujian untuk 10 siswa:");

        // Loop untuk input nilai dan langsung menghitung total, min, max
        for (int i = 0; i < nilaiSiswa.length; i++) {
            System.out.print("Nilai siswa ke-" + (i + 1) + ": ");
            int nilai = input.nextInt();
            nilaiSiswa[i] = nilai;

            // 2. Hitung total nilai
            totalNilai += nilai;

            // 3. Cari nilai tertinggi
            if (nilai > nilaiTertinggi) {
                nilaiTertinggi = nilai;
            }

            // 4. Cari nilai terendah
            if (nilai < nilaiTerendah) {
                nilaiTerendah = nilai;
            }
        }

        // 5. Hitung rata-rata
        double rataRata = (double) totalNilai / nilaiSiswa.length;

        // 6. Tampilkan hasil
        System.out.println("\n--- Hasil Analisis Nilai ---");
        System.out.println("Rata-rata nilai: " + rataRata);
        System.out.println("Nilai tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai terendah: " + nilaiTerendah);

        input.close();
    }
}