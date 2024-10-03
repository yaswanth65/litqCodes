// Sub Array Product

import java.util.Scanner;
public class Main {
    public static int countSubarrays(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputArray = sc.nextLine().split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }
        int k = sc.nextInt();
        int result = countSubarrays(nums, k);
        System.out.println(result);
        sc.close();
    }
}
