package _08_IteratorsAndComparators.Exercise.P01ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator listyIterator = null;
        while (!input.equals("END")){
            String[] commandParts = input.split(" ");
            String commandName = commandParts[0];

            switch (commandName){
                case"Create":
//                    String[] elementArray = new String[commandParts.length - 1];
//                    for (int i = 1; i < commandParts.length ; i++) {
//                        elementArray[i - 1] = commandParts[i];
//                    }
//                    listyIterator = new ListyIterator(elementArray);
                    if(commandParts.length > 1) {
                        String[] elementArray = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                        listyIterator = new ListyIterator(elementArray);
                    }else{
                        listyIterator = new ListyIterator();
                    }
                    break;
                case"Move":
                    System.out.println(listyIterator.move());
                    break;
                case"HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case"Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
