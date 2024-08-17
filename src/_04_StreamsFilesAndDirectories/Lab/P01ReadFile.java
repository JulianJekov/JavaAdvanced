package _04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;


public class P01ReadFile {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        String path = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int bytes = fileInputStream.read();

            while (bytes != -1) {
                System.out.print(Integer.toBinaryString(bytes) + " ");
                bytes = fileInputStream.read();
            }
            System.out.println();
        } catch (IOException e) {

        }
    }
}
