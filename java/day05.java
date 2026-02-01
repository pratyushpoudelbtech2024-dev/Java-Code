 class Animal {
    void eat() {
        System.out.println("This animal eats food.");

    }
}
class Dog extends Animal{
    void bark() {
        System.out.println(" dog barks.");
    }
}


 public class day05 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
 
 }
