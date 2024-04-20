package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int claimedItems = 0;

        while (!firstBoxQue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItemFirstBox = firstBoxQue.peek();
            int lastItemSecondBox = secondBoxStack.peek();
            int sum = firstItemFirstBox + lastItemSecondBox;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBoxQue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQue.offer(lastItemSecondBox);
            }
        }
        if (firstBoxQue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + claimedItems);
        }
    }
}
