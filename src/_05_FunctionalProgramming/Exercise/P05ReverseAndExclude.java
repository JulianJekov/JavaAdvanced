package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int magicNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);

        Predicate<Integer> predicate = n -> n % magicNumber != 0;

        list.stream()
                .filter(predicate)
                .forEach(number -> System.out.print(number + " "));
    }
}
