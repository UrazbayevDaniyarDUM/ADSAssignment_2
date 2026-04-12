import java.util.LinkedList;
import java.util.Queue;

public class BillQueue {
    Queue<String> q = new LinkedList<>();

    public void addBill(String bill) {
        q.add(bill);
        System.out.println("Added: " + bill);
    }

    public void processBill() {
        if (q.isEmpty()) {
            System.out.println("No bills to process");
        } else {
            System.out.println("Processing: " + q.poll());
        }
    }

    public void showBills() {
        if (q.isEmpty()) {
            System.out.println("Bill queue is empty");
            return;
        }

        System.out.println("Bill Queue:");
        for (String s : q) {
            System.out.println(s);
        }
    }
}