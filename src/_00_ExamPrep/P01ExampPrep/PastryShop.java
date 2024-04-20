package _00_ExamPrep.P01ExampPrep;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
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

        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        while (!liquidsQue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsQue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            String cookie;

            if (sum == 25) {
                cookie = "Biscuit";
            } else if (sum == 50) {
                cookie = "Cake";
            } else if (sum == 75) {
                cookie = "Pastry";
            } else if (sum == 100) {
                cookie = "Pie";
            } else {
                cookie = null;
            }
            if (cookie != null) {
                food.put(cookie, food.get(cookie) + 1);

            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }
        int count = (int) food.entrySet().stream().filter(f -> f.getValue() > 0).count();

        if (count >= 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQue.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.print("Liquids left: ");
            System.out.println(liquidsQue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        food.entrySet().forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }
}
