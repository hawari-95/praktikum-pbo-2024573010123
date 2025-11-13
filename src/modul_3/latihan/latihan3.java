package modul_3.latihan;

public class latihan3 {

    // Method dari praktikum
    public static void tampilkanHeader() {
        System.out.println("======================================");
        System.out.println("      PROGRAM KALKULATOR CANGGIH      ");
        System.out.println("======================================");
    }

    // Method dari praktikum
    public static void tampilkanHasil(String operasi, double a, double b, double hasil) {
        System.out.printf("%.2f %s %.2f = %.2f%n", a, operasi, b, hasil);
    }

    // Method baru untuk operasi dengan 1 angka (Akar)
    public static void tampilkanHasilSatuAngka(String operasi, double a, double hasil) {
        System.out.printf("%s(%.2f) = %.2f%n", operasi, a, hasil);
    }

    // Method dari praktikum
    public static double tambah(double a, double b) {
        return a + b;
    }

    // Method dari praktikum
    public static double kurang(double a, double b) {
        return a - b;
    }

    // Method dari praktikum
    public static double kali(double a, double b) {
        return a * b;
    }

    // Method dari praktikum (validasi pembagian nol sudah ada)
    public static double bagi(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Pembagian dengan nol!");
            return 0;
        }
    }

    // TUGAS 1: Method Pangkat
    public static double pangkat(double a, double b) {
        return Math.pow(a, b);
    }

    // TUGAS 2: Method Akar Kuadrat
    public static double akarKuadrat(double a) {
        if (a < 0) {
            System.out.println("Error: Tidak bisa menghitung akar angka negatif!");
            return 0;
        }
        return Math.sqrt(a);
    }

    // Method dari praktikum
    public static boolean validasiAngka(double angka) {
        return !Double.isNaN(angka) && Double.isInfinite(angka);
    }

    public static void main(String[] args) {
        tampilkanHeader();

        double x = 16.0; // Diubah agar mudah diakar
        double y = 2.0;  // Pangkat 2

        if (validasiAngka(x) && validasiAngka(y)) {
            // Operasi dari praktikum
            tampilkanHasil("+", x, y, tambah(x, y));
            tampilkanHasil("-", x, y, kurang(x, y));
            tampilkanHasil("*", x, y, kali(x, y));
            tampilkanHasil("/", x, y, bagi(x, y));

            System.out.println("--- Operasi Tambahan ---");
            // Memanggil method baru
            tampilkanHasil("^", x, y, pangkat(x, y)); // x pangkat y
            tampilkanHasilSatuAngka("sqrt", x, akarKuadrat(x)); // akar x
        }
    }
}