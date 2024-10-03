import java.util.Scanner;
public class Main {
    static final int MOD = 1000000007;
    static long[] waysToFillRow(int m) {
        long[] dp = new long[m + 1];
        dp[0] = 1; 
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1]; 
            if (i - 2 >= 0) dp[i] = (dp[i] + dp[i - 2]) % MOD;
            if (i - 3 >= 0) dp[i] = (dp[i] + dp[i - 3]) % MOD; 
            if (i - 4 >= 0) dp[i] = (dp[i] + dp[i - 4]) % MOD; 
        }
        return dp;
    }
    static long modPow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    static long legoWall(int n, int m) {
        long[] rowWays = waysToFillRow(m);
        long[] solidWalls = new long[m + 1];
        solidWalls[0] = 1;
        for (int i = 1; i <= m; i++) {
            solidWalls[i] = modPow(rowWays[i], n, MOD);
        }
        long[] validWalls = new long[m + 1];
        validWalls[0] = 1;
        for (int width = 1; width <= m; width++) {
            validWalls[width] = solidWalls[width];
            for (int k = 1; k < width; k++) {
                validWalls[width] = (validWalls[width] - validWalls[k] * solidWalls[width - k] % MOD + MOD) % MOD;
            }
        }
        return validWalls[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long result = legoWall(n, m);
        System.out.println(result);
    }
}
