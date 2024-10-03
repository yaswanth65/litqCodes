//Largest Palindrome

import java.util.Scanner;
public class Main {
    public static String largestPalindrome(String num, int maxChanges) {
        char[] arr = num.toCharArray();
        int n = arr.length;
        boolean[] changed = new boolean[n];  
        int mismatches = 0;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                char maxChar = (char) Math.max(arr[i], arr[n - i - 1]);
                arr[i] = maxChar;
                arr[n - i - 1] = maxChar;
                changed[i] = true;  
                mismatches++;
            }
        }
        int remainingChanges = maxChanges - mismatches;
        if (remainingChanges < 0) {
            return "-1";  
        }
        for (int i = 0; i < n / 2 && remainingChanges > 0; i++) {
            if (arr[i] == '9') continue;
            if (changed[i]) { 
                if (remainingChanges >= 1) {
                    arr[i] = '9';
                    arr[n - i - 1] = '9';
                    remainingChanges--;
                }
            } else {
                if (remainingChanges >= 2) {
                    arr[i] = '9';
                    arr[n - i - 1] = '9';
                    remainingChanges -= 2;
                }
            }
        }
        if (n % 2 == 1 && remainingChanges > 0) {
            arr[n / 2] = '9';
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxChanges = scanner.nextInt();
        String num = scanner.next();
        String result = largestPalindrome(num, maxChanges);
        System.out.println(result);
        scanner.close();
    }
}
