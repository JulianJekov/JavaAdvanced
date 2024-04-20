package _01_StacksAndQueues.Exercise;

import java.util.*;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stackNumbers = new ArrayDeque<>();

        for (String number : numbers) {
            stackNumbers.push(number);
        }
        while (!stackNumbers.isEmpty()){
            System.out.print(stackNumbers.pop() + " ");
        }
    }
}
