package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10Robots {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");

        Map<String, Integer> robots = splitRobotsDataInToLinkedMap(inputRobots);

        int[] processTime = new int[robots.size()];

        String[] time = scanner.nextLine().split(":");

        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long totalSeconds = hours * 3600L + minutes * 60L + seconds;

        String line = scanner.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();
        while (!line.equals("End")) {
            products.offer(line);
            line = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            totalSeconds++;
            String currentProduct = products.poll();

            decreaseProcessTime(processTime);

            if (!assignJob(robots, processTime, totalSeconds, currentProduct)) {
                products.offer(currentProduct);
            }

        }
    }

    private static void decreaseProcessTime(int[] processTime) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] > 0) {
                --processTime[i];
            }
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] processTime, long totalSeconds, String currentProduct) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] == 0) {
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if (count == i) {
                        processTime[i] = entry.getValue();
                        logJobAssigned(entry.getKey(), currentProduct, totalSeconds);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void logJobAssigned(String name, String product, long totalSeconds) {
        long hours = (totalSeconds / 3600) % 24;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        System.out.println(String.format("%s - %s [%02d:%02d:%02d]",name,product,hours,minutes,seconds));
    }

    private static Map<String, Integer> splitRobotsDataInToLinkedMap(String[] inputRobots) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        for (int i = 0; i < inputRobots.length; i++) {

            int index = inputRobots[i].indexOf("-");
            String name = inputRobots[i].substring(0, index);
            int time = Integer.parseInt(inputRobots[i].substring(index + 1));
            robots.put(name, time);
        }
        return robots;
    }
}
