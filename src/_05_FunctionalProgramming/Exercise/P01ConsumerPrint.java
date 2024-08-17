package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Consumer<String> consumer = System.out::println;

        names.forEach(consumer);
    }
}
