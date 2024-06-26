package _04_StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("src/_04_StreamsFilesAndDirectories/Exercise/ExResources/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();

        directories.offer(folder);

        int sumOfBytes = 0;
        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] files = current.listFiles();

            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += (int) file.length();
                }
            }

        }

        System.out.println(sumOfBytes);
    }
}
