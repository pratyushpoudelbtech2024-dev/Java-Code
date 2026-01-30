public class staticvariable {
    static String vcollege;

    String name;
    int rollNo;
    String prn;

    public staticvariable(String name, int rollNo, String prn) {
        this.name = name;
        this.rollNo = rollNo;
        this.prn = prn;
    }

    public void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("College: " + vcollege);
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("PRN: " + prn);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter college name: ");
        vcollege = sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo;
        while (true) {
            try {
                rollNo = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter roll number (integer): ");
            }
        }

        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();

        staticvariable student = new staticvariable(name, rollNo, prn);
        student.display();

        sc.close();
    }
}
