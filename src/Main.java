import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static AccountList accs = new AccountList();
    static TransactionStack hist = new TransactionStack();
    static BillQueue bills = new BillQueue();
    static RequestQueue reqs = new RequestQueue();
    static BankArray arr = new BankArray();

    public static void main(String[] args) {
        startData();
        arr.fill();
        arr.show();

        while (true) {
            System.out.println("\n1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                bankMenu();
            } else if (n == 2) {
                atmMenu();
            } else if (n == 3) {
                adminMenu();
            } else if (n == 4) {
                System.out.println("Goodbye");
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }

    static void startData() {
        accs.list.add(new BankAccount(1001, "Ali", 150000));
        accs.list.add(new BankAccount(1002, "Sara", 220000));
        accs.list.add(new BankAccount(1003, "John", 120000));
    }

    static void bankMenu() {
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1 - Add new account");
            System.out.println("2 - Show all accounts");
            System.out.println("3 - Search account by username");
            System.out.println("4 - Deposit money");
            System.out.println("5 - Withdraw money");
            System.out.println("6 - Add bill payment");
            System.out.println("7 - Show last transaction");
            System.out.println("8 - Undo last transaction");
            System.out.println("9 - Submit account request");
            System.out.println("10 - Back");
            System.out.print("Choose: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                addAcc();
            } else if (n == 2) {
                accs.showAll();
            } else if (n == 3) {
                searchAcc();
            } else if (n == 4) {
                dep();
            } else if (n == 5) {
                with();
            } else if (n == 6) {
                addBill();
            } else if (n == 7) {
                hist.showLast();
            } else if (n == 8) {
                hist.undo();
            } else if (n == 9) {
                addReq();
            } else if (n == 10) {
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }

    static void atmMenu() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Choose: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                balanceEnquiry();
            } else if (n == 2) {
                with();
            } else if (n == 3) {
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1 - View account requests");
            System.out.println("2 - Process account request");
            System.out.println("3 - View bill queue");
            System.out.println("4 - Process next bill");
            System.out.println("5 - Back");
            System.out.print("Choose: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                reqs.showReqs();
            } else if (n == 2) {
                reqs.processReq(accs);
            } else if (n == 3) {
                bills.showBills();
            } else if (n == 4) {
                bills.processBill();
            } else if (n == 5) {
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }

    static void addAcc() {
        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();
        sc.nextLine();

        accs.add(new BankAccount(num, name, bal));
    }

    static void searchAcc() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        accs.showOne(name);
    }

    static void dep() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Deposit amount: ");
        double money = sc.nextDouble();
        sc.nextLine();

        BankAccount a = accs.find(name);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        accs.deposit(name, money);
        hist.add("Deposit " + money + " to " + name);
    }

    static void with() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Withdraw amount: ");
        double money = sc.nextDouble();
        sc.nextLine();

        BankAccount a = accs.find(name);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        if (money > a.balance) {
            System.out.println("Not enough money");
            return;
        }

        accs.withdraw(name, money);
        hist.add("Withdraw " + money + " from " + name);
    }

    static void addBill() {
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();
        bills.addBill(bill);
        hist.add("Bill payment: " + bill);
    }

    static void addReq() {
        System.out.print("Enter new account number: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter start balance: ");
        double bal = sc.nextDouble();
        sc.nextLine();

        reqs.addReq(new BankAccount(num, name, bal));
    }

    static void balanceEnquiry() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        accs.showBalance(name);
    }
}