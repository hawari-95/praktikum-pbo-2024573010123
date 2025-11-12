# Laporan Modul 6 : Inheritance
**Mata Kuliah:** Praktikum Pemrograman Berorientasi Objek   
**Nama:** Muhammad Hawari
**NIM:** 2024573010123  
**Kelas:** TI 2E

---
## Pendahuluan

Pemrograman berorientasi objek (Object-Oriented Programming/OOP) merupakan paradigma pemrograman yang berfokus pada konsep objek yang merepresentasikan entitas dunia nyata.
Salah satu konsep utama dalam OOP adalah Inheritance (pewarisan), yaitu kemampuan suatu kelas untuk mewarisi atribut dan method dari kelas lain.

Dengan menggunakan inheritance, pengembang dapat menciptakan hubungan hierarki antar kelas, sehingga kode dapat digunakan kembali (reusability), lebih terstruktur, dan lebih mudah dipelihara.
Inheritance juga memungkinkan pembuatan kelas baru berdasarkan kelas yang sudah ada tanpa harus menulis ulang seluruh kode, melainkan cukup menambahkan atau memodifikasi perilaku tertentu sesuai kebutuhan.

---

## Landasan Teori

### 1. Pengertian Inheritance

Dalam pemrograman berorientasi objek (Object-Oriented Programming/OOP), Inheritance atau pewarisan adalah mekanisme yang memungkinkan sebuah kelas untuk mewarisi atribut dan method dari kelas lain.
Tujuan utamanya adalah agar kode dapat digunakan kembali (code reusability) dan untuk menciptakan hubungan hierarkis antar kelas.

Dalam konsep ini:

+ Kelas induk (superclass) adalah kelas yang menyediakan atribut dan perilaku umum.
+ Kelas anak (subclass) adalah kelas yang mewarisi karakteristik tersebut, namun juga dapat memiliki atribut dan perilaku tambahan yang lebih spesifik.

Dengan kata lain, inheritance menggambarkan hubungan "is-a" (adalah-sebuah).
Misalnya, jika Dog adalah subclass dari Animal, maka hubungan tersebut bisa dijelaskan dengan kalimat “Dog is an Animal”.

---

### 2. Tujuan dan Manfaat Inheritance

Konsep inheritance memiliki beberapa manfaat utama yang sangat penting dalam desain program berbasis objek, yaitu:

1. Reusability (Penggunaan Kembali Kode)

   - Kelas anak tidak perlu menulis ulang semua atribut dan method dari kelas induk.
   Cukup mewarisi, sehingga kode menjadi lebih efisien dan mudah dikelola.

2. Extensibility (Dapat Diperluas)

   - Subclass dapat menambahkan perilaku baru atau memodifikasi method yang diwarisi dengan cara overriding.

3. Abstraction dan Generalization

   - Inheritance memungkinkan kita membuat hierarki dari objek-objek dunia nyata secara logis.
   Misalnya: Animal → Mammal → Dog.

4. Maintenance Lebih Mudah

   - Perubahan pada kelas induk otomatis berlaku untuk semua kelas anak, sehingga mengurangi duplikasi dan mempermudah pemeliharaan kode.

![gambarInheritanceJava](gambar/inheritance.jpg)

---

### Cara Implementasi Program

- Gunakan kata kunci `extends` untuk mewarisi dari sebuah class.
- Subclass dapat mengakses anggota (fields dan methods) yang bersifat `protected` dan `public` dari superclass.
- Subclass dapat mengoverride method dari superclass.
- Gunakan kata kunci `super` untuk mengakses anggota superclass.

---

### 3. Jenis-Jenis Inheritance
#### a. Single Inheritance (Pewarisan Tunggal)

Jenis inheritance yang paling umum digunakan.
Dalam single inheritance, satu subclass hanya mewarisi dari satu superclass.

Contoh:
```java
class Animal {
    void eat() {
        System.out.println("Hewan sedang makan...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Anjing menggonggong!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // diwarisi dari Animal
        d.bark();  // milik Dog
    }
}

```
Penjelasan:

- `Dog` adalah subclass dari `Animal`.
- `Dog` mewarisi method `eat()` dari `Animal`.
- Ini adalah bentuk pewarisan paling sederhana dan paling sering digunakan.

---

#### b. Multilevel Inheritance (Pewarisan Bertingkat)

Dalam jenis ini, sebuah kelas mewarisi dari kelas lain, dan kelas tersebut juga menjadi induk bagi kelas berikutnya.
Artinya, pewarisan terjadi secara berantai.

Contoh:
```java
class Animal {
    void eat() {
        System.out.println("Hewan sedang makan...");
    }
}

class Mammal extends Animal {
    void breathe() {
        System.out.println("Mamalia bernafas dengan paru-paru.");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Anjing menggonggong!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();     // dari Animal
        d.breathe(); // dari Mammal
        d.bark();    // dari Dog
    }
}

```
Penjelasan:

