package modul_4;

public class Mahasiswa {
    // Atribut/Field (bersifat private untuk menerapkan enkapsulasi)
    private String nama;
    private String nim;
    private String jurusan;

    // Constructor dengan parameter
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        // Catatan: parameter ipk belum digunakan dalam atribut
    }

    // Getter methods
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }
}

