package _03_SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> performers = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(\\D+)\\s@(\\D+)\\s(\\d+)\\s(\\d+)");
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group(1).trim();
                String venue = matcher.group(2).trim();
                int price = Integer.parseInt(matcher.group(3));
                int count = Integer.parseInt(matcher.group(4));

                if (!performers.containsKey(venue)) {
                    performers.put(venue, new LinkedHashMap<>());
                }
                if (!performers.get(venue).containsKey(singer)) {
                    performers.get(venue).put(singer, 0);
                }
                performers.get(venue).put(singer, performers.get(venue).get(singer) + price * count);
            }
            input = scanner.nextLine();
        }

        performers.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet()
                    .stream()
                    .sorted((first, second) -> second.getValue() - first.getValue())
                    .forEach(innerEntry ->
                            System.out.printf("#  %s -> %d%n", innerEntry.getKey(), innerEntry.getValue()));
        });
    }
}
