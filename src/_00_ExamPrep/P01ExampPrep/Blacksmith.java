package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrSteel = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        for (String steel : arrSteel) {
            steelQueue.offer(Integer.parseInt(steel));
        }

        String[] arrCarbon = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (String carbon : arrCarbon) {
            carbonStack.push(Integer.parseInt(carbon));
        }

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        int totalMadeSwords = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int currentSteel = steelQueue.peek();
            int currentCarbon = carbonStack.peek();

            int sum = steelQueue.poll() + carbonStack.pop();
            String madeSword = null;
            switch (sum) {
                case 70:
                    madeSword = "Gladius";
                    break;
                case 80:
                    madeSword = "Shamshir";
                    break;
                case 90:
                    madeSword = "Katana";
                    break;
                case 110:
                    madeSword = "Sabre";
                    break;
            }
            if (madeSword != null) {
                totalMadeSwords++;
                int currentSwordCount = swords.get(madeSword);
                swords.put(madeSword, currentSwordCount + 1);
            } else {
                carbonStack.push(currentCarbon + 5);
            }
        }
        System.out.println(totalMadeSwords > 0 ? String.format("You have forged %d swords.", totalMadeSwords)
                : "You did not have enough resources to forge a sword.");

        System.out.println(steelQueue.isEmpty() ? "Steel left: none" : "Steel left: " +
                String.join(", ", steelQueue.toString().replaceAll("[\\[\\]]", "")));

        System.out.println(carbonStack.isEmpty() ? "Carbon left: none" : "Carbon left: " +
                String.join(", ", carbonStack.toString().replaceAll("[\\[\\]]", "")));

        swords.entrySet()
                .stream()
                .filter(sword -> sword.getValue() > 0)
                .forEach(sword -> System.out.printf("%s: %d%n", sword.getKey(), sword.getValue()));
    }
}
