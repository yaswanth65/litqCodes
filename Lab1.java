import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[] arr = new int[n];
        for (int i=0; i<n;i++){
            arr[i] = input.nextInt();
        }
        
        int pc = 0;
        int nc = 0;
        int zc = 0;
        
        for (int i =0; i<n; i++){
            if (arr[i] > 0){
                pc++;
            } else if (arr[i] < 0){
                nc++;
            } else{
                zc++;
            }
        }
        
        System.out.printf("%.3f%n", (double) pc / n);
        System.out.printf("%.3f%n", (double) nc / n);
        System.out.printf("%.3f%n", (double) zc / n);
    }
}    
        
        
        
        
                                                                                                                            