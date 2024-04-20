package _04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream(
                "src/_04_StreamsFilesAndDirectories/Lab/resources/02.WriteToFileOutput.txt");


        int bytes = inputStream.read();

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        while (bytes != - 1){
            char symbol = (char) bytes;

            boolean isPunctuation = punctuationTable.contains(symbol);

            if(!isPunctuation) {
                outputStream.write(symbol);
            }
            bytes = inputStream.read();
        }

    }
}
