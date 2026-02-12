import java.util.*;


class Product {
    private String name;
    private double price;

    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    
    public void displayProduct() {
        System.out.printf("Product: %-15s Price: ₹%.2f\n", name, price);
    }
}


class ShoppingCart {
    private List<Product> products = new ArrayList<>();

   
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    
    public void removeProduct(String productName) {
        Iterator<Product> iterator = products.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equalsIgnoreCase(productName)) {
                iterator.remove();
                System.out.println(productName + " removed from cart.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println(productName + " not found in cart.");
        }
    }

   
    public double calculateTotalCost() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }

        System.out.println("\nItems in Shopping Cart:");
        for (Product p : products) {
            p.displayProduct();
        }

        System.out.printf("Total Cost: ₹%.2f\n", calculateTotalCost());
    }
}


public class third {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        
        cart.addProduct(new Product("Laptop", 55000));
        cart.addProduct(new Product("Mouse", 700));
        cart.addProduct(new Product("Keyboard", 1500));

    
        cart.displayCart();

        
        System.out.println("\nRemoving 'Mouse'...");
        cart.removeProduct("Mouse");

        cart.displayCart();
    }
}
