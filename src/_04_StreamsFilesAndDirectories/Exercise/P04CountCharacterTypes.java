package _04_StreamsFilesAndDirectories.Exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/input.txt");
        PrintWriter pr = new PrintWriter(new FileWriter("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/output.txt"));

        int vowels = 0;
        int consonats = 0;
        int punctuation = 0;

        int oneByte = fr.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;
            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonats++;
            }
            oneByte = fr.read();
        }
        pr.println("Vowels: " + vowels);
        pr.println("Other symbols: " + consonats);
        pr.println("Punctuation: " + punctuation);
        fr.close();
        pr.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
