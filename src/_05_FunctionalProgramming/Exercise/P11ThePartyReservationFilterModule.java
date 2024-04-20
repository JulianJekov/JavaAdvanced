package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        Set<String> filters = new HashSet<>();

        while (!command.equals("Print")) {

            String[] commandData = command.split(";");

            if(commandData[0].contains("Add")){
                filters.add(commandData[1] + ";" + commandData[2]);
            }else{
                filters.remove(commandData[1] + ";" + commandData[2]);
            }

            command = scanner.nextLine();
        }
        filters.forEach(filter ->{
            Predicate<String> predicate = getPredicate(filter);
            names.removeIf(predicate);
            });
        names.forEach(n -> System.out.print(n + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        Predicate<String> predicate = null;
        String[] data = filter.split(";");
        String parameter = data[1];

        switch (data[0]){
            case "Starts with":
                predicate = word -> word.startsWith(parameter);
                break;
            case "Ends with":
                predicate = word -> word.endsWith(parameter);
                break;
            case "Length":
                predicate = word -> word.length() == Integer.parseInt(parameter);
                break;
            case"Contains":
                predicate = word -> word.contains(parameter);
                break;
        }
        return predicate;
    }
}
