public class BankArray {
    BankAccount[] arr = new BankAccount[3];

    public void fill() {
        arr[0] = new BankAccount(2001, "Aruzhan", 100000);
        arr[1] = new BankAccount(2002, "Nurs", 200000);
        arr[2] = new BankAccount(2003, "Dana", 300000);
    }

    public void show() {
        System.out.println("Task 6 - Array");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i].username + " - Balance: " + arr[i].balance);
        }
    }
}
