package _07_Generics.Exercise.P01to06GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double data = Double.parseDouble(scanner.nextLine());
            box.add(data);
        }
        Double element = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countOfGreaterItems(element));

    }
}
