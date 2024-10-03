import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] numbers = input.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            int sum = calculateSingleDigitSum(number);
            result.append(convertDigitToChar(sum));
        }
        System.out.println(result.toString());
    }
    private static int calculateSingleDigitSum(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            sum += c - '0'; 
        }
        while (sum >= 10) {
            sum = sum / 10 + sum % 10;
        }
        return sum;
    }
    private static char convertDigitToChar(int digit) {
        switch (digit) {
            case 1: return 'a'; 
            case 2: return '2'; 
            case 3: return 'c'; 
            case 4: return '4'; 
            case 5: return 'e'; 
            case 6: return '6'; 
            case 7: return 'g';
            case 8: return '8'; 
            case 9: return 'i';
            case 0: return '0'; 
            default: return 'a'; 
        }
    }
}
                                                                                                                            