package _03_SetsAndMaps.Lab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> countNumbers = new LinkedHashMap<>();

        for (double number : numbers) {
            countNumbers.putIfAbsent(number, 0);
            countNumbers.put(number, countNumbers.get(number) + 1);

        }
        for (Map.Entry<Double, Integer> entry : countNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }



    }
}
