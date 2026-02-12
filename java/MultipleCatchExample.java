public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            String str = null;
            // Trying to call a method on a null object, which will throw a NullPointerException
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // This block catches the NullPointerException
            System.out.println("Error: Null pointer exception! Object is null.");
        } catch (Exception e) {
            // This block catches any other exceptions
            System.out.println("Some other error occurred.");
        }

        System.out.println("Program continues after exception handling.");
    }
}
