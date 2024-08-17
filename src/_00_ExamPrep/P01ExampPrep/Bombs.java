package _00_ExamPrep.P01ExampPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(bombCasingsStack::push);

        Map<String, Integer> bombs = new TreeMap<>(Map.of(
                "Datura Bombs", 0,
                "Cherry Bombs", 0,
                "Smoke Decoy Bombs", 0
        ));


        boolean filledBombPouch = false;

        while (!bombCasingsStack.isEmpty() && !bombEffectsQue.isEmpty()) {

            int firstBombEffect = bombEffectsQue.peek();
            int lastBombCasing = bombCasingsStack.peek();
            int sum = firstBombEffect + lastBombCasing;

            String madeBomb;

            if (sum == 40) {
                madeBomb = "Datura Bombs";
            } else if (sum == 60) {
                madeBomb = "Cherry Bombs";
            } else if (sum == 120) {
                madeBomb = "Smoke Decoy Bombs";
            } else {
                madeBomb = null;
            }

            if (madeBomb != null) {
                bombs.put(madeBomb, bombs.get(madeBomb) + 1);
                bombEffectsQue.poll();
                bombCasingsStack.pop();
            } else {
                bombCasingsStack.pop();
                bombCasingsStack.push(lastBombCasing - 5);
            }
            int count = (int) bombs.entrySet().stream().filter(b->b.getValue() >= 3).count();
            if(count == 3){
                filledBombPouch = true;
                break;
            }
        }
        if (filledBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.println(bombEffectsQue.isEmpty() ? "Bomb Effects: empty"
                :"Bomb Effects: " + bombEffectsQue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(bombCasingsStack.isEmpty() ? "Bomb Casings: empty"
                :"Bomb Casings: " + bombCasingsStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        bombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
