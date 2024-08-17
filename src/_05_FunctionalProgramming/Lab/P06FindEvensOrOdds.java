package _05_FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int start = range[0];
        int end = range[1];

        List<Integer> numbers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        String oddOrEven = scanner.nextLine();

        Predicate<Integer> oddEvenPredicate;
        if (oddOrEven.equals("even")) {
            oddEvenPredicate = number -> number % 2 == 0;
        } else {
            oddEvenPredicate = number -> number % 2 != 0;
        }

        Consumer<Integer> printer = e -> System.out.print(e + " ");

        numbers.stream()
                .filter(oddEvenPredicate)
                .forEach(printer);
    }
}