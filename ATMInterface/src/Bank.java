import java.util.HashMap;

public class Bank {
	
	    private HashMap<String, Account> accounts = new HashMap<>();

	    public Bank() {
	        accounts.put("686767", new Account("686767", "4954", 5000));
	        accounts.put("683674", new Account("683674", "4438", 3000));
	        accounts.put("684683", new Account("684683", "8789", 100));
	    }

	    // TODO 5: accountId vachu Account return pannunga. Illa na null
	    //         Hint: accounts.get(id)
	    public Account findAccount(String accountnumber) {
	    	
	        return null;
	    }

	    // TODO 6: Sender account, recipient ID, amount vaangi:
	    //   1. Recipient irukka check pannunga (illa na false)
	    //   2. Sender-ku sendTransfer success aana, recipient.receiveTransfer call pannunga
	    //   3. Success na true return
	    public boolean transfer(Account from, String toId, double amount) {
	        return false;
	    }
	}


