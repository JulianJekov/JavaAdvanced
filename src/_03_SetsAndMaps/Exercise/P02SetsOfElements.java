package _03_SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = setSizes[0];
        int secondSetSize = setSizes[1];

        Set<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSetSize; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

        firstSet.retainAll(secondSet);

        for (String element : firstSet) {
            System.out.print(element + " ");
        }
    }
}
