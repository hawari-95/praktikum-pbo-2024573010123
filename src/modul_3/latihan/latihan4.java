package modul_3.latihan;

import java.util.Scanner;
import java.util.Arrays;

public class latihan4 {

    // Method dari praktikum
    public static int[] inputArray(int ukuran) {
        int[] array = new int[ukuran];
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan " + ukuran + " angka:");
        for (int i = 0; i < ukuran; i++) {
            System.out.print("Angka ke-" + (i + 1) + ": ");
            array[i] = input.nextInt();
        }
        return array;
    }

    // Method dari praktikum
    public static void tampilkanArray(int[] array) {
        System.out.print(Arrays.toString(array)); // Cara lebih singkat
    }

    // Method dari praktikum
    public static int cariMaksimum(int[] array) {
        int maks = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maks) maks = array[i];
        }
        return maks;
    }

    // Method dari praktikum
    public static int cariMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    // Method dari praktikum
    public static double hitungRataRata(int[] array) {
        int total = 0;
        for (int nilai : array) total += nilai;
        return (double) total / array.length;
    }

    // Method dari praktikum
    public static int[] urutkanArray(int[] array) {
        int[] arrayBaru = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayBaru); // Menggunakan method sort bawaan Java
        return arrayBaru;
    }

    // TUGAS 1: Method untuk mencari nilai tertentu
    public static int cariNilai(int[] array, int nilaiDicari) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == nilaiDicari) {
                return i; // Mengembalikan indeks jika ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika tidak ditemukan
    }

    // TUGAS 2: Method untuk menghitung median (menerima array terurut)
    public static double hitungMedian(int[] arrayUrut) {
        int n = arrayUrut.length;
        if (n % 2 != 0) {
            // Jika ganjil, ambil nilai tengah
            return arrayUrut[n / 2];
        } else {
            // Jika genap, ambil rata-rata dua nilai tengah
            int tengah1 = arrayUrut[(n / 2) - 1];
            int tengah2 = arrayUrut[n / 2];
            return (double) (tengah1 + tengah2) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("======== PROGRAM ANALISIS ARRAY ========");
        int[] data = inputArray(5);

        System.out.println("\n======== HASIL ANALISIS ========");
        System.out.print("Array Asli: ");
        tampilkanArray(data);
        System.out.println("\nNilai Maksimum: " + cariMaksimum(data));
        System.out.println("Nilai Minimum: " + cariMinimum(data));
        System.out.printf("Rata-rata: %.2f%n", hitungRataRata(data));

        int[] dataUrut = urutkanArray(data);
        System.out.print("Array Urut: ");
        tampilkanArray(dataUrut);

        // Menjalankan method tugas
        System.out.println("\n\n======== FITUR TAMBAHAN ========");

        // Tugas 1: Pencarian
        System.out.print("Masukkan nilai yang ingin dicari: ");
        int cari = input.nextInt();
        int indeks = cariNilai(data, cari);
        if (indeks != -1) {
            System.out.println("Nilai " + cari + " ditemukan di indeks " + indeks);
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }

        // Tugas 2: Median
        double median = hitungMedian(dataUrut); // Menggunakan array yang sudah diurutkan
        System.out.println("Median dari array terurut: " + median);

        input.close();
    }
}