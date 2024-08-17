package _03_SetsAndMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {

            String[] inputData = input.split("-");

            String name = inputData[0];

            String number = inputData[1];

            phoneBook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {

            if (phoneBook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phoneBook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = scanner.nextLine();
        }
    }
}
