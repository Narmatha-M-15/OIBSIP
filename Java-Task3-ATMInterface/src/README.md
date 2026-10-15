# ATM Interface

**Oasis Infobyte SIP | Java Development | Task 3**

A console-based ATM simulation built in Java using object-oriented design. Users log in with an Account Number and PIN, then perform standard banking transactions such as withdraw, deposit and transfer.

## Features

- Login with Account Number and PIN; access is denied after 3 incorrect attempts
- Main menu after successful login:
  1. **Transaction History**: shows all transactions made in the current session along with the current balance
  2. **Withdraw**: validates the amount and available balance, updates the balance and logs the transaction
  3. **Deposit**: updates the balance and logs the transaction
  4. **Transfer**: sends money to another account, validates the balance, updates both accounts and logs the transaction
  5. **Quit**: shows a goodbye message and exits
- Insufficient balance check before any withdrawal or transfer
- Input validation for invalid menu choices, non-numeric input and zero or negative amounts
- All transactions are stored in an `ArrayList` and displayed with date and time

## Project Structure

| Class | Purpose |
|-------|---------|
| `Main` | Entry point; creates the Bank and starts the ATM |
| `ATM` | Handles login, menu and user interaction |
| `Account` | Stores account number, PIN, balance and transaction history (private fields with getters) |
| `Transaction` | Represents a single transaction (type, amount, date and time) |
| `Bank` | Stores accounts in a `HashMap`, finds accounts and handles transfers |

## Tech Stack

- Java
- Concepts used: Object-Oriented Programming (encapsulation, classes and objects), `ArrayList`, `HashMap`, `switch-case`, `try-catch` (`NumberFormatException`), `Scanner`, `LocalDateTime`

## Sample Accounts

| Account Number | PIN | Opening Balance |
|----------------|-----|-----------------|
| 63456789 | 1525 | Rs.5000 |
| 98765432 | 1501 | Rs.3000 |
| 69000234 | 5613 | Rs.200 |

## How to Run

1. Clone the repository:
   ```
   git clone https://github.com/Narmatha-M-15/OIBSIP.git
   ```
2. Go to the source folder:
   ```
   cd OIBSIP/Java-Task3-ATMInterface/src
   ```
3. Compile and run:
   ```
   javac *.java
   java Main
   ```

Or open the project in Eclipse / IntelliJ and run `Main.java`.

## Sample Output

```
===== Welcome to ATM =====
Enter Account Number: 63456789
Enter PIN: 1525
Login successful!

1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose option: 3
Enter amount to deposit: 500
Deposited Rs.500.0. Balance: Rs.5500.0
```

## Screenshots

![Login and menu](screenshots/atm1.png)

![Transactions](screenshots/atm2.png)

## Author

**Narmatha M**
Java Development Intern, Oasis Infobyte
GitHub: [Narmatha-M-15](https://github.com/Narmatha-M-15)
