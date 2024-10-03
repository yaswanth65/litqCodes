// Job Sequencing

import java.util.*;
class Job {
    char id; 
    int deadline; 
    int profit;
    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[] jobNames = scanner.nextLine().replaceAll(" ", "").toCharArray();
        int[] deadlines = new int[n];
        for (int i = 0; i < n; i++) {
            deadlines[i] = scanner.nextInt();
        }
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(jobNames[i], deadlines[i], profits[i]);
        }
        List<Character> result = jobScheduling(jobs, n);
        for (char jobId : result) {
            System.out.print(jobId + " ");
        }
    }
    static List<Character> jobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        boolean[] slots = new boolean[n];
        char[] result = new char[n]; 
        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true; 
                    result[j] = job.id; 
                    break;
                }
            }
        }
        List<Character> jobOrder = new ArrayList<>();
        for (char jobId : result) {
            if (jobId != '\0') {
                jobOrder.add(jobId);
            }
        }
        return jobOrder;
    }
}
