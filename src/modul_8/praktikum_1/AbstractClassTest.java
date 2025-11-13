package modul_8.praktikum_1;

public class AbstractClassTest {
    public static void main(String[] args) {
        // Tidak bisa membuat instance abstract class langsung
        // Shape sape = new Shape("Red", true); // ERROR!

        // membuat object dari concrete subclass
        Circle circle = new Circle("Red", true, 5.0);
        Rectangle rectangle = new Rectangle("Blue", false, 4.0, 6.0);

        System.out.println("DEMONSTRASI ABSTRACT CLASS");

        // Menggunakan abstract class reference
        Shape shape1 = circle;
        Shape shape2 = rectangle;

        // Polymorphic calls
        shape1.displayInfo();
        System.out.println();

        shape2.displayInfo();
        System.out.println();

        // Mengakses method khusus subsclass melalui casting
        System.out.println("Circle Diameter: " + circle.getDiameter());
        System.out.println("Is Rectangle Square? " + rectangle.isSquare());

        // array of shapes - demonstrating polymorphism
        System.out.println("\nARRAY OF SHAPES");
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Green", true, 3.0);
        shapes[1] = new Rectangle("Yellow", true, 5.0, 5.0);
        shapes[2] = new Circle("Purple", false, 7.0);

        double totalArea = 0;
        for (Shape shape : shapes) {
            shape.displayInfo();
            totalArea += shape.calculateArea(); //  Abstract method call
            System.out.println();
        }

        System.out.println("Total Area of All Shapes: " + totalArea);
    }
}