- `Dog` mewarisi dari `Mammal`, dan `Mammal` mewarisi dari `Animal`.
- Sehingga, `Dog` secara tidak langsung juga mewarisi semua atribut dan method dari `Animal`.
- Ini menggambarkan hierarki alami, seperti dalam klasifikasi makhluk hidup.

---

#### c. Hierarchical Inheritance (Pewarisan Bertingkat Lebar)

Dalam hierarchical inheritance, satu superclass diwarisi oleh beberapa subclass sekaligus.
Setiap subclass memiliki perilaku tambahan sendiri, tetapi berbagi atribut dan method umum dari superclass.

Contoh:
```java
class Animal {
    void eat() {
        System.out.println("Hewan sedang makan...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Anjing menggonggong!");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Kucing mengeong!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        d.eat();
        c.eat();
        d.bark();
        c.meow();
    }
}

```
Penjelasan:

- `Dog` dan `Cat` sama-sama merupakan subclass dari `Animal`.
- Mereka mewarisi perilaku umum `eat()` tetapi menambahkan perilaku spesifik masing-masing `(bark() dan meow())`.

---

#### d. Multiple Inheritance (Pewarisan Ganda – melalui Interface)

Java tidak mengizinkan multiple inheritance antar kelas, tetapi mengizinkannya melalui interface.
Hal ini untuk menghindari konflik pewarisan (misalnya dua kelas induk memiliki method dengan nama sama).

Contoh:
```java
interface Animal {
    void eat();
}

interface Pet {
    void play();
}

class Dog implements Animal, Pet {
    public void eat() {
        System.out.println("Anjing sedang makan.");
    }
    public void play() {
        System.out.println("Anjing bermain bola.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}

```

Penjelasan:

- `Dog` mengimplementasikan dua interface: `Animal` dan `Pet`.
- Meskipun Java tidak memperbolehkan class `Dog` extends `Animal,` `Pet`,
tetapi implements dapat digunakan untuk mendapatkan perilaku ganda.
- Dengan interface, Java dapat menggunakan konsep multiple inheritance secara aman.

---

#### e. Hybrid Inheritance (Pewarisan Campuran)

Hybrid inheritance merupakan kombinasi dari beberapa jenis inheritance, misalnya penggabungan antara multilevel dan multiple inheritance.

Namun di Java, hybrid inheritance hanya bisa dilakukan melalui kombinasi kelas dan interface, bukan antar kelas murni.

Contoh:
```java
interface Animal {
    void eat();
}

class Mammal {
    void breathe() {
        System.out.println("Mamalia bernafas.");
    }
}

class Dog extends Mammal implements Animal {
    public void eat() {
        System.out.println("Anjing makan tulang.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.breathe();
    }
}

```

Penjelasan:

- `Dog` mewarisi dari `Mammal` (kelas induk) dan juga mengimplementasikan `Animal` (interface).
- Ini adalah bentuk kombinasi antara pewarisan tunggal dan pewarisan melalui interface.
- Contoh ini memperlihatkan bagaimana hybrid inheritance tetap bisa diterapkan di Java tanpa menimbulkan konflik.

---

### 3 Tabel Perbandingan Jenis Inheritance

| Jenis Inheritance        | Jumlah Superclass             | Dapat digunakan di Java   | Contoh Penggunaan               |
|--------------------------|-------------------------------|---------------------------|---------------------------------|
| Single Inheritance       | 1                             | iya                       | `Class B extends A`             |
| Multilevel Inheritance   | Lebih dari 1 (Bertingkat)     | iya                       | `Class C extends B extends A`   |
| Hierarchical Inheritance | 1 Superclass Banyak Superclass | iya                       | `Class Dog, Cat extends Animal` |
| Multiple Inheritance     | Lebih besar dari Superclass   | Tidak (Kecuali interface) | `Class C Implements A, B`       |
| Hybrid Inheritance       | Kombinasi Class + Interface   | ya                        | `Class C entends A, Implement B` |

---


## 2. Praktikum 1 : Memahami Access Modifier

---

#### Tujuan

#### Hasil :


##### Analisis :

---

## Praktikum 2: Getter dan Setter

---

#### Teori Dasar

---

#### Analisis



---
### Praktikum 3: Read-Only dan Write-Only Properties
---

#### Tujuan

#### Output :

---


### Analisis :


---

### Kesimpulan

Class Product dan ProductTest secara rinci menunjukkan bagaimana enkapsulasi:

- Menyembunyikan data penting (adminPin, productId, createdAt).
- Mengontrol perubahan nilai lewat setter dengan validasi.
- Mencegah akses langsung terhadap variabel internal.
- Meningkatkan keamanan, keandalan, dan fleksibilitas program.



----

## Referensi