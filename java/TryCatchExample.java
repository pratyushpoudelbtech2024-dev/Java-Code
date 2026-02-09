public class TryCatchExample {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 0;

        try {
            // Trying to divide by zero, which will throw an ArithmeticException
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // This block catches the ArithmeticException if division by zero occurs
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception Message: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }
}
