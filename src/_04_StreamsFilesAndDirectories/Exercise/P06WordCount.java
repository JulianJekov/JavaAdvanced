package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/words.txt"));

        String[] line = scanner.nextLine().split(" ");
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        for (String word : line) {
            wordsCount.put(word, 0);
        }
        Scanner fileScanner = new Scanner(new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/text.txt"));

        String singleWord = fileScanner.next();

        while (fileScanner.hasNext()){

            if(wordsCount.containsKey(singleWord)){
                int occurance = wordsCount.get(singleWord);
                occurance++;
                wordsCount.put(singleWord,occurance);
            }

            singleWord = fileScanner.next();
        }
        PrintWriter pw = new PrintWriter(new FileWriter("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/result.txt"));
        wordsCount.entrySet()
                .stream()
                .sorted((f,s)->s.getValue() - f.getValue())
                .forEach(entry -> pw.printf("%s - %d%n",entry.getKey(),entry.getValue()));

        fileScanner.close();
        scanner.close();
        pw.close();
    }
}
