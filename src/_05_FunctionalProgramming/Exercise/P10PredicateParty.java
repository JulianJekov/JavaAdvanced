package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();


        while (!command.equals("Party!")) {

            String[] commandData = command.split("\\s+");

            String commandName = commandData[0];

            Predicate<String> predicate = getPredicate(commandData[1], commandData[2]);

            List<String> temp = new ArrayList<>();

            names.forEach(n -> {
                if (predicate.test(n)) {
                    temp.add(n);
                }
            });

            if (commandName.startsWith("Remove")) {
                names.removeAll(temp);
            } else {
                names.addAll(temp);
            }
            command = scanner.nextLine();
        }

        if (!names.isEmpty()) {
            System.out.println(names.stream().
                    sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {

        Predicate<String> predicate = null;

        switch (type) {
            case "StartsWith":
                predicate = word -> word.startsWith(parameter);
                break;
            case "EndsWith":
                predicate = word -> word.endsWith(parameter);
                break;
            case "Length":
                predicate = word -> word.length() == Integer.parseInt(parameter);
                break;

        }

        return predicate;
    }
}
