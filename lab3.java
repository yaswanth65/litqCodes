
import java.util.*;
public class Main {
    public static boolean hasZeroSumSubarray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int cumulativeSum = 0;
        for (int num : arr) {
            cumulativeSum += num;
            if (cumulativeSum == 0 || set.contains(cumulativeSum)) {
                return true;
            }
            set.add(cumulativeSum);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] inputs = inputLine.split(" ");
        int n = inputs.length;
        if (n < 1 || n > 10) {
            System.out.println("Array size must be between 1 and 10");
            return;
        }
        int[] arr = new int[n];
        try {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
                if (arr[i] < -10 || arr[i] > 10) {
                    System.out.println("Array elements must be from -10 to 10");
                    System.out.println(n);
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Array elements must be integers");
            System.out.println(n); 
            return;
        }
        boolean result = hasZeroSumSubarray(arr);
        System.out.println(result ? "True" : "False");
        System.out.println(n);
    }
}