import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private ArrayList<Transaction> history = new ArrayList<>();

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber= accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
    public String getAccountId() 
    { 
    	return accountNumber; 
    }
    public double getBalance() { 
    	return balance; 
    	}
    
    public ArrayList<Transaction> getHistory() { 
    	return history;
    	}

    public boolean checkPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            history.add(new Transaction("Deposit", amount));
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            history.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }
    public void receiveTransfer(double amount) {
        balance = balance + amount;
        history.add(new Transaction("Transfer In", amount));
    }
    public boolean sendTransfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            history.add(new Transaction("Transfer Out", amount));
            return true;
        }
        return false;
    }
}
