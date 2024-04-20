package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] milligramsArr = scanner.nextLine().trim().split(", ");
        ArrayDeque<Integer> milligrams = new ArrayDeque<>();
        for (String milligram : milligramsArr) {
            milligrams.push(Integer.parseInt(milligram));
        }

        String[] drinksArr = scanner.nextLine().trim().split(", ");
        ArrayDeque<Integer> drinks = new ArrayDeque<>();
        for (String drink : drinksArr) {
            drinks.offer(Integer.parseInt(drink));
        }

        int maxCaffeine = 0;

        while (!milligrams.isEmpty() && !drinks.isEmpty()) {

            int currentMilligrams = milligrams.peek();
            int currentDrink = drinks.peek();
            int sum = currentMilligrams * currentDrink;

            if (maxCaffeine + sum <= 300) {
                milligrams.pop();
                drinks.poll();
                maxCaffeine += sum;
            } else {
                milligrams.pop();
                drinks.poll();
                drinks.offer(currentDrink);
                maxCaffeine -= 30;
                if (maxCaffeine < 0) {
                    maxCaffeine = 0;
                }
            }
        }
        if (!drinks.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(String.join(", ",drinks.toString().replaceAll("[\\[\\]]","")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.println("Stamat is going to sleep with " + maxCaffeine + " mg caffeine.");
    }
}
