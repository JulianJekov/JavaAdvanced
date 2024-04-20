package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> liquidsQue = new ArrayDeque<>();
        for (String liquid : firstArr) {
            liquidsQue.offer(Integer.parseInt(liquid));
        }
        String[] secondArr = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (String ingredient : secondArr) {
            ingredientsStack.push(Integer.parseInt(ingredient));
        }
        Map<String, Integer> food = new TreeMap<>(Map.of(
                "Bread", 0,
                "Cake", 0,
                "Pastry", 0,
                "Fruit Pie", 0));

        while (!liquidsQue.isEmpty() && !ingredientsStack.isEmpty()) {
            int lastIngredient = ingredientsStack.pop();
            int sum = liquidsQue.poll() + lastIngredient;

            String cookedFodd;

            if (sum == 25) {
                cookedFodd = "Bread";
            } else if (sum == 50) {
                cookedFodd = "Cake";
            } else if (sum == 75) {
                cookedFodd = "Pastry";
            } else if (sum == 100) {
                cookedFodd = "Fruit Pie";
            } else {
                cookedFodd = null;
            }
            if (cookedFodd != null) {
                food.put(cookedFodd, food.get(cookedFodd) + 1);
            } else {
                ingredientsStack.push(lastIngredient + 3);
            }
        }
        boolean allFoodCooked = food.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .count() >= food.size();
        if (allFoodCooked) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println(liquidsQue.isEmpty() ? "Liquids left: none"
                : "Liquids left: " +
                liquidsQue.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(ingredientsStack.isEmpty() ? "Ingredients left: none"
                : "Ingredients left: " +
                ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        food.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
