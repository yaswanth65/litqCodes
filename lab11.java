import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = readArray(sc);
        int[] arr2 = readArray(sc);
        int[] arr3 = readArray(sc);
        List<Integer> commonElements = findCommonElements(arr1, arr2, arr3);
        if (commonElements.isEmpty()) {
            System.out.println("No Elements");
        } else {
            for (int element : commonElements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    private static int[] readArray(Scanner sc) {
        String inputLine = sc.nextLine();
        String[] inputTokens = inputLine.split(" ");
        int[] array = new int[inputTokens.length];
        for (int i = 0; i < inputTokens.length; i++) {
            array[i] = Integer.parseInt(inputTokens[i]);
        }
        return array;
    }
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0; 
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}
