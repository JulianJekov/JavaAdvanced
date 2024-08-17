package _04_StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/_04_StreamsFilesAndDirectories/Lab/resources/input.txt";

        Path path = Paths.get(inputPath);

        //Stream<String> lines = Files.lines(path);


        List<String> lines = Files.lines(path)
                .sorted().collect(Collectors.toList());

        Files.write(Paths.get("src/_04_StreamsFilesAndDirectories/Lab/resources/06.SortLinesOutput.txt"),lines);
    }
}
