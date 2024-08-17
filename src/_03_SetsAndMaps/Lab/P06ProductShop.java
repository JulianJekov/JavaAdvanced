package _03_SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> store = new TreeMap<>();
        while (!input.equals("Revision")) {

            String[] inputData = input.split(", ");

            String shopName = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);

            if (!store.containsKey(shopName)) {
                store.put(shopName, new LinkedHashMap<>());
                Map<String, Double> products = store.get(shopName);
                products.put(product, price);
            }
            store.get(shopName).put(product, price);


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : store.entrySet()) {
            System.out.println(entry.getKey() + "->");
            entry.getValue().forEach((key, value) ->
                    System.out.printf("Product: %s, Price: %.1f%n", key, value));
        }

    }
}
