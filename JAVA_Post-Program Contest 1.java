//Phone no to Letters 

import java.util.*;
public class Main {
    private static final String[] KEYPAD = {
        "",    
        "",    
        "abc", 
        "def", 
        "ghi", 
        "jkl", 
        "mno",
        "pqrs",
        "tuv", 
        "wxyz" 
    };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0']; 
        if (letters.isEmpty()) {
            backtrack(result, current, digits, index + 1);
            return;
        }
        for (char letter : letters.toCharArray()) {
            current.append(letter);          
            backtrack(result, current, digits, index + 1); 
            current.deleteCharAt(current.length() - 1);    
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine(); 
        List<String> result = letterCombinations(digits);
        for (String combination : result) {
            System.out.print(combination + " ");
        }
        scanner.close();
    }
}
