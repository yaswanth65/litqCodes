//Cipher 

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static String encryptWord(String word, Object key, String operation) {
        Map<Character, Character> cipher = new HashMap<>();
        cipher.put('A', 'Z');
        cipher.put('B', 'Y');
        cipher.put('C', 'X');
        cipher.put('D', 'W');
        cipher.put('E', 'V');
        cipher.put('F', 'U');
        cipher.put('G', 'T');
        cipher.put('H', 'S');
        cipher.put('I', 'R');
        cipher.put('J', 'Q');
        cipher.put('K', 'P');
        cipher.put('L', 'O');
        cipher.put('M', 'N');
        cipher.put('N', 'M');
        cipher.put('O', 'L');
        cipher.put('P', 'K');
        cipher.put('Q', 'J');
        cipher.put('R', 'I');
        cipher.put('S', 'H');
        cipher.put('T', 'G');
        cipher.put('U', 'F');
        cipher.put('V', 'E');
        cipher.put('W', 'D');
        cipher.put('X', 'C');
        cipher.put('Y', 'B');
        cipher.put('Z', 'A');
        if (!(key instanceof Integer)) {
            return "Enter valid key";
        }
        if (!operation.equals("addition") && !operation.equals("subtraction")) {
            return "Invalid Operation";
        }
        if (!word.equals(word.toUpperCase())) {
            return "Word should be in capitals";
        }
        StringBuilder encryptedWord = new StringBuilder();
        for (char charInWord : word.toCharArray()) {
            if (cipher.containsKey(charInWord)) {
                char substitutedChar = cipher.get(charInWord);
                int asciiValue = (int) substitutedChar;
                int newAsciiValue;
                if (operation.equals("addition")) {
                    newAsciiValue = asciiValue + (Integer) key;
                } else {
                    newAsciiValue = asciiValue - (Integer) key;
                }
                encryptedWord.append((char) newAsciiValue);
            }
        }
        return encryptedWord.toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key;
        try {
            key = input.nextInt();
        } catch (Exception e) {
            System.out.println(" ");
            return;
        }
        input.nextLine(); 
        String operation = input.nextLine().toLowerCase();
        String word = input.nextLine();
        String result = encryptWord(word, key, operation);
        System.out.println(result);
        input.close();
    }
}
