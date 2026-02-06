/*public class day06 {

    final int MAX = 100; 

    void display() {
        System.out.println("MAX value: " + MAX);
    }

    public static void main(String[] args) {
        day06 obj = new day06();
        obj.display();
    }
}*/

class Parent {
    final void display() {
        System.out.println("Final method in parent class");
    }
}

class Child extends Parent {
    
}

class FinalMethodExample {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}


