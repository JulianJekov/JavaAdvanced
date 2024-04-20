package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .forEach(maleStack::push);

        ArrayDeque<Integer> femaleQue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;
        while (!maleStack.isEmpty() && !femaleQue.isEmpty()) {

            int lastMale = maleStack.peek();
            int firstFemale = femaleQue.peek();

            if (lastMale <= 0) {
                maleStack.pop();
                continue;
            }

            if (firstFemale <= 0) {
                femaleQue.poll();
                continue;
            }

            if (lastMale % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            if (firstFemale % 25 == 0) {
                femaleQue.poll();
                femaleQue.poll();
                continue;
            }

            if (lastMale == firstFemale) {
                matches++;
                maleStack.pop();
                femaleQue.poll();
            } else {
                femaleQue.poll();
                maleStack.pop();
                maleStack.push(lastMale - 2);
            }
        }
        System.out.println("Matches: " + matches);

        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(maleStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (femaleQue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femaleQue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
