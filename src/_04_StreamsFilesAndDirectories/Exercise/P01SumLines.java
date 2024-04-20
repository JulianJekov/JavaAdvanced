package _04_StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/input.txt"));

        String line = bufferedReader.readLine();


        while (line != null){

            int sum = 0;

            char[] charactersFromLine = line.toCharArray();

            for (char character : charactersFromLine) {
                sum+= character;
            }
            System.out.println(sum);

            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
