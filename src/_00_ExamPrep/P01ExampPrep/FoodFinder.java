package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        String[] arrVowels = scanner.nextLine().split(" ");
        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        for (String vowel : arrVowels) {
            vowelsQueue.offer(vowel.charAt(0));
        }

        String[] arrConsonants = scanner.nextLine().split(" ");
        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        for (String consonant : arrConsonants) {
            consonantsStack.push(consonant.charAt(0));
        }

        while (!consonantsStack.isEmpty()) {
            char vowel = vowelsQueue.poll();
            char consonant = consonantsStack.pop();

            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];

                int indexVowel = currentWord.indexOf(vowel);
                int indexConsonant = currentWord.indexOf(consonant);

                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }

                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowelsQueue.offer(vowel);
        }
        List<String> finalWords = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());
        System.out.printf("Words found: %d%n", finalWords.size());
        finalWords.forEach(System.out::println);
    }
}
