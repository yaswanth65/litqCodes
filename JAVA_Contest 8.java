// Maximum Alternating subsequence sum

import java.util.Scanner;
public class Main {
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long evenSum = nums[0];  
        long oddSum = 0;  
        for (int i = 1; i < n; i++) {
            long newEvenSum = Math.max(evenSum, oddSum + nums[i]);
            long newOddSum = Math.max(oddSum, evenSum - nums[i]);
            evenSum = newEvenSum;
            oddSum = newOddSum;
        }
        return evenSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }
        long result = maxAlternatingSum(nums);
        System.out.println(result);
        scanner.close();
    }
}
