import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if ( a <1000){
            System.out.println("Provided input is less than 4, enter four digit integers");
        } else if (a >9999){
            System.out.println("Provided input is more than 4, enter four digit integers");
            
        } else{
            int encryptedNumber = encryptNumber(a);
            System.out.println(encryptedNumber);
        }
    }
    
    public static int encryptNumber(int a) {
        int d1 = a /1000;
        int d2 = (a / 100) % 10;
        int d3 = (a/10)%10;
        int d4 = a % 10;
        
        d1 = (d1 + 5) % 10;
        d2 = (d2 + 5) % 10;
        d3 = (d3 + 5) % 10;
        d4 = (d4 + 5) % 10;
        
        int temp = d1;
        d1 = d3;
        d3 = temp;
        
        temp = d2;
        d2 = d4;
        d4 = temp;
        
        return d1 * 1000 + d2 * 100 + d3 * 10 + d4;
    
    }
}
                                                                                                                            