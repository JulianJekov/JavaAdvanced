package _05_FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> personsWithAge = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split(", ");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);

            personsWithAge.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;

        if (condition.equals("younger")) {
            filterPredicate = (personAge, age) -> personAge <= age;
        } else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;

        if (printFormat.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else if (printFormat.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else {
            printConsumer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        personsWithAge.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);
    }
}
