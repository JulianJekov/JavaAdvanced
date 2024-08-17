package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> backCommandStack = new ArrayDeque<>();
        ArrayDeque<String> forwardCommandQueue = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (backCommandStack.size() < 2) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String forward = backCommandStack.pop();
                    System.out.println(backCommandStack.peek());
                    forwardCommandQueue.push(forward);
                }
            }else if (input.equals("forward")) {
                if (forwardCommandQueue.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String back = forwardCommandQueue.peek();
                    System.out.println(forwardCommandQueue.pop());
                    backCommandStack.push(back);
                }
            }  else {
                backCommandStack.push(input);
                System.out.println(input);
                forwardCommandQueue.clear();
            }
            input = scanner.nextLine();
        }
    }
}
