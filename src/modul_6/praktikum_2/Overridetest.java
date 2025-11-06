package modul_6.praktikum_2;

public class Overridetest {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 277, 2);

        // memanggil overriden method
        car.start();
        car.displayInfo();
        car.honk();

        // Demonstrasi polymorphism
        Vehicle vehicle = new Car("Pagani", 320, 2);
        vehicle.start(); // memanggil method yang di-override
        vehicle.displayInfo(); // memanggil method yang di override
    }
}
