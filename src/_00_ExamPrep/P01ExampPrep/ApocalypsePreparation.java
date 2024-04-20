package _00_ExamPrep.P01ExampPrep;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        String input = scanner.nextLine();
        int[] textiles = Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < textiles.length; i++) {
            textilesQueue.offer(textiles[i]);
        }
        input = scanner.nextLine();
        ArrayDeque<Integer> medicametsStack = new ArrayDeque<>();
        ArrayDeque<Integer> reversedMedicaments = new ArrayDeque<>();
        int[] medicaments = Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < medicaments.length; i++) {
            medicametsStack.push(medicaments[i]);
        }

        int patch = 0;
        int bandages = 0;
        int medKit = 0;
        Map<String, Integer> items = new TreeMap<>();

        while (!textilesQueue.isEmpty() && !medicametsStack.isEmpty()) {

            int textileElement = textilesQueue.poll();
            int medicamentElement = medicametsStack.pop();
            int sum = textileElement + medicamentElement;

            if (sum == 30) {
                if (!items.containsKey("Patch")) {
                    items.put("Patch", 1);
                } else {
                    items.put("Patch", items.get("Patch") + 1);
                }
            } else if (sum == 40) {
                if (!items.containsKey("Bandage")) {
                    items.put("Bandage", 1);
                } else {
                    items.put("Bandage", items.get("Bandage") + 1);
                }
            } else if (sum == 100) {
                if (!items.containsKey("MedKit")) {
                    items.put("MedKit", 1);
                } else {
                    items.put("MedKit", items.get("MedKit") + 1);
                }
            } else if (sum > 100) {
                int lastElement = medicametsStack.pop();
                medicametsStack.push(lastElement + sum - 100);
                if (!items.containsKey("MedKit")) {
                    items.put("MedKit", 1);
                } else {
                    items.put("MedKit", items.get("MedKit") + 1);
                }
            } else {
                medicametsStack.push(medicamentElement + 10);
            }

        }

        if (textilesQueue.isEmpty() && medicametsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            if (!items.isEmpty()) {
                printItems(items);
            }
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
            if (!items.isEmpty()) {
                printItems(items);
            }
            System.out.print("Medicaments left: ");
//            while (!medicametsStack.isEmpty()){
//                reversedMedicaments.push(medicametsStack.pop());
//            }
            System.out.println(String.join(", ", medicametsStack.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Medicaments are empty.");
            if (!items.isEmpty()) {
                printItems(items);
            }
            System.out.print("Textiles left: ");
            System.out.println(String.join(", ", textilesQueue.toString().replaceAll("[\\[\\]]", "")));
        }

    }


    public static void printItems(Map<String, Integer> items) {
        items.entrySet()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}
