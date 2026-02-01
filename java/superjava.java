class Animal {
    String name = "Animal";

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    String name = "Dog";

    void display() {
        System.out.println("Parent name: " + super.name);
        super.sound();
        System.out.println("Child name: " + name);
    }
}

public class superjava {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.display();
    }
}
