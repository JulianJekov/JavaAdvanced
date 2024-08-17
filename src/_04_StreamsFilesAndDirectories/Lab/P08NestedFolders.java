package _04_StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) {
        File folder = new File("src/_04_StreamsFilesAndDirectories/Lab/resources/Files-and-Streams");

        ArrayDeque<File> directory = new ArrayDeque<>();
        directory.offer(folder);
        assert directory.peek() != null;
        System.out.println(directory.peek().getName());
        int countFolders = 1;
        while (!directory.isEmpty()) {
            File current = directory.poll();
            File[] files = current.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    countFolders++;
                    System.out.println(file.getName());
                    directory.offer(file);
                }
            }
        }
        System.out.println(countFolders + " folders");

    }
}
