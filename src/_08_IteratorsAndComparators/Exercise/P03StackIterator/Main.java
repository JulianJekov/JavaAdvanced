package _08_IteratorsAndComparators.Exercise.P03StackIterator;



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Stack stack = new Stack();

        while (!input.equals("END")){

            String[] lines = input.split("\\s+");
            if ("Push".equals(lines[0])) {
                int[] elements = Arrays.stream(input.substring(5).trim().split(", ")).mapToInt(Integer::parseInt).toArray();
                stack.push(elements);
            } else if ("Pop".equals(lines[0])) {
                stack.pop();
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i <2 ; i++) {
            for (int element : stack) {
                System.out.println(element);
            }
        }
    }
}
