package modul_6.praktikum_4;

public class Magazine extends LibraryItem {
    private String publisher;
    private int issueNumber;
    private String category;

    public Magazine(String itemId, String title, int year, String publisher, int issueNumber, String category) {
        super(itemId, title, year);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.category = category;
    }

    @Override
    public void displayInfo() {
        System.out.println("-------- MAJALAH --------");
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("publisher: " + publisher);
        System.out.println("Year: " + year);
        System.out.println("Edisi: " + issueNumber);
        System.out.println("Category: " + category);
        System.out.println("status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
        System.out.println("------------------------");
    }

    // method khusus untuk magazin
    public void browseArticles() {
        System.out.println("Menelusuri artikel dalam majalah: " + title);
    }
}
