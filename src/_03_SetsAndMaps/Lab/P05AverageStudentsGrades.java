package _03_SetsAndMaps.Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsData = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String studentName = data[0];
            double grade = Double.parseDouble(data[1]);
            if(!studentsData.containsKey(studentName)){
                studentsData.put(studentName,new ArrayList<>());
            }
            studentsData.get(studentName).add(grade);
        }
        studentsData.entrySet().stream().forEach(entry->{
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum+=entry.getValue().get(i);
            }
            double average = sum / entry.getValue().size();
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(e-> System.out.printf("%.2f ",e));
            System.out.printf("(avg: %.2f)%n",average);
        });
    }
}
