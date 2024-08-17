package _01_StacksAndQueues.Lab;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        String[] expressionParts = expression.split(" ");
        List<String> partsList = Arrays.asList(expressionParts);
        //Collections.addAll(stack,expressionParts);
        // stack.addAll(partsList);
        // ArrayDeque<String> stack = new ArrayDeque<>(partsList);

        Collections.reverse(partsList);

        for (String item : expressionParts) {
            stack.push(item);
        }

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            int sum = 0;
            if (operation.equals("+")) {
                sum = firstNumber + secondNumber;
            } else {
                sum = firstNumber - secondNumber;
            }
            stack.push(Integer.toString(sum));
        }
        System.out.println(stack.peek());
    }
}
