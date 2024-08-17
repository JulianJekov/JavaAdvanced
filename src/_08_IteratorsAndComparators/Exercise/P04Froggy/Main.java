package _08_IteratorsAndComparators.Exercise.P04Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Integer[] numbers = Arrays.stream(input.split(", ")).map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(numbers);
//        StringBuilder sb = new StringBuilder();
//        for (Integer number : lake) {
//            sb.append(number).append(", ");
//        }
//        System.out.println(sb.substring(0,sb.length() - 2));
        List<String> result = new ArrayList<>();
        for (Integer number : lake) {
            result.add(String.valueOf(number));
        }
        System.out.println(String.join(", ", result));
    }
}
