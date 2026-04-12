import java.util.Stack;

public class TransactionStack {
    Stack<String> stack = new Stack<>();

    public void add(String text) {
        stack.push(text);
    }

    public void showLast() {
        if (stack.isEmpty()) {
            System.out.println("No transactions");
        } else {
            System.out.println("Last transaction: " + stack.peek());
        }
    }

    public void undo() {
        if (stack.isEmpty()) {
            System.out.println("No transactions");
        } else {
            System.out.println("Undo -> " + stack.pop() + " removed");
        }
    }

    public void showAll() {
        if (stack.isEmpty()) {
            System.out.println("No transactions");
            return;
        }

        for (String s : stack) {
            System.out.println(s);
        }
    }
}