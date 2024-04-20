package _07_Generics.Exercise.P07to08CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] data = command.split(" ");
            String commandName = data[0];
            switch (commandName) {
                case "Add":
                    String element = data[1];
                    list.add(element);
                    break;
                case "Remove":
                    //FIXME: maybe
                    int indexToRemove = Integer.parseInt(data[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String containsElement = data[1];
                    System.out.println(list.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String countGreaterElements = data[1];
                    System.out.println(list.countGreaterThan(countGreaterElements));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
