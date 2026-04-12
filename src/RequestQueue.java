import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    Queue<BankAccount> q = new LinkedList<>();

    public void addReq(BankAccount acc) {
        q.add(acc);
        System.out.println("Request added");
    }

    public void processReq(AccountList accs) {
        if (q.isEmpty()) {
            System.out.println("No requests");
            return;
        }

        BankAccount a = q.poll();
        accs.list.add(a);
        System.out.println("Request processed. Account added: " + a.username);
    }

    public void showReqs() {
        if (q.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }

        System.out.println("Pending requests:");
        for (BankAccount a : q) {
            System.out.println(a.accountNumber + " - " + a.username + " - " + a.balance);
        }
    }
}