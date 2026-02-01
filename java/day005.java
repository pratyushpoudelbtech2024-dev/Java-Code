class Student005 {
    String name;

    Student005(String name) {
        this.name = name;
    }
    void display() {
        System.out.println("Name is " + this.name);
    }
}
public class day005 {

    public static void main(String[] args) {
        Student005 student = new Student005("Pratyush");
        student.display();
    }
}

