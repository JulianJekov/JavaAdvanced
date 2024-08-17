package _00_ExamPrep.P01ExampPrep;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .forEach(materialsStack::push);

        ArrayDeque<Integer> magicLevelQue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presentsPairOne = new TreeMap<>();
        Map<String, Integer> presentsPairTwo = new TreeMap<>();
        Map<String, Integer> bothPairs = new TreeMap<>();
        bothPairs.put("Doll", 0);
        bothPairs.put("Wooden train", 0);
        bothPairs.put("Teddy bear", 0);
        bothPairs.put("Bicycle", 0);

        while (!materialsStack.isEmpty() && !magicLevelQue.isEmpty()) {

            int lastMaterial = materialsStack.peek();
            int firstMagicLevel = magicLevelQue.peek();
            int totalMagic = lastMaterial * firstMagicLevel;

            String craftedPresent;

            if (totalMagic == 150) {
                craftedPresent = "Doll";
                addPresent(presentsPairOne, craftedPresent);
            } else if (totalMagic == 250) {
                craftedPresent = "Wooden train";
                addPresent(presentsPairOne, craftedPresent);
            } else if (totalMagic == 300) {
                craftedPresent = "Teddy bear";
                addPresent(presentsPairTwo, craftedPresent);
            } else if (totalMagic == 400) {
                craftedPresent = "Bicycle";
                addPresent(presentsPairTwo, craftedPresent);
            } else {
                craftedPresent = null;
            }
            if (craftedPresent != null) {
                bothPairs.put(craftedPresent, bothPairs.get(craftedPresent) + 1);
                materialsStack.pop();
                magicLevelQue.poll();
            } else {
                if (lastMaterial == 0 && firstMagicLevel == 0) {
                    materialsStack.pop();
                    magicLevelQue.poll();
                    continue;
                }

                if (lastMaterial == 0) {
                    materialsStack.pop();
                    continue;
                }

                if (firstMagicLevel == 0) {
                    magicLevelQue.poll();
                    continue;
                }

                if (totalMagic < 0) {
                    int sum = lastMaterial + firstMagicLevel;
                    materialsStack.pop();
                    magicLevelQue.poll();
                    materialsStack.push(sum);
                } else if (totalMagic > 0) {
                    magicLevelQue.poll();
                    materialsStack.pop();
                    materialsStack.push(lastMaterial + 15);
                }
            }
        }
        long countFirstPair = presentsPairOne.entrySet().stream()
                .filter(p -> p.getValue() >= 1)
                .count();
        long countSecondPair = presentsPairTwo.entrySet().stream()
                .filter(p -> p.getValue() >= 1)
                .count();
        if (countFirstPair > 1 || countSecondPair > 1) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materialsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!magicLevelQue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicLevelQue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        bothPairs.entrySet().stream()
                .filter(p -> p.getValue() > 0)
                .forEach(p -> System.out.printf("%s: %d%n", p.getKey(), p.getValue()));
    }

    private static void addPresent(Map<String, Integer> presentsPairTwo, String craftedPresent) {
        presentsPairTwo.putIfAbsent(craftedPresent, 0);
        presentsPairTwo.put(craftedPresent, presentsPairTwo.get(craftedPresent) + 1);
    }

}
