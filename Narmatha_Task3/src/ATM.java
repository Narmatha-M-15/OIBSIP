import java.util.ArrayList;
import java.util.Scanner;

	public class ATM {
    private Bank bank;
	private Scanner sc = new Scanner(System.in);

	    public ATM(Bank bank) {
	        this.bank = bank;
	    }

	    public void start() {
	        System.out.println("===== Welcome to ATM =====");
	        Account account = login();
	        if (account == null) {
	            System.out.println("Too many wrong attempts. Access denied.");
	            return;
	        }
	        menu(account);
	    }
	    private Account login() {
	        int attempts = 0;
	        while (attempts < 3) {
	            System.out.print("Enter Account Number: ");
	            String accNo = sc.nextLine().trim();
	            System.out.print("Enter PIN: ");
	            String pin = sc.nextLine().trim();

	            Account account = bank.findAccount(accNo);
	            if (account != null && account.checkPin(pin)) {
	                System.out.println("Login successful!");
	                return account;
	            }
	            attempts++;
	            System.out.println("Invalid Account Number or PIN. Attempts left: " + (3 - attempts));
	        }
	        return null;
	    }

	    // Reads an amount safely, returns -1 if input is not a valid number
	    private double readAmount(String message) {
	        System.out.print(message);
	        try {
	            return Double.parseDouble(sc.nextLine().trim());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid amount. Please enter a number.");
	            return -1;
	        }
	    }

	    private void menu(Account account) {
	        int choice = 0;
	        do {
	            System.out.println("\n1. Transaction History");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Quit");
	            System.out.print("Choose option: ");

	            try {
	                choice = Integer.parseInt(sc.nextLine().trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Enter a number from 1 to 5.");
	                choice = 0;
	                continue;
	            }

	            switch (choice) {
	                case 1:
	                    ArrayList<Transaction> list = account.getHistory();
	                    if (list.isEmpty()) {
	                        System.out.println("No transactions yet.");
	                    } else {
	                        System.out.println("--- Transaction History ---");
	                        for (Transaction t : list) {
	                            System.out.println(t);
	                        }
	                    }
	                    System.out.println("Current balance: Rs." + account.getBalance());
	                    break;

	                case 2:
	                    double w = readAmount("Enter amount to withdraw: ");
	                    if (w <= 0) {
	                        System.out.println("Amount must be greater than 0.");
	                    } else if (account.withdraw(w)) {
	                        System.out.println("Withdrawn Rs." + w + ". Balance: Rs." + account.getBalance());
	                    } else {
	                        System.out.println("Insufficient Funds");
	                    }
	                    break;

	                case 3:
	                    double d = readAmount("Enter amount to deposit: ");
	                    if (d <= 0) {
	                        System.out.println("Amount must be greater than 0.");
	                    } else {
	                        account.deposit(d);
	                        System.out.println("Deposited Rs." + d + ". Balance: Rs." + account.getBalance());
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter recipient Account Number: ");
	                    String toAccNo = sc.nextLine().trim();
	                    double amt = readAmount("Enter amount to transfer: ");
	                    if (amt <= 0) {
	                        System.out.println("Amount must be greater than 0.");
	                    } else if (account.getBalance() < amt) {
	                        System.out.println("Insufficient Funds");
	                    } else if (bank.transfer(account, toAccNo, amt)) {
	                        System.out.println("Transferred Rs." + amt + " to " + toAccNo
	                                + ". Balance: Rs." + account.getBalance());
	                    } else {
	                        System.out.println("Transfer failed. Check the recipient Account Number.");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    break;

	                default:
	                    System.out.println("Invalid option. Choose 1 to 5.");
	            }
	        } while (choice != 5);
	    }
	}

