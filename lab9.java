import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] charlieInput = scanner.nextLine().split(" ");
        int[] charlie = new int[charlieInput.length];
        for (int i = 0; i < charlieInput.length; i++) {
            charlie[i] = Integer.parseInt(charlieInput[i]);
        }
        String[] daveInput = scanner.nextLine().split(" ");
        int[] dave = new int[daveInput.length];
        for (int i = 0; i < daveInput.length; i++) {
            dave[i] = Integer.parseInt(daveInput[i]);
        }
        int charliePoints = 0;
        int davePoints = 0;
        for (int i = 0; i < charlie.length && i < dave.length; i++) {
            if (charlie[i] > dave[i]) {
                charliePoints++;
            } else if (charlie[i] < dave[i]) {
                davePoints++;
            }
        }
        System.out.println(charliePoints + " " + davePoints);
    }
}
