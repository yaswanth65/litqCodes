// Sum of Variations in the given object Count

import java.util.Scanner;
public class Main {
    public static int countCombinations(int m, int r, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[target + 1];
            for (int variation = 1; variation <= r; variation++) {
                for (int j = target; j >= variation; j--) {
                    temp[j] += dp[j - variation];
                }
            }
            for (int k = 0; k <= target; k++) {
                dp[k] = temp[k];
            }
        }
        return dp[target]; 
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int r = input.nextInt();
        int target = input.nextInt();
        int result = countCombinations(m, r, target);
        System.out.println(result);
        input.close();
    }
}
