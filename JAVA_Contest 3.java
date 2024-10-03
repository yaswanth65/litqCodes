// W_GoatLatin

import java.util.Scanner;
public class Main {
    public static String convertToGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder goatLatinSentence = new StringBuilder();
        String vowels = "aeiouAEIOU"; 
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder goatLatinWord = new StringBuilder();
            if (vowels.indexOf(word.charAt(0)) != -1) {
                goatLatinWord.append(word).append("ma");
            } else {
                goatLatinWord.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                goatLatinWord.append('a');
            }
            goatLatinSentence.append(goatLatinWord).append(" ");
        }
        return goatLatinSentence.toString().trim(); 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputSentence = scanner.nextLine();
        String result = convertToGoatLatin(inputSentence);
        System.out.println(result);
        scanner.close();
    }
}
