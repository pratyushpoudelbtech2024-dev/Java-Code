public class stringreversal {
    public static String reverseWithBuiltIn(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseWithoutBuiltIn(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String test = "Hello World";
        System.out.println("Original: " + test);
        System.out.println("With built-in: " + reverseWithBuiltIn(test));
        System.out.println("Without built-in: " + reverseWithoutBuiltIn(test));
    }
}
