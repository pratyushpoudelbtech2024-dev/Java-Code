public class instance {
    String name;
    int age;

    
    public instance(String name, int age) {
        this.name = name;
        this.age = age;
    }

  
    public void displayDetails() {
        System.out.println("\n--- Person Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

   
    public int getYearOfBirth(int currentYear) {
        return currentYear - age;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter age (integer): ");
            }
        }

        instance p = new instance(name, age);
        p.displayDetails();

        System.out.print("Enter current year (or press Enter for 2026): ");
        String line = sc.nextLine();
        int year = 2026;
        if (!line.trim().isEmpty()) {
            try { year = Integer.parseInt(line.trim()); } catch (NumberFormatException e) { /* keep default */ }
        }

        System.out.println("Year of birth: " + p.getYearOfBirth(year));
        sc.close();
    }
}
