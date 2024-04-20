package _01_StacksAndQueues.Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> kids = new PriorityQueue<>();

       // Collections.addAll(kids, names);
        for (String kid : names) {
            kids.offer(kid);
        }
        int stepsCount = 1;

        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }

            if (isPrime(stepsCount)) {
                System.out.println("Prime " + kids.peek());
            } else {
                String removedKid = kids.poll();
                System.out.println("Removed " + removedKid);
            }
            stepsCount ++;
        }
        System.out.println("Last is " + kids.peek());
    }

    private static boolean isPrime(int stepsCount) {

        if(stepsCount == 1){
            return false;
        }
        for (int i = 2; i < stepsCount ; i++) {
            if(stepsCount % i == 0){
                return false;
            }
        }
        return true;
    }
}
