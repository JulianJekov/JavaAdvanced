package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int elementsToOffer = Integer.parseInt(input[0]);
        int elementsToPoll = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        String[] numbersToAdd = scanner.nextLine().split("\\s+");

        for (int i = 0; i < elementsToOffer; i++) {
            numbersQueue.offer(Integer.parseInt(numbersToAdd[i]));
        }
        for (int i = 0; i < elementsToPoll; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else if (numbersQueue.contains(elementToSearch)) {
            System.out.println(true);
        } else {
            //int minNumber =  Collections.min(numbersQueue);
            int minElement = numbersQueue.stream().mapToInt(e -> e).min().getAsInt();
//            int minNumber = Integer.MAX_VALUE;
//            for (Integer number : numbersQueue) {
//                if (number < minNumber) {
//                    minNumber = number;
//                }
//            }
            System.out.println(minElement);
        }
    }
}
