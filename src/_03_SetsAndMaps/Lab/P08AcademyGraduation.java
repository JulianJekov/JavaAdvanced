package _03_SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradesByStudents = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            List<Double> grades = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            gradesByStudents.put(name, grades);
        }
        for (Map.Entry<String, List<Double>> entry : gradesByStudents.entrySet()) {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();

            double gradeSum = 0;
            for (Double grade : grades) {
                gradeSum += grade;
            }
            double average = gradeSum / grades.size();

            System.out.printf("%s is graduated with %s%n", name,average);

        }
    }
}
