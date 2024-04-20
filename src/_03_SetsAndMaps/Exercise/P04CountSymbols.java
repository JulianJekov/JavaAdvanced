package _03_SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character,Integer> countEachChar = new TreeMap<>();
        String input = scanner.nextLine();

        for (char s : input.toCharArray()) {
            countEachChar.putIfAbsent(s, 0);
            countEachChar.put(s, countEachChar.get(s) + 1);
        }

        countEachChar
                .forEach((key,value)->
                        System.out.printf("%s: %d time/s%n",key,value));

    }
}
