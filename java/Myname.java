public class Myname {
    public static void main(String[] args) {
      
        char[] name = {'P', 'R', 'A', 'T', 'Y', 'U', 'S', 'H'};
        
    
        System.out.print("My name is: ");
        for (int i = name.length - 1; i >= 0; i--) {
            System.out.print(name[i]);
        }
        System.out.println();
    }
}