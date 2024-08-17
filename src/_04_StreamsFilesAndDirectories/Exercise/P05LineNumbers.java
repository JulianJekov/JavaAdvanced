package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/output.txt"));

        String line = br.readLine();
        int countLines = 1;
        while (line != null){

            pw.println(countLines + ". " + line);
            countLines++;
            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
