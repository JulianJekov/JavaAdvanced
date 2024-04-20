package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreath = 0;
        int leftFlowers = 0;
        while (!liliesStack.isEmpty() && !rosesQue.isEmpty()) {
            int lastLilies = liliesStack.peek();
            int firstRose = rosesQue.peek();
            int sum = lastLilies + firstRose;

            if (sum == 15) {
                wreath++;
                liliesStack.pop();
                rosesQue.poll();
            } else if (sum > 15) {
                liliesStack.pop();
                liliesStack.push(lastLilies - 2);
            } else {
                liliesStack.pop();
                rosesQue.poll();
                leftFlowers += sum;
            }
        }
        int moreWreath = leftFlowers / 15;
        wreath += moreWreath;

        if(wreath >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreath);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!",5 - wreath);
        }
    }
}
