package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        String[] input = scanner.nextLine().split(", ");
//
//
//        System.out.println("Count = " + input.length);
//        int sum = Arrays.stream(input).mapToInt(Integer::parseInt).sum();
//        System.out.println("Sum = " + sum);

        Function<int[], String> count = elements -> "Count = " + Arrays.stream(elements).count();
        Function<int[], String> sum = elements -> "Sum = " + Arrays.stream(elements).sum();
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));
    }
}
