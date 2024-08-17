package _00_ExamPrep.P02ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        List<String> directions = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        char[][] matrix = new char[size][size];
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("s")) {
                startRow = row;
                startCol = line.indexOf("s");
            }
        }
        int hazelnuts = 0;
        boolean allHazelnutsEaten = false;

        for (int i = 0; i < directions.size(); i++) {
            String direction = directions.get(i);
            matrix[startRow][startCol] = '*';

            switch (direction) {
                case "left":
                    startCol--;
                    break;
                case "right":
                    startCol++;
                    break;
                case "up":
                    startRow--;
                    break;
                case "down":
                    startRow++;
                    break;
            }
            if (isOnBounds(matrix, startRow, startCol)) {
                if (matrix[startRow][startCol] == 't') {
                    matrix[startRow][startCol] = '*';
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    System.out.println("Hazelnuts collected: " + hazelnuts);
                    return;
                } else if (matrix[startRow][startCol] == 'h'){
                    hazelnuts++;
                    matrix[startRow][startCol] = '*';
                }
            } else {
                System.out.println("The squirrel is out of the field.");
                System.out.println("Hazelnuts collected: " + hazelnuts);
                return;
            }
            if(hazelnuts == 3) {
                allHazelnutsEaten = true;
                break;
            }
        }
        if(allHazelnutsEaten) {
            System.out.println("Good job! You have collected all hazelnuts!");
        }else {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.println("Hazelnuts collected: " + hazelnuts);
    }

    private static boolean isOnBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
