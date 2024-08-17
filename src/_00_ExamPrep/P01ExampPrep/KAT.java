package _00_ExamPrep.P01ExampPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> licenses = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Long> cars = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        long daysCount = 0;
        long carsCount = 0;

        while (!licenses.isEmpty() && !cars.isEmpty()) {
            daysCount++;

            long currentLicenses = licenses.getFirst();
            long currentCars = cars.getLast();

            if (currentLicenses / 2 > currentCars) {
                carsCount += currentCars;
                cars.removeLast();
                licenses.removeFirst();
                licenses.addLast(currentLicenses - (currentCars * 2));
            } else if (currentLicenses / 2 < currentCars) {
                carsCount += currentLicenses / 2;
                licenses.removeFirst();
                cars.removeLast();
                cars.addFirst(currentCars - currentLicenses / 2);
            }else{
                carsCount += currentCars;
                licenses.removeFirst();
                cars.removeLast();
            }

        }
        System.out.printf("%d cars were registered for %d days!%n", carsCount, daysCount);

        if (!licenses.isEmpty()) {
            long remain = licenses.stream().mapToLong(Long::longValue).sum();
            System.out.printf("%d license plates remain!%n", remain);

        } else if (!cars.isEmpty()) {
            long remain = cars.stream().mapToLong(Long::longValue).sum();
            System.out.printf("%d cars remain without license plates!%n", remain);

        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
