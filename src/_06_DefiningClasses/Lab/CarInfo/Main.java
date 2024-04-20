package _06_DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car;
            if (input.length == 1) {
                car = new Car(input[0]);
            } else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            }
            cars.add(car);
        }
        System.out.println();
        cars.forEach(car -> System.out.println(car.carInfo()));
    }

}
