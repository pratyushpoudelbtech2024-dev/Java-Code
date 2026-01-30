public class parameter {
    String name;
    int rollNo;
    String prn;

    // Parameterized constructor
    public parameter(String name, int rollNo, String prn) {
        this.name = name;
        this.rollNo = rollNo;
        this.prn = prn;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("PRN: " + prn);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter name: ");
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

        parameter student = new parameter(name, rollNo, prn);

        System.out.println("\n--- Student Details ---");
        student.display();

        sc.close();
    }
}
