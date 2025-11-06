package modul_6.praktikum_4;

public class DVD extends LibraryItem {
    private String director;
    private int duration;
    private String genre;

    public DVD(String itemId, String title, int year, String director, int duration, String genre) {
        super(itemId, title, year);
        this.director = director;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- DVD -----");
        System.out.println("ID: " + itemId);
        System.out.println("Judul: " + title);
        System.out.println("Sutradara: " + director);
        System.out.println("Durasi: " + duration + " Menit");
        System.out.println("Genre: " + genre);
        System.out.println("status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
        System.out.println("----------------------");
    }

    // method khusus untuk DVD
    public void playtrailer() {
        System.out.println("Memutar trailer DVD: " + title);
    }
}
