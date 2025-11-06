package modul_6.praktikum_3;

public class InheritanceTypeTest {
    public static void main(String[] args) {
        // Multivelev inheritance test
        Dog dog = new Dog("Buddy", "Brown", "Golden Retriever");
        dog.eat(); // dari Animal, di-override di Dog
        dog.sleep(); // dari Animal
        dog.giveBirth(); // dari Mammal
        dog.bark(); // dari Dog

        System.out.println();

        //hierarchical inheritance test
        Cat cat = new Cat("Whiskers", "White", true);
        cat.eat(); // dari Animal, di override di Cat
        cat.sleep();
        cat.giveBirth();
        cat.meow();

        System.out.println();

        //Polymorphism dengan hierarchical inheritance
        Animal[] animals = {new Dog("Max", "Black", "Labrador"),
                            new Cat("Luna", "Gray", false)};

        for (Animal animal : animals) {
            animal.eat(); // akan memanggil method yang sesuai dengan objek sebenarnya
        }
    }
}
