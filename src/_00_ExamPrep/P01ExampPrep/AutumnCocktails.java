package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredientsQue = new ArrayDeque<>();
        for (String ingredient : firstArr) {
            ingredientsQue.offer(Integer.parseInt(ingredient));
        }
        String[] secondArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (String freshness : secondArr) {
            freshnessStack.push(Integer.parseInt(freshness));
        }

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsQue.isEmpty() && !freshnessStack.isEmpty()) {

            if (ingredientsQue.peek() == 0) {
                ingredientsQue.poll();
                continue;
            }
            int ingredient = ingredientsQue.poll();
            int freshness = freshnessStack.pop();
            int sum = ingredient * freshness;

            String cocktailName;

            if (sum == 150) {
                cocktailName = "Pear Sour";
            } else if (sum == 250) {
                cocktailName = "The Harvest";
            } else if (sum == 300) {
                cocktailName = "Apple Hinny";
            } else if (sum == 400) {
                cocktailName = "High Fashion";
            } else {
                cocktailName = null;
            }

            if (cocktailName != null) {
                cocktails.putIfAbsent(cocktailName, 0);
                cocktails.put(cocktailName, cocktails.get(cocktailName) + 1);
            } else {
                ingredientsQue.offer(ingredient + 5);
            }
        }
        int count = (int) cocktails
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .count();

        if (count >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQue.isEmpty()) {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsQue.stream().mapToInt(Integer::intValue).sum());
        }
        cocktails.entrySet()
                .stream()
                .filter(c -> c.getValue() > 0)
                .forEach(c -> System.out.printf("# %s --> %d%n", c.getKey(), c.getValue()));
    }
}
