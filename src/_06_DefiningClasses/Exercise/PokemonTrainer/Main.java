package _06_DefiningClasses.Exercise.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Pokemon>> pokemons = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {

            String[] inputData = input.split("\\s+");

            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            pokemons.putIfAbsent(trainerName, new ArrayList<>());
            pokemons.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }
        System.out.println();
        List<Trainer> trainers = pokemons
                .entrySet()
                .stream()
                .map(trainer -> new Trainer(trainer.getKey(), trainer.getValue()))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainers) {
                trainer.commandExecuting(command);
            }
            command = scanner.nextLine();
        }

        trainers
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                //.sorted((f,s)-> Integer.compare(s.getNumberOfBadges(),f.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}
