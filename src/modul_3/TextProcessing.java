package modul_3;

import java.util.Scanner;
import java.util.Arrays;

public class TextProcessing {

    public static String[] prosesDataMahasiswa(String data) {
        System.out.println("Data yang dimasukkan: " + data);
        // Memisahkan data berdasarkan koma
        String[] namaMahasiswa = data.split(",");
        for (int i = 0; i < namaMahasiswa.length; i++) {
            // Menghilangkan spasi
            namaMahasiswa[i] = namaMahasiswa[i].trim();
        }
        return namaMahasiswa;
    }

    // Analisis data
    public static void analisisData(String[] namaMahasiswa) {
        System.out.println("\n======== ANALISIS DATA ========");
        System.out.println("Jumlah mahasiswa: " + namaMahasiswa.length);

        // Cari nama terpanjang dan terpendek
        String namaTerpanjang = namaMahasiswa[0];
        String namaTerpendek = namaMahasiswa[0];

        for (String nama : namaMahasiswa) {
            if (nama.length() > namaTerpanjang.length()) {
                namaTerpanjang = nama;
            }
            if (nama.length() < namaTerpendek.length()) {
                namaTerpendek = nama;
            }
        }
        System.out.println("Nama terpanjang: " + namaTerpanjang + " (" + namaTerpanjang.length() + " karakter)");
        System.out.println("Nama terpendek: " + namaTerpendek + " (" + namaTerpendek.length() + " karakter)");

        // Mengurutkan nama secara alfabetis
        String[] namaUrut = Arrays.copyOf(namaMahasiswa, namaMahasiswa.length);
        Arrays.sort(namaUrut, String.CASE_INSENSITIVE_ORDER);

        System.out.println("\nNama mahasiswa (urutan alfabetis):");
        for (int i = 0; i < namaUrut.length; i++) {
            System.out.println((i + 1) + ". " + namaUrut[i]);
        }
    }

    // Format Nama
    public static void formatNama(String nama) {
        System.out.println("\n======== FORMAT NAMA ========");
        String namaFormatted = formatTitleCase(nama);
        System.out.println("Nama lengkap: " + namaFormatted);
        System.out.println("Inisial: " + buatInisial(nama));
        System.out.println("Username: " + buatUsername(namaFormatted));
    }

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

    public static String buatUsername(String nama) {
        return nama.toLowerCase().replaceAll("\\s+", ".").replaceAll("[^a-z0-9.]", "");
    }


    public static void main(String[] args) {
        System.out.println("======== PROGRAM PENGOLAHAN DATA TEKS ========");
        System.out.print("Masukkan nama-nama mahasiswa (pisahkan dengan koma): ");
        Scanner input = new Scanner(System.in);
        String dataNama = input.nextLine();

        // Proses data
        String[] arrayNama = prosesDataMahasiswa(dataNama);

        // Analisis Data
        analisisData(arrayNama);

        // Format Nama (ambil nama pertama sebagai contoh)
        if (arrayNama.length > 0) {
            formatNama(arrayNama[0]);
        }
    }
}
