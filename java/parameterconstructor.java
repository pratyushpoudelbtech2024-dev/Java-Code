public class parameterconstructor {

    double a, b;

    
    public parameterconstructor(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double add() {
        return a + b;
    }

    public double subtract() {
        return a - b;
    }

    public double multiply() {
        return a * b;
    }

    public double divide() {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter first number: ");
        double x;
        while (true) {
            try {
                x = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }

        System.out.print("Enter second number: ");
        double y;
        while (true) {
            try {
                y = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }

        parameterconstructor pc = new parameterconstructor(x, y);

        System.out.println("Choose an operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter choice (1-4): ");

        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) break;
                System.out.print("Choice must be 1-4. Enter choice: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. Enter 1-4: ");
            }
        }

        try {
            switch (choice) {
                case 1:
                    System.out.println("Result (Add): " + pc.add());
                    break;
                case 2:
                    System.out.println("Result (Subtract): " + pc.subtract());
                    break;
                case 3:
                    System.out.println("Result (Multiply): " + pc.multiply());
                    break;
                case 4:
                    System.out.println("Result (Divide): " + pc.divide());
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
