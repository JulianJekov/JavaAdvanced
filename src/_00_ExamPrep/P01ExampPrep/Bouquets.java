package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (String tulip : firstArr) {
            tulipsStack.push(Integer.parseInt(tulip));
        }

        String[] secondArr = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> daffodilsQue = new ArrayDeque<>();
        for (String daffodil : secondArr) {
            daffodilsQue.offer(Integer.parseInt(daffodil));
        }
        int bouquets = 0;
        int leftFlowers = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQue.isEmpty()) {

            int lastTulip = tulipsStack.peek();
            int firstDaffodil = daffodilsQue.peek();
            int sum = lastTulip + firstDaffodil;

            if (sum > 15) {
                while (sum > 15) {
                    sum -= 2;
                }
            }
            if (sum == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQue.poll();
            } else {
                tulipsStack.pop();
                daffodilsQue.poll();
                leftFlowers += sum;
            }
        }
        int moreBouquets = leftFlowers / 15;
        bouquets += moreBouquets;

        System.out.println(bouquets >= 5 ? String.format("You made it! You go to the competition with %d bouquets!", bouquets)
                : String.format("You failed... You need more %d bouquets.", 5 - bouquets));
    }
}
