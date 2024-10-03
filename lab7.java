lab 7 :

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); 
        sc.nextLine();
        String[] arrInput = sc.nextLine().split(" ");
        int n = arrInput.length; 
        int[] ar = new int[n]; 
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(arrInput[i]);
        }
        int result = countDivisibleSumPairs(ar, k);
        System.out.println(result); 
    }
    public static int countDivisibleSumPairs(int[] ar, int k) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    count++; 
                }
            }
        }
        return count; 
    }
}