package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(input));
            //Collections.addAll(elements, input);
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
