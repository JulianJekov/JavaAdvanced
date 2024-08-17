package _03_SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduationAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Double> gradeByStudents = new TreeMap<>();
        while (n-- >0){
            String name = scanner.nextLine();

            double grade = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average().orElse(0);

            gradeByStudents.put(name,grade);
        }
        gradeByStudents.forEach((key, value) -> System.out.printf("%s is graduated with %s%n", key, value));
    }
}
