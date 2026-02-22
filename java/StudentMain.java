// Custom Exception Class
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student Class
class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Method to assign grade
    public void assignGrade() throws InvalidMarksException {

        // Check valid marks range
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        }

        String grade;

        if (marks >= 90)
            grade = "A";
        else if (marks >= 75)
            grade = "B";
        else if (marks >= 60)
            grade = "C";
        else if (marks >= 40)
            grade = "D";
        else
            grade = "F";

        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}

// Main Class
public class StudentMain {
    public static void main(String[] args) {

        Student s1 = new Student("Pratyush", 85);
        Student s2 = new Student("Rahul", 120);  // Invalid marks

        try {
            s1.assignGrade();
            System.out.println();
            s2.assignGrade();  // This will throw exception
        } 
        catch (InvalidMarksException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}