package modul_3.latihan;

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern; // Import untuk validasi

public class latihan6 {

    // Method dari praktikum
    public static String[] prosesDataMahasiswa(String data) {
        String[] namaMahasiswa = data.split(",");
        for (int i = 0; i < namaMahasiswa.length; i++) {
            namaMahasiswa[i] = namaMahasiswa[i].trim();
        }
        return namaMahasiswa;
    }

    // Method dari praktikum
    public static void analisisData(String[] namaMahasiswa) {
        System.out.println("\n======== ANALISIS DATA ========");
        System.out.println("Jumlah mahasiswa: " + namaMahasiswa.length);
        // ... (Analisis nama terpanjang/terpendek, dll. bisa ditambahkan di sini)
    }

    // Method dari praktikum (dimodifikasi untuk TUGAS 1)
    public static void formatNama(String nama) {
        System.out.println("\n======== FORMAT NAMA ========");
        String namaFormatted = formatTitleCase(nama);
        String username = buatUsername(namaFormatted);

        System.out.println("Nama lengkap: " + namaFormatted);
        System.out.println("Inisial: " + buatInisial(nama));
        System.out.println("Username: " + username);

        // TUGAS 1: Menghasilkan email address
        System.out.println("Email: " + username + "@latihan.com");
    }

    // Method dari praktikum
    public static String formatTitleCase(String teks) {
        String[] kata = teks.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String k : kata) {
            if (k.length() > 0) {
                result.append(Character.toUpperCase(k.charAt(0)))
                        .append(k.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    // Method dari praktikum
    public static String buatInisial(String nama) {
        String[] kata = nama.split("\\s+");
        StringBuilder inisial = new StringBuilder();
        for (String k : kata) {
            if (k.length() > 0) {
                inisial.append(Character.toUpperCase(k.charAt(0)));
            }
        }
        return inisial.toString();
    }

    // Method dari praktikum
    public static String buatUsername(String nama) {
        return nama.toLowerCase().replaceAll("\\s+", ".").replaceAll("[^a-z0-9.]", "");
    }

    // TUGAS 2: Method validasi nama (hanya boleh huruf dan spasi)
    public static boolean validasiNama(String nama) {
        // Regex ini berarti: "harus terdiri dari 1 atau lebih huruf (a-z, A-Z) dan spasi"
        return Pattern.matches("^[a-zA-Z\\s]+$", nama);
    }

    public static void main(String[] args) {
        System.out.println("======== PROGRAM PENGOLAHAN DATA TEKS ========");
        System.out.print("Masukkan nama-nama mahasiswa (pisahkan dengan koma): ");
        Scanner input = new Scanner(System.in);
        String dataNama = input.nextLine();

        // Proses data
        String[] arrayNama = prosesDataMahasiswa(dataNama);
        analisisData(arrayNama);

        // Validasi dan Format setiap nama
        for (String nama : arrayNama) {
            System.out.println("\n---------------------------------");
            // TUGAS 2: Memanggil validasi
            if (validasiNama(nama)) {
                System.out.println("Validasi '" + nama + "': OK");
                formatNama(nama);
            } else {
                System.out.println("Validasi '" + nama + "': GAGAL (Mengandung angka/simbol)");
            }
        }
    }
}