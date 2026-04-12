import java.util.LinkedList;

public class AccountList {
    LinkedList<BankAccount> list = new LinkedList<>();

    public void add(BankAccount acc) {
        list.add(acc);
        System.out.println("Account added successfully");
    }

    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("No accounts");
            return;
        }

        System.out.println("Accounts List:");
        for (int i = 0; i < list.size(); i++) {
            BankAccount a = list.get(i);
            System.out.println((i + 1) + ". " + a.username + " - Balance: " + a.balance);
        }
    }

    public BankAccount find(String name) {
        for (BankAccount a : list) {
            if (a.username.equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public void deposit(String name, double money) {
        BankAccount a = find(name);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        a.balance += money;
        System.out.println("New balance: " + a.balance);
    }

    public void withdraw(String name, double money) {
        BankAccount a = find(name);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        if (money > a.balance) {
            System.out.println("Not enough money");
            return;
        }

        a.balance -= money;
        System.out.println("New balance: " + a.balance);
    }

    public void showOne(String name) {
        BankAccount a = find(name);
        if (a == null) {
            System.out.println("Account not found");
        } else {
            a.show();
        }
    }

    public void showBalance(String name) {
        BankAccount a = find(name);
        if (a == null) {
            System.out.println("Account not found");
        } else {
            System.out.println("Balance: " + a.balance);
        }
    }
}