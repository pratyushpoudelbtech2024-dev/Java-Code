// Custom Exception 1
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}


class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientFundsException, InvalidAmountException {

        
        if (amount % 100 != 0) {
            throw new InvalidAmountException(
                    "Amount must be in multiples of 100.");
        }

        
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient balance. Available balance: " + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.println("Remaining Balance: " + balance);
    }
}


public class ATMSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC123", 1000);

        try {
            account.withdraw(500);   
            account.withdraw(150);   
            account.withdraw(700);   
        }
        catch (InvalidAmountException e) {
            System.out.println("Invalid Amount Exception: " + e.getMessage());
        }
        catch (InsufficientFundsException e) {
            System.out.println("Insufficient Funds Exception: " + e.getMessage());
        }
    }
}