package modul_6.praktikum_1;

public class InheritanceTest {
    public static void main(String[] args) {
        Student student = new Student("Hawari", 19, "2024573010123");

        //memanggul method dari superclass
        student.displayinfo();

        // memanggul method dari subclass
        student.study();

        // memanggil overriden method
        student.greet();

        // polymorphism: Student sebagai person
        Person person = new Student("Fauzan", 19, "2024573010124");
        person.greet(); // untuk memanggil method yang di-override
    }
}
