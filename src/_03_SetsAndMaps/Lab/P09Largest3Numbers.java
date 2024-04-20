package _03_SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1)).collect(Collectors.toList());
        //naturalOrder
        //reversedOrder

        int size = Math.min(3, sorted.size());
        for (int i = 0; i < size; i++) {
            System.out.print(sorted.get(i) + " ");
        }
//        if (sorted.size() <= 3) {
//            for (Integer integer : sorted) {
//                System.out.print(integer + " ");
//            }
//        } else {
//            for (int i = 0; i < 3; i++) {
//
//                System.out.print(sorted.get(i) + " ");
//            }
//        }
    }
}
