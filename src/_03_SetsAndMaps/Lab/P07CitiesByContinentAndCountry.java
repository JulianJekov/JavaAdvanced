package _03_SetsAndMaps.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if(!continentsMap.containsKey(continent)){
                continentsMap.put(continent,new LinkedHashMap<>());
                continentsMap.get(continent).put(country, new ArrayList<>());

            }
            if(!continentsMap.get(continent).containsKey(country)){
                continentsMap.get(continent).put(country, new ArrayList<>());

            }
            continentsMap.get(continent).get(country).add(city);

        }

        for (Map.Entry<String, Map<String, List<String>>> entry : continentsMap.entrySet()) {
            String continent = entry.getKey();
            Map<String, List<String>> countries = entry.getValue();
            System.out.println(continent + ":");
            countries.forEach((country, city) -> {
                String cities = String.join(", ", city);
                System.out.println("  " + country + " -> " + cities);
            });
        }

    }
}

