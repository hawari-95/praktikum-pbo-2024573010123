package modul_6.praktikum_4;

public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private int numberOpPages;

    public Book(String itemId,String title, int year, String author, String isbn, int numberOpPages) {
        super(itemId, title, year);
        this.author = author;
        this.isbn = isbn;
        this.numberOpPages = numberOpPages;
    }

    @Override
    public void displayInfo() {
        System.out.println("BUKU");
        System.out.println("-----------------------");
        System.out.println("ID : " + itemId);
        System.out.println("Judul: " + title);
        System.out.println("Penulis : " + author);
        System.out.println("ISBN : " + isbn);
        System.out.println("Jumlah Halaman: " + numberOpPages);
        System.out.println("Status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
        System.out.println("-----------------------");
    }

    // methods khusus Book
    public void readSample() {
        System.out.println("Membaca sample dari buku: " + title);
    }
}
