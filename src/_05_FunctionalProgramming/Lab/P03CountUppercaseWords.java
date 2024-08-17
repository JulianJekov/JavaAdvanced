package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(words.size());

        words.forEach(System.out::println);
    }
}
