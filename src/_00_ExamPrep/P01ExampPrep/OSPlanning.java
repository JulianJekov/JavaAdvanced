package _00_ExamPrep.P01ExampPrep;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] secondArr = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (String task : secondArr) {
            tasksStack.push(Integer.parseInt(task));
        }

        String[] firstArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> threadsQue = new ArrayDeque<>();
        for (String thread : firstArr) {
            threadsQue.offer(Integer.parseInt(thread));
        }
        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {
            int firstThread = threadsQue.peek();
            int lasTask = tasksStack.peek();

            if (lasTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", firstThread, taskToKill);
                break;
            }

            if (firstThread >= lasTask) {
                tasksStack.pop();
            }

            threadsQue.poll();
        }
        threadsQue.forEach(e -> System.out.print(e + " "));
    }
}
