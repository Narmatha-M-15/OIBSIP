import java.util.HashMap;
public class Bank {


	private HashMap<String, Account> accounts = new HashMap<>();
	public Bank() {
	
		    accounts.put("63456789", new Account("63456789", "1525", 5000));
		    accounts.put("98765432", new Account("98765432", "1501", 3000));
	        accounts.put("69000234", new Account("69000234", "5613", 200));
	    }
	    public Account findAccount(String accountNumber) {
	        return accounts.get(accountNumber);
	    }
	    public boolean transfer(Account from, String toAccNo, double amount) {
	        Account to = findAccount(toAccNo);
	        if (to == null || to == from) {
	            return false;
	        }
	        if (from.sendTransfer(amount)) {
	            to.receiveTransfer(amount);
	            return true;
	        }
	        return false;    
	    }
}