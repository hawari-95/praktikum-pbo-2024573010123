package modul_3.latihan;

import java.util.Scanner;

public class latihan5 {

    public static void analisisString(String teks) {
        System.out.println("\n======== ANALISIS STRING ========");
        System.out.println("Teks asli: " + teks);
        System.out.println("Panjang string: " + teks.length());

        // Menghitung jumlah kata
        String[] kata = teks.split("\\s+");
        System.out.println("Jumlah kata: " + kata.length);

        // Menghitung jumlah vokal
        System.out.println("Jumlah vokal: " + hitungVokal(teks));

        // TUGAS 1: Menghitung jumlah konsonan
        System.out.println("Jumlah konsonan: " + hitungKonsonan(teks));
    }

    public static int hitungVokal(String teks) {
        String vokal = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < teks.length(); i++) {
            if (vokal.contains(String.valueOf(teks.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    // TUGAS 1: Method hitung konsonan
    public static int hitungKonsonan(String teks) {
        String vokal = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < teks.length(); i++) {
            char ch = teks.charAt(i);
            // Cek apakah karakter adalah huruf DAN bukan vokal
            if (Character.isLetter(ch) && !vokal.contains(String.valueOf(ch))) {
                count++;
            }
        }
        return count;
    }

    // Method dari praktikum
    public static String reverseString(String teks) {
        return new StringBuilder(teks).reverse().toString();
    }

    // Method dari praktikum
    public static boolean isPalindrome(String teks) {
        String clean = teks.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    // TUGAS 2: Method Pascal Case (Title Case)
    public static String toTitleCase(String teks) {
        String[] kata = teks.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String k : kata) {
            if (k.length() > 0) {
                result.append(Character.toUpperCase(k.charAt(0))) // Huruf pertama kapital
                        .append(k.substring(1).toLowerCase())      // Sisanya huruf kecil
                        .append(" ");
            }
        }
        return result.toString().trim(); // Menghilangkan spasi di akhir
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("======== PROGRAM MANIPULASI STRING ========");
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();

        // Analisis dasar (termasuk vokal dan konsonan)
        analisisString(kalimat);

        // Cek palindrome
        System.out.println("\nCek Palindrome:");
        if (isPalindrome(kalimat)) {
            System.out.println("-> String ini ADALAH palindrome.");
        } else {
            System.out.println("-> String ini BUKAN palindrome.");
        }

        // TUGAS 2: Panggil method Title Case
        System.out.println("\nFormat Title Case:");
        System.out.println("-> " + toTitleCase(kalimat));

        input.close();
    }
}