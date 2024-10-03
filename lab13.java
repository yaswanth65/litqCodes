import java.util.Scanner;
import java.util.Stack;
class QueueUsingTwoStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void enqueue(int x) {
        stack1.push(x);
    }
    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }
    public void printFront() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        String input = scanner.nextLine(); 
        String[] queries = input.split(","); 
        for (String query : queries) {
            String[] parts = query.trim().split(" ");
            if (parts[0].equals("1")) {
                int x = Integer.parseInt(parts[1]);
                queue.enqueue(x);
            } else if (parts[0].equals("2")) {
                queue.dequeue();
            } else if (parts[0].equals("3")) {
                queue.printFront();
            }
        }
        scanner.close();
    }
}
