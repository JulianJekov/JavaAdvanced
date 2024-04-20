package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> firstBoxQue = new ArrayDeque<>();
        for (String box : firstArr) {
            firstBoxQue.offer(Integer.parseInt(box));
        }
        String[] secondArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        for (String box : secondArr) {
            secondBoxStack.push(Integer.parseInt(box));
        }
        int items = 0;
        while (!firstBoxQue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sum = firstBoxQue.peek() + secondBoxStack.peek();
            if (sum % 2 == 0) {
                items += sum;
                firstBoxQue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQue.offer(secondBoxStack.pop());
            }
        }
        System.out.println(firstBoxQue.isEmpty() ? "First magic box is empty."
                : "Second magic box is empty.");

        System.out.println(items >= 90 ? "Wow, your prey was epic! Value: " + items
                : "Poor prey... Value: " + items);
    }
}
