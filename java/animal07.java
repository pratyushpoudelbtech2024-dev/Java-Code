class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class animal07 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();
        
        Animal dog = new Dog();
        dog.sound();
        
        Animal cat = new Cat();
        cat.sound();
    }
}
