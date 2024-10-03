import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetSweetness = scanner.nextInt();
        List<Integer> candies = new ArrayList<>();
        while (scanner.hasNextInt()) {
            candies.add(scanner.nextInt());
        }
        int result = combineCandies(targetSweetness, candies);
        System.out.println(result);
        scanner.close();
    }
    private static int combineCandies(int targetSweetness, List<Integer> candies) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(candies);
        int steps = 0;
        while (minHeap.size() > 1 && minHeap.peek() < targetSweetness) {
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();
            int newCandy = leastSweet + 2 * secondLeastSweet;
            minHeap.offer(newCandy);
            steps++;
        }
        if (minHeap.peek() >= targetSweetness) {
            return steps;
        } else {
            return -1;
        }
    }
}
