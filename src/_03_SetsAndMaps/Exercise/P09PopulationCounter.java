package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Long> countriesPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> citiesPopulation = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String[] inputData = input.split("\\|");
            String country = inputData[1];
            String city = inputData[0];
            long population = Integer.parseInt(inputData[2]);

            if (!countriesPopulation.containsKey(country)) {
                countriesPopulation.put(country, population);
            } else {
                countriesPopulation.put(country, countriesPopulation.get(country) + population);
            }

            if (!citiesPopulation.containsKey(country)) {
                citiesPopulation.put(country, new LinkedHashMap<>());
            }
            citiesPopulation.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countriesPopulation.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(currentCountry -> {
                    System.out.printf("%s (total population: %d)%n", currentCountry.getKey(), currentCountry.getValue());
                    citiesPopulation.get(currentCountry.getKey()).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(city -> {
                                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });

    }
}
