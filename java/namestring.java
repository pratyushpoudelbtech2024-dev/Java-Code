public class namestring {
    public static void main(String[] args) {
        // Name as a string
        String name = "PRATYUSH";
        
    
        System.out.println("My name is: " + name);
        
        // Reverse the name using string concatenation
        String reversed = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reversed += name.charAt(i);
        }
        System.out.println("My name reversed is: " + reversed);
    }

}
