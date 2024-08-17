package _00_ExamPrep.P02ExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                if(col < line.length) {
                    matrix[row][col] = line[col];
                }else {
                    matrix[row][col] = "-";
                }
                if (matrix[row][col].equals("Y")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        List<String> rightDirections = new ArrayList<>();

        while (!command.equals("Finish")) {

            int currentRow = playerRow;
            int currentCol = playerCol;

            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if (!isInBounds(matrix, playerRow, playerCol)) {
                playerRow = currentRow;
                playerCol = currentCol;
                command = scanner.nextLine();
                continue;
            } else {
                if (matrix[playerRow][playerCol].equals("T")) {
                    playerRow = currentRow;
                    playerCol = currentCol;
                    command = scanner.nextLine();
                    continue;
                } else {
                    rightDirections.add(command);
                }
            }

            command = scanner.nextLine();
        }
        if (matrix[playerRow][playerCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ", rightDirections));
        } else {
            System.out.println("The map is fake!");
        }

    }

    public static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
