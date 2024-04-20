package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/output.txt"));
        BufferedReader br = new BufferedReader(new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/input.txt"));

        br.lines().forEach(line -> pw.println(line.toUpperCase()));

        pw.close();
        br.close();
    }
}
