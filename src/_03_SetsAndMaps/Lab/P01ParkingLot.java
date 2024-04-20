package _03_SetsAndMaps.Lab;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> set = new LinkedHashSet<>();
        while (!input.equals("END")) {

            String[] info = input.split(", ");

            String command = info[0];
            String registration = info[1];

            if (command.equals("IN")) {
                set.add(registration);
            } else {
                set.remove(registration);
            }

            input = scanner.nextLine();
        }

           // System.out.println(set.isEmpty() ? "Parking Lot is Empty" : String.join(System.lineSeparator(), set));
        String output = set.isEmpty() ? "Parking Lot is Empty" : String.join(System.lineSeparator(), set);
        System.out.println(output);
    }
}
