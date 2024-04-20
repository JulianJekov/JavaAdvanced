package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

//        Function<List<Integer>,List<Integer>> add = list -> list.stream().map(number -> number + 1).collect(Collectors.toList());
//        Function<List<Integer>,List<Integer>> multiply = list -> list.stream().map(number -> number * 2).collect(Collectors.toList());
//        Function<List<Integer>,List<Integer>> subtract = list -> list.stream().map(number -> number - 1).collect(Collectors.toList());

        Consumer<List<Integer>> add = element -> element.replaceAll(n -> n + 1);
        Consumer<List<Integer>> multiply = element -> element.replaceAll(n -> n * 2);
        Consumer<List<Integer>> subtract = element -> element.replaceAll(n -> n - 1);
        Consumer<List<Integer>> printer = elements -> elements.forEach(num -> System.out.print(num + " "));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    add.accept(numbers);
                   // numbers = add.apply(numbers);
                    break;
                case "multiply":
                    multiply.accept(numbers);
                   // numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    subtract.accept(numbers);
                  //  numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;

            }

            command = scanner.nextLine();
        }

    }
}
