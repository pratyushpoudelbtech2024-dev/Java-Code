class Parent {
    String name = "Parent";
    
    void display() {
        System.out.println("Parent class");
    }
}

public class childclass extends Parent {
    public static void main(String[] args) {
        childclass obj = new childclass();
        obj.display();
        System.out.println(obj.name);
    }
}
