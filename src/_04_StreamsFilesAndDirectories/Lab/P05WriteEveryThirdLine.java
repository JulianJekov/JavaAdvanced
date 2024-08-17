package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        String outPutPath = "src/_04_StreamsFilesAndDirectories/Lab/resources/05.WriteEveryThirdLineOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outPutPath);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String line = reader.readLine();

        int lineCounter = 1;
        while (line != null){

            if(lineCounter % 3 == 0){
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
            lineCounter++;
        }
        reader.close();
        writer.close();
    }
}
