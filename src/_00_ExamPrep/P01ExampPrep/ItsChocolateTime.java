package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] milkArr = scanner.nextLine().split(" ");
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (String milk : milkArr) {
            milkQueue.offer(Double.parseDouble(milk));
        }

        String[] cacaoArr = scanner.nextLine().split(" ");
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        for (String cacao : cacaoArr) {
            cacaoStack.push(Double.parseDouble(cacao));
        }

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double currentMilk = milkQueue.peek();
            double currentCacao = cacaoStack.peek();
            long cacaoPercent = Math.round((currentCacao / (currentCacao + currentMilk)) * 100);

            milkQueue.poll();
            cacaoStack.pop();

            String madeChocolate = null;

            if (cacaoPercent == 30) {
                madeChocolate = "Milk Chocolate";
            } else if (cacaoPercent == 50) {
                madeChocolate = "Dark Chocolate";
            } else if (cacaoPercent == 100) {
                madeChocolate = "Baking Chocolate";
            }

            if (madeChocolate != null) {
                int currentQuantity = chocolates.get(madeChocolate);
                chocolates.put(madeChocolate, currentQuantity + 1);
            } else {
                milkQueue.offer(currentMilk + 10);
            }
        }
        boolean hasAllChocolates = chocolates.entrySet()
                .stream()
                .allMatch(e -> e.getValue() > 0);

        if (hasAllChocolates) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("# %s --> %d%n", e.getKey(), e.getValue()));
    }
}