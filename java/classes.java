public class classes {

   
    static class Student {
        String name;
        Student(String name) { this.name = name; }
        void showName() { System.out.println("Student name: " + name); }
    }

   
    static class College {
        static String collegeName = "ABC College";
    }

   
    static class Counter {
        int id;
        Counter(int id) { this.id = id; }
        int getId() { return id; }
    }

    public static void main(String[] args) {

        Student s1 = new Student("Alice");
        s1.showName(); 

        System.out.println("College (via class): " + College.collegeName);
        College cObj = new College();
        System.out.println("College (via object): " + cObj.collegeName);

       
        new Student("Bob").showName();

      
        Student s2 = s1; 
        System.out.println("s2 name: " + s2.name);
        s2.name = "Alice Updated";
        s1.showName(); 

       
        Counter counter = new Counter(101);
        System.out.println("Counter id: " + counter.getId());
    }
}
