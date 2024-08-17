package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] malesArr = scanner.nextLine().split(" ");
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        for (String male : malesArr) {
            malesStack.push(Integer.parseInt(male));
        }

        String[] femalesArr = scanner.nextLine().split(" ");
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        for (String female : femalesArr) {
            femalesQueue.offer(Integer.parseInt(female));
        }
        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (male <= 0) {
                malesStack.pop();
                continue;
            }

            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (female == male) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                male -= 2;
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(male);
            }

        }
        System.out.println("Matches: " + matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", malesStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", femalesQueue.toString().replaceAll("[\\[\\]]", "")));
            // System.out.println(femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
