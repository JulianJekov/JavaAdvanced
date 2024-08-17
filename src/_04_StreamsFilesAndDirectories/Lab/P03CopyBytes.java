package _04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {


        String path = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("src/_04_StreamsFilesAndDirectories/Lab/resources/03.CopyBytesOutput.txt");

        int bytes = inputStream.read();

        while (bytes != -1) {
            if(bytes == 10 || bytes == 32){
                outputStream.write(bytes);
            }else{
                String digits = String.valueOf(bytes);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            bytes = inputStream.read();
        }
    }
}
