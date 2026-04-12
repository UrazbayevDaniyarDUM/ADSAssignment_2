public class BankAccount {
    int accountNumber;
    String username;
    double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public void show() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + username);
        System.out.println("Balance: " + balance);
    }
}