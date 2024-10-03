//  Task Scheduling

import java.util.Scanner;
public class Main{
    static boolean isPossible(int[] tasks, int N, int K, int maxTime) {
        int workersRequired = 1, currentTime = 0;
        for (int i = 0; i < N; i++) {
            if (tasks[i] > maxTime) return false;
            if (currentTime + tasks[i] > maxTime) {
                workersRequired++;
                currentTime = tasks[i]; 
            } else {
                currentTime += tasks[i];
            }
            if (workersRequired > K) {
                return false;
            }
        }
        return true;
    }
    static int findMinTime(int[] tasks, int N, int K) {
        int left = 0, right = 0;
        for (int task : tasks) {
            right += task; 
            left = Math.max(left, task);
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(tasks, N, K, mid)) {
                result = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] tasks = new int[N];
        for (int i = 0; i < N; i++) {
            tasks[i] = scanner.nextInt();
        }
        int K = scanner.nextInt();
        System.out.println(findMinTime(tasks, N, K));
    }
}
