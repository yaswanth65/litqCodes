
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" "); 
        int[] sightings = new int[input.length]; 
        for (int i = 0; i < input.length; i++) {
            sightings[i] = Integer.parseInt(input[i]);
        }
        int result = findMostCommonPlant(sightings);
        System.out.println(result); 
    }
    public static int findMostCommonPlant(int[] sightings) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); 
        for (int sighting : sightings) {
            frequencyMap.put(sighting, frequencyMap.getOrDefault(sighting, 0) + 1);
        }
        int mostCommonPlant = Integer.MAX_VALUE;
        int highestFrequency = 0; 
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int plantID = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > highestFrequency || (frequency == highestFrequency && plantID < mostCommonPlant)) {
                mostCommonPlant = plantID;
                highestFrequency = frequency;
            }
        }
        return mostCommonPlant; 
    }
}