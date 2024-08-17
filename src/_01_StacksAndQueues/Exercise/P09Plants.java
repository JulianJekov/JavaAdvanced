package _01_StacksAndQueues.Exercise;

import java.util.*;

public class P09Plants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();

        int[] days = new int[plants.length];

        prevPlants.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while (prevPlants.size() > 0 && plants[prevPlants.peek()] >= plants[i]) {

                maxDays = Integer.max(days[prevPlants.pop()], maxDays);
            }

            if (prevPlants.size() > 0) {
                days[i] = maxDays + 1;
            }

            prevPlants.push(i);
        }

        System.out.printf("%d", Arrays.stream(days).max().getAsInt());
    }
}
