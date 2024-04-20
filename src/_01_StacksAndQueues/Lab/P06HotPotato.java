package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();

        for (String kid : names) {
            kids.offer(kid);
        }

        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }
            String removedKid = kids.poll();
            System.out.println("Removed " + removedKid);
        }
        System.out.println("Last is " + kids.peek());
    }
}
