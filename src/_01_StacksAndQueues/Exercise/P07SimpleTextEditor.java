package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        int operationsCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String commands = scanner.nextLine();

            if (commands.startsWith("1")) {

                stack.push(text.toString());
                String stringToAppend = commands.split(" ")[1];
                text.append(stringToAppend);

            } else if (commands.startsWith("2")) {

                stack.push(text.toString());
                int lastCountElementsToDelete = Integer.parseInt(commands.split(" ")[1]);
                text.delete(text.length() - lastCountElementsToDelete, text.length());

            } else if (commands.startsWith("3")) {

                int positionInText = Integer.parseInt(commands.split(" ")[1]);
                System.out.println(text.charAt(positionInText - 1));

            } else if (commands.startsWith("4")) {

                if(!stack.isEmpty()) {
                    String newText = stack.pop();
                    text = new StringBuilder(newText);
                }
            }
        }
    }
}
