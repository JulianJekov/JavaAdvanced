package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int elementsToPush = Integer.parseInt(input[0]);
        int elementsToPop = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        String[] numbersToAdd = scanner.nextLine().split("\\s+");

        for (int i = 0; i < elementsToPush; i++) {
            numbersStack.push(Integer.parseInt(numbersToAdd[i]));
        }
        for (int i = 0; i < elementsToPop; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
        } else if (numbersStack.contains(elementToSearch)) {
            System.out.println(true);
        } else {
            // int minNum =  Collections.min(numbersStack);
            // int minElement = numbersStack.stream().mapToInt(e -> e).min().getAsInt();
            int minNumber = Integer.MAX_VALUE;
            for (Integer number : numbersStack) {
                if (number < minNumber) {
                    minNumber = number;
                }
            }
            System.out.println(minNumber);
        }
    }
}
