
/*final class Calculator {

    
    final int BASE_VALUE = 10;

    
    final void showBaseValue() {
        System.out.println("Base Value: " + BASE_VALUE);
    }

    
    int add(int x) {
        return BASE_VALUE + x;
    }
}

public class FinalDemo {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        calc.showBaseValue();

        int result = calc.add(5);
        System.out.println("Result after addition: " + result);

         
    }
}*/





/*abstract class Calculator {

    
    abstract int add(int a, int b);
    abstract int subtract(int a, int b);
    abstract int multiply(int a, int b);
    abstract double divide(int a, int b);
   
    void displayMessage() {
        System.out.println("Abstract Calculator Application");
    }
}


class BasicCalculator extends Calculator {

    @Override
    int add(int a, int b) {
        return a + b;
    }

    @Override
    int subtract(int a, int b) {
        return a - b;
    }

    @Override
    int multiply(int a, int b) {
        return a * b;
    }

    @Override
    double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed");
            return 0;
        }
        return (double) a / b;
    }
}


public class AbstractCalculatorDemo {
    public static void main(String[] args) {

      
        Calculator calc = new BasicCalculator();

        calc.displayMessage();

        System.out.println("Addition: " + calc.add(20, 10));
        System.out.println("Subtraction: " + calc.subtract(20, 10));
        System.out.println("Multiplication: " + calc.multiply(20, 10));
        System.out.println("Division: " + calc.divide(20, 10));
    }
}*/




interface A {
    default void show() {
        System.out.println("Show method from Interface A");
    }
}


interface B {
    default void show() {
        System.out.println("Show method from Interface B");
    }
}


class C implements A, B {

    
    @Override
    public void show() {
        
        A.super.show();
        B.super.show();
        System.out.println("Diamond problem resolved in Class C");
    }
}

public class DiamondProblemDemo {
    public static void main(String[] args) {

        C obj = new C();
        obj.show();
    }
}


