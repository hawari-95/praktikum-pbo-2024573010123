package modul_5.Praktikum_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private final String productId;
    private final LocalDateTime createdAt;

    private String nama;
    private double harga;
    private int stok;

    private String adminPin;

    private static int counter = 1000;

    public Product(String nama, double harga, int stok, String adminPin) {
        this.productId = generateProductId();
        this.createdAt = LocalDateTime.now();
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.adminPin = adminPin;
    }

    private String generateProductId() {
        counter++;
        return "PRD-" + counter;
    }

    private boolean validatePin(String adminPin) {
        return this.adminPin.equals(adminPin);
    }

    public  String getProductId() {
        return productId;
    }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createdAt.format(formatter);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama, String pin) {
        if (!validatePin(pin)) {
            System.out.println(" X PIN salah! Gagal mengubah nama.");
            return;
        }

        if (nama == null || nama.trim().isEmpty()) {
            System.out.println(" X Nama Produk tidak boleh kosong!");
            return;
        }

        this.nama = nama;
        System.out.println(" ✓ Nama Produk berhasil di ubah");
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga, String pin) {
        if (!validatePin(pin)) {
            System.out.println(" X Pin salah! Gagal mengubah Harga. ");
            return;
        }

        if (harga < 0) {
            System.out.println(" X Harga tidak boleh Negatif!");
            return;
        }

        this.harga = harga;
        System.out.printf("✓ Harga berhasil di ubah menjadi Rp %.2f\n", harga);
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok, String pin) {
        if (!validatePin(pin)) {
            System.out.println("X PIN salah! Gagal mengubah Stok.");
            return;
        }

        if (stok < 0) {
            System.out.println("X Stok tidak boleh Negatif!");
            return;
        }

        this.stok = stok;
        System.out.println("✓ Stok berhasil di ubah menjadi " + stok);
    }

    public void changeAdminPin(String oldPin, String newPin) {
        if (!validatePin(oldPin)) {
            System.out.println("X PIN lama salah!");
            return;
        }

        if (newPin.length() <= 4) {
            System.out.println("X PIN baru minimal 4 karakter!");
            return;
        }

        this.adminPin = newPin;
        System.out.println("✓ PIN berhasil diubah");
    }

    public double getTotalNilai() {
        return harga * stok;
    }

    public String GetStatusStok() {
        if (stok == 0) return "HABIS";
        else if (stok < 10) return "MENIPIS";
        else if (stok < 50) return "TERSEDIA";
        else return "BANYAK";
    }

    public boolean tambahStok(int jumlah, String pin) {
        if (!validatePin(pin)) {
            System.out.println("X PIN salah!");
            return false;
        }

        if (jumlah <= 0) {
            System.out.println("X Jumlah Harus lebih dari 0!");
            return false;
        }

        stok += jumlah;
        System.out.printf("✓ Stok Ditambah %d. Stok sekarang %d\n", jumlah, stok);
        return true;
    }

    public boolean kurangStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("X Jumlah Harus lebih dari 0!");
            return false;
        }

        if (jumlah > stok) {
            System.out.println("X Stok tidak cukup!!");
            System.out.printf(" Stok Tersedia: %d, Diminta: %d\n", stok, jumlah);
            return false;
        }

        stok -= jumlah;
        System.out.printf("✓ Stok dikurangi %d. Stok sekarang %d\n", jumlah, stok);

        if (stok < 10) {
            System.out.println("Peringatan: Stok Menipis!");
        }

        return true;
    }

    public void tampilkanInfo() {
        System.out.println("INFORMASI PRODUK");
        System.out.println("---------------------------------");
        System.out.println("PRODUK ID   : " + productId);
        System.out.println(" Nama       : " + nama);
        System.out.printf(" Harga      : Rp %.2f\n", harga );
        System.out.println(" Stok       : " + stok + " (" + GetStatusStok() + ")");
        System.out.printf(" Total Nilai : Rp %.2f\n", + getTotalNilai());
        System.out.println("---------------------------------");

    }
}
