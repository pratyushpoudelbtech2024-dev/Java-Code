class Parent {
    int a = 10;

    Parent() {
        System.out.println("Parent class constructor");
    }

    void show() {
        System.out.println("Value of a in Parent class: " + a);
    }
}

class Child extends Parent {
    int a = 20;

    Child() {
        super();
        System.out.println("Child class constructor");
    }

    void display() {
        System.out.println("Value of a using this keyword: " + this.a);
        System.out.println("Value of a using super keyword: " + super.a);

        this.show();   
        super.show();  
    }
}

public class usingSuperClass {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
    }
}
