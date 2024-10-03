//Compute the Diagonal Difference

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int ltrSum = 0; 
        int rtlSum = 0; 
        for (int i = 0; i < n; i++) {
            ltrSum += matrix[i][i]; 
            rtlSum += matrix[i][n - i - 1]; 
        }
        int difference = Math.abs(ltrSum - rtlSum);
        System.out.println(difference);
        sc.close();
    }
}
