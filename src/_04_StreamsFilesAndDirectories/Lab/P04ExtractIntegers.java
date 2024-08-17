package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("src/_04_StreamsFilesAndDirectories/Lab/resources/04.ExtractIntegersOutput.txt");
        PrintWriter outWriter = new PrintWriter(outputStream);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
               outWriter.println((scanner.nextInt()));
            }else{
                scanner.next();
            }
        }
        outWriter.close();
    }
}
