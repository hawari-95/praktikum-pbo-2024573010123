package modul_7.praktikum_1;

public class Calculator {

    // Method untuk menjumlahkan dua integer
    public int add(int a, int b) {
        System.out.println("Memanggil add(int, int)");
        return a + b;
    }

    // overload method untuk menjumlahkan tiga integar
    public int add(int a, int b, int c) {
        System.out.println("Memanggil add(int, int, int)");
        return a + b + c;
    }

    // overload method untuk menjumlahkan array integer
    public double add(double a, double b) {
        System.out.println("Memanggil add(double, double)");
        return a + b;
    }

    // overload method untuk menjumlahkan array integer
    public int add(int[] numbers) {
        System.out.println("Memanggil add(int[])");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // overload method untuk concatenate strings
    public String add(String a, String b) {
        System.out.println("Memanggil add(String a, String b)");
        return a + b;
    }
}
