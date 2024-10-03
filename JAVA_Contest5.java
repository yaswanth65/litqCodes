// Activity Selection

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] startTimes = new int[n][1];
        int[][] endTimes = new int[n][1];
        for (int i = 0; i < n; i++) {
            startTimes[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            endTimes[i][0] = scanner.nextInt();
        }
        Main main = new Main();
        int[][] result = main.maxActivities(startTimes, endTimes);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
    public int[][] maxActivities(int[][] startTimes, int[][] endTimes) {
        int[][] activities = new int[startTimes.length][2];
        for (int i = 0; i < startTimes.length; i++) {
            activities[i][0] = startTimes[i][0];
            activities[i][1] = endTimes[i][0];
        }
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);
        ArrayList<int[]> result = new ArrayList<>();
        result.add(activities[0]);
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= result.get(result.size() - 1)[1]) {
                result.add(activities[i]);
            }
        }
        return result.toArray(new int[0][]);
    }
}
