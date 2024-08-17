package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Double> numbers = new ArrayList<>();
        numbers.add(1.5);
        numbers.add(2.5);
        numbers.add(3.5);
        numbers.add(4.5);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/serialization.txt"));

        outputStream.writeObject(numbers);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/serialization.txt"));

        List<Double> list = (List)inputStream.readObject();

        System.out.println(list);
    }

}
