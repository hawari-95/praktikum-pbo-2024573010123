package modul_4;

public class KartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private MataKuliah[] daftarMataKuliah;
    private int jumlahMataKuliah;
    private int maxMataKuliah;
    private final int BATAS_SKS = 24; // batas maksimum total SKS


    public KartuRencanaStudi(Mahasiswa mahasiswa, int maxMataKuliah) {
        this.mahasiswa = mahasiswa;
        this.maxMataKuliah = maxMataKuliah;
        this.daftarMataKuliah = new MataKuliah[maxMataKuliah];
        this.jumlahMataKuliah = 0;
    }

    public boolean tambahMataKuliah(MataKuliah matkul) {
        int totalSebelum = hitungTotalSKS();
        if (jumlahMataKuliah >= maxMataKuliah) {
            System.out.println("\n KRS sudah penuh! Maksimal " + maxMataKuliah + " mata kuliah.");
            return false;
        }
        if (totalSebelum + matkul.getSks() > BATAS_SKS) {
            System.out.println("\n Tidak bisa menambah. Total SKS akan melebihi batas " + BATAS_SKS + ".");
            return false;
        }

        daftarMataKuliah[jumlahMataKuliah] = matkul;
        jumlahMataKuliah++;
        System.out.println("\n Mata kuliah '" + matkul.getNama() + "' berhasil ditambahkan.");
        return true;
    }

    public boolean hapusMataKuliah(String kode) {
        for (int i = 0; i < jumlahMataKuliah; i++) {
            if (daftarMataKuliah[i].getKode().equalsIgnoreCase(kode)) {
                // Geser elemen ke kiri untuk menutup celah
                for (int j = i; j < jumlahMataKuliah - 1; j++) {
                    daftarMataKuliah[j] = daftarMataKuliah[j + 1];
                }
                daftarMataKuliah[jumlahMataKuliah - 1] = null;
                jumlahMataKuliah--;
                System.out.println(" Mata kuliah dengan kode " + kode + " berhasil dihapus.");
                return true;
            }
        }
        System.out.println(" Mata kuliah dengan kode " + kode + " tidak ditemukan.");
        return false;
    }

    // Hitung total SKS
    public int hitungTotalSKS() {
        int total = 0;
        for (int i = 0; i < jumlahMataKuliah; i++) {
            total += daftarMataKuliah[i].getSks();
        }
        return total;
    }

    // Hitung IPK
    public double hitungIPK() {
        if (jumlahMataKuliah == 0) return 0.0;

        double totalBobot = 0.0;
        int totalSKS = 0;

        for (int i = 0; i < jumlahMataKuliah; i++) {
            MataKuliah mk = daftarMataKuliah[i];
            totalBobot += mk.getBobotNilai() * mk.getSks();
            totalSKS += mk.getSks();
        }

        return totalSKS > 0 ? totalBobot / totalSKS : 0.0;
    }

    public void tampilkanNilaiTerbaikDanTerburuk() {
        if (jumlahMataKuliah == 0) {
            System.out.println("Belum ada mata kuliah untuk dievaluasi.");
            return;
        }

        MataKuliah terbaik = daftarMataKuliah[0];
        MataKuliah terburuk = daftarMataKuliah[0];

        for (int i = 1; i < jumlahMataKuliah; i++) {
            if (daftarMataKuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMataKuliah[i];
            }
            if (daftarMataKuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMataKuliah[i];
            }
        }

        System.out.println("\n--- Nilai Mata Kuliah Terbaik ---");
        System.out.printf("%s (%.2f - %s)\n", terbaik.getNama(), terbaik.getNilai(), terbaik.getNilaiHuruf());

        System.out.println("\n--- Nilai Mata Kuliah Terburuk ---");
        System.out.printf("%s (%.2f - %s)\n", terburuk.getNama(), terburuk.getNilai(), terburuk.getNilaiHuruf());
    }

    // Tampilkan semua KRS
    public void tampilkanKRS() {
        System.out.println("\n==================================================");
        System.out.println("                KARTU RENCANA STUDI (KRS)");
        System.out.println("==================================================");
        System.out.println("Nama Mahasiswa : " + mahasiswa.getNama());
        System.out.println("NIM            : " + mahasiswa.getNim());
        System.out.println("Jurusan        : " + mahasiswa.getJurusan());
        System.out.println("--------------------------------------------------");
        System.out.println("Kode     Mata Kuliah                   SKS  NILAI");
        System.out.println("--------------------------------------------------");

        if (jumlahMataKuliah == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (int i = 0; i < jumlahMataKuliah; i++) {
                daftarMataKuliah[i].tampilkanInfo();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total SKS     : " + hitungTotalSKS());
        System.out.printf("IPK Semester  : %.2f%n", hitungIPK());
        System.out.println("==================================================\n");
    }

    // Cari mata kuliah
    public MataKuliah cariMataKuliah(String kode) {
        for (int i = 0; i < jumlahMataKuliah; i++) {
            if (daftarMataKuliah[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMataKuliah[i];
            }
        }
        return null;
    }
}
