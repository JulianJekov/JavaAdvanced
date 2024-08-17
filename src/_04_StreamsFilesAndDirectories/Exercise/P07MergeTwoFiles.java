package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

//        BufferedWriter br = new BufferedWriter(new FileWriter("ExResources/output.txt", true));
//        br.append("Hello word");
//        br.append("Hello SoftUni");
//        br.close();
        Path firstFile = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/inputOne.txt");
        List<String> firstFileLines =  Files.readAllLines(firstFile);

        Path secondFile = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/inputTwo.txt");
        List<String> secondFileLines =  Files.readAllLines(secondFile);

        Path output = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/output.txt");
        Files.write(output,firstFileLines, StandardOpenOption.APPEND);
        Files.write(output,secondFileLines, StandardOpenOption.APPEND);
    }
}
