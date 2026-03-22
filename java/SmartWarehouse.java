import java.util.*;

interface Taxable {
    double calculateTax();
}

abstract class Item implements Taxable {
    protected String itemID;
    protected String name;
    protected double basePrice;

    public Item(String itemID, String name, double basePrice) {
        this.itemID = itemID;
        this.name = name;
        this.basePrice = basePrice;    
    }

    public String getItemID() {
        return itemID;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPriceWithTax() {
        return basePrice + calculateTax();
    }
 
    public abstract void display();
}

class PerishableItem extends Item {
    private String expiryDate;

    public PerishableItem(String itemID, String name, double basePrice, String expiryDate) {
        super(itemID, name, basePrice);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateTax() {
        return basePrice * 0.05; 
    }

    @Override
    public void display() {
        System.out.println("Perishable Item | ID: " + itemID +
                " | Name: " + name +
                " | Price: $" + basePrice +
                " | Expiry: " + expiryDate +
                " | Price with Tax: $" + String.format("%.2f", getPriceWithTax()));
    }
}

class ElectronicItem extends Item {
    private int warrantyPeriod; 

    public ElectronicItem(String itemID, String name, double basePrice, int warrantyPeriod) {
        super(itemID, name, basePrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateTax() {
        return basePrice * 0.15; 
    }

    @Override
    public void display() {
        System.out.println("Electronic Item | ID: " + itemID +
                " | Name: " + name +
                " | Price: $" + basePrice +
                " | Warranty: " + warrantyPeriod + " months" +
                " | Price with Tax: $" + String.format("%.2f", getPriceWithTax()));
    }
}

public class SmartWarehouse {

    private static HashMap<String, Item> inventory = new HashMap<>();

    public static void addItem(Item item) {
        inventory.put(item.getItemID(), item);
        System.out.println("Item added successfully.");
    }

    public static void displayAllItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        ArrayList<Item> list = new ArrayList<>(inventory.values());
        list.sort(Comparator.comparingDouble(Item::getBasePrice));

        System.out.println("\n--- Inventory Items (Sorted by Price) ---");
        for (Item item : list) {
            item.display();
        }
    }

   
    public static void searchItem(String id) {
        Item item = inventory.get(id);
        if (item != null) {
            System.out.println("\nItem Found:");
            item.display();
        } else {
            System.out.println("Item not found.");
        }
    }

    
    public static void calculateTotalValue() {
        double total = 0;
        for (Item item : inventory.values()) {
            total += item.getPriceWithTax();
        }
        System.out.println("\nTotal Inventory Value (Incl. Tax): $" +
                String.format("%.2f", total));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Perishable Item");
            System.out.println("2. Add Electronic Item");
            System.out.println("3. Display All Items");
            System.out.println("4. Search Item");
            System.out.println("5. Calculate Total Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double pprice = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = sc.nextLine();

                    addItem(new PerishableItem(pid, pname, pprice, expiry));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    String eid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double eprice = sc.nextDouble();

                    System.out.print("Enter Warranty (months): ");
                    int warranty = sc.nextInt();

                    addItem(new ElectronicItem(eid, ename, eprice, warranty));
                    break;

                case 3:
                    displayAllItems();
                    break;

                case 4:
                    System.out.print("Enter Item ID to search: ");
                    String sid = sc.nextLine();
                    searchItem(sid);
                    break;

                case 5:
                    calculateTotalValue();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
