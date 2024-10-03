import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int q = sc.nextInt();
        int[] arr = new int[n + 2]; 
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();  
            int r = sc.nextInt();  
            int x = sc.nextInt(); 
            arr[l] += x;      
            arr[r + 1] -= x; 
        }
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 1; i <= n; i++) {
            current += arr[i]; 
            if (current > max) {
                max = current;  
            }
        }
        System.out.println(max);
    }
}
