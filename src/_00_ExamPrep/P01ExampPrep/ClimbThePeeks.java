package _00_ExamPrep.P01ExampPrep;

import java.util.*;

public class ClimbThePeeks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> peeks = new ArrayDeque<>();
        peeks.offer("Vihren");
        peeks.offer("Kutelo");
        peeks.offer("Banski Suhodol");
        peeks.offer("Polezhan");
        peeks.offer("Kamenitza");


        Map<String, Integer> peeksWithDifficulty = new LinkedHashMap<>();
              peeksWithDifficulty.put("Vihren", 80);
              peeksWithDifficulty.put("Kutelo", 90);
              peeksWithDifficulty.put("Banski Suhodol", 100);
              peeksWithDifficulty.put("Polezhan", 60);
              peeksWithDifficulty.put("Kamenitza", 70);

        List<String> conqueredPeeks = new ArrayList<>();

        ArrayDeque<Integer> food = new ArrayDeque<>();
        String[] arrFood = (scanner.nextLine().split(", "));
        for (String s : arrFood) {
            food.push(Integer.parseInt(s));
        }

        ArrayDeque<Integer> stamina = new ArrayDeque<>();
        String[] arrStam = scanner.nextLine().split(", ");
        for (String s : arrStam) {
            stamina.offer(Integer.parseInt(s));
        }
//        ArrayDeque<Integer> food = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt)
//                .collect(Collectors.toCollection(ArrayDeque::new));
//
//        ArrayDeque<Integer> stamina = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt)
//                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println();
        while (!food.isEmpty() && !stamina.isEmpty() && !peeks.isEmpty()) {

            String currentPeek = peeks.peek();
            int sum = food.pop() + stamina.poll();
            if (sum >= peeksWithDifficulty.get(currentPeek)) {
                peeks.poll();
                conqueredPeeks.add(currentPeek);
            }
        }
        if (peeks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeeks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peek : conqueredPeeks) {
                System.out.println(peek);
            }
        }
    }
}
