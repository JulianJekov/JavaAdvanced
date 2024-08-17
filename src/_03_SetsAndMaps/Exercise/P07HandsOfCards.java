package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> deck = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {

            String[] inputData = input.split(": ");
            String name = inputData[0];
            String[] cards = inputData[1].split(", ");

            if (!deck.containsKey(name)) {
                deck.put(name, new HashSet<>());
            }
            Collections.addAll(deck.get(name), cards);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, HashSet<String>> entry : deck.entrySet()) {
            String name = entry.getKey();
            int points = calculatePoints(entry.getValue());
            System.out.printf("%s: %d%n", name, points);
        }

       // deck.get(name).addAll(List.of(cards));

       // for (String card : cards) {
       //     deck.get(name).add(card);
       // }
    }

    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1);
            int cardPoints = getPower(power) * getColor(color);
            points += cardPoints;
        }
        return points;
    }

    private static int getColor(String color) {
        switch (color) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
        }
        return 0;
    }

    private static int getPower(String power) {
        switch (power) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }
        return 0;
    }
}
