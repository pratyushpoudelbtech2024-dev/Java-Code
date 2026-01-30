public class command {

   
    public void performOperations(double a, double b) {
        System.out.println("Given numbers: " + a + " and " + b);
        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        if (b == 0) {
            System.out.println("Division: Error (division by zero)");
        } else {
            System.out.println("Division: " + (a / b));
        }
    }

    public static void main(String[] args) {
        command cmd = new command();

        double a, b;

        
        if (args.length >= 2) {
            try {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[1]);
                System.out.println("Using command-line arguments.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid command-line arguments. Falling back to predefined values.");
                a = 10;
                b = 5;
            }
        } else {
            System.out.println("No command-line arguments provided. Using predefined values.");
            a = 10;
            b = 5;
        }

       
        cmd.performOperations(a, b);
    }
}
