import java.util.*;


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance in account " + accountNumber);
        }

        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    
    public void transfer(Account targetAccount, double amount) throws InsufficientFundsException {
        if (targetAccount == null) {
            System.out.println("Invalid target account.");
            return;
        }

        this.withdraw(amount); 
        targetAccount.deposit(amount);

        System.out.println("₹" + amount + " transferred from " + accountNumber +
                           " to " + targetAccount.accountNumber);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("------------------------------");
    }


    public String getAccountNumber() {
        return accountNumber;
    }
}


class Bank {
    private List<Account> accounts = new ArrayList<>();

    
    public void createAccount(String accountNumber, String name, double initialBalance) {
        accounts.add(new Account(accountNumber, name, initialBalance));
        System.out.println("Account created successfully for " + name);
    }

    
    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in bank.");
            return;
        }

        System.out.println("\nAll Bank Accounts:");
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}


public class fourth {
    public static void main(String[] args) {

        Bank bank = new Bank();

        
        bank.createAccount("A101", "Alice", 5000);
        bank.createAccount("A102", "Bob", 3000);

        
        Account acc1 = bank.getAccount("A101");
        Account acc2 = bank.getAccount("A102");

        try {
           
            acc1.deposit(2000);

            
            acc2.withdraw(1000);

            
            acc1.transfer(acc2, 2500);

            
            acc2.withdraw(10000);

        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        
        bank.displayAllAccounts();
    }
}
