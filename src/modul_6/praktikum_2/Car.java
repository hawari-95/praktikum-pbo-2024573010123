package modul_6.praktikum_2;

public class Car extends Vehicle {
    private  int numberOfDoors;

    public Car(String brand, int speed, int numberOfDoors) {
        super(brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car engine is running smoothly");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // untuk memanggil methode displayInfo dari superclass
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    public void honk () {
        System.out.println("Beep beep!");
    }
}
