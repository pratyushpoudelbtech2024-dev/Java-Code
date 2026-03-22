abstract class Payment {
    private String transactionId;
    private double amount;

    
    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

   
    public abstract double processPayment();
}



class CreditCardPayment extends Payment {

    public CreditCardPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }

    @Override
    public double processPayment() {
        double fee = getAmount() * 0.02; // 2% fee
        return getAmount() + fee;
    }
}



class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String transactionId, double amount, String upiId) {
        super(transactionId, amount);
        this.upiId = upiId;
    }


    private boolean validateUPI() {
        return upiId != null && upiId.contains("@");
    }

    @Override
    public double processPayment() {
        if (!validateUPI()) {
            System.out.println("Invalid UPI ID!");
            return 0;
        }
        return getAmount(); 
    }
}



class PaymentProcessor {

    public static double processAllPayments(Payment[] payments) {
        double total = 0;

        for (Payment p : payments) {  
            double result = p.processPayment();
            total += result;
        }

        return total;
    }
}



public class SmartPaymentGateway {
    public static void main(String[] args) {

       
        Payment cc = new CreditCardPayment("TXN123", 1000);
        System.out.println("Credit Card Payment: " + cc.processPayment());

      
        Payment upi = new UPIPayment("TXN124", 1000, "user@upi");
        System.out.println("UPI Payment: " + upi.processPayment());

        Payment[] payments = {
            new CreditCardPayment("TXN125", 1000),
            new UPIPayment("TXN126", 1000, "abc@upi")
        };

        double total = PaymentProcessor.processAllPayments(payments);
        System.out.println("Total Processed Amount: " + total);
    }
}