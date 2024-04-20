package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Count = " + numbers.length);
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum = " + sum);
    }
}
