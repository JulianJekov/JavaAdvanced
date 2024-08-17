package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "1":
                    int elementToPush = Integer.parseInt(commands[1]);
                    numStack.push(elementToPush);
                    break;
                case "2":
                    numStack.pop();
                    break;
                case "3":
                    int maxElement = Collections.max(numStack);
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
