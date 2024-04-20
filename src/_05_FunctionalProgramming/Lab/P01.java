package _05_FunctionalProgramming.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));


        evenNumbers = evenNumbers
                .stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbers));

//        List<String> evenNumbers = Arrays.stream(stringNumbers)
//                .map(e -> Integer.parseInt(e))
//                .filter(e -> e % 2 == 0)
//                .map(e -> e.toString())
//                .collect(Collectors.toList());
//
//        System.out.println(String.join(", ", evenNumbers));

//        evenNumbers = evenNumbers
//                .stream()
//                .map(e -> Integer.parseInt(e))
//                .sorted((left,right) -> left.compareTo(right))
//                .map(e->e.toString())
//                .collect(Collectors.toList());
//        System.out.println(String.join(", ", evenNumbers));
    }
}
