package _00_ExamPrep.P02ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rowSize = rowAndCol[0];
        int colSize = rowAndCol[1];

        char[][] matrix = new char[rowSize][colSize];

        int playerRow = -1;
        int playerCol = -1;

        int playerMovesCount = 0;
        int touchedOpponents = 0;

        for (int row = 0; row < rowSize; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < colSize; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (matrix[row][col] == 'B') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("Finish") && touchedOpponents < 3) {

            int currentRow = playerRow;
            int currentCol = playerCol;

            if (command.equals("up")) {
                playerRow--;
            } else if (command.equals("down")) {
                playerRow++;
            } else if (command.equals("left")) {
                playerCol--;
            } else if (command.equals("right")) {
                playerCol++;
            }

            if (!isOnBounds(matrix, playerRow, playerCol) ||
                    (isOnBounds(matrix, playerRow, playerCol) && matrix[playerRow][playerCol] == 'O')) {
                playerRow = currentRow;
                playerCol = currentCol;
                command = scanner.nextLine();
                continue;
            } else {
                playerMovesCount++;
                matrix[currentRow][currentCol] = '-';
                if (matrix[playerRow][playerCol] == 'P') {
                    touchedOpponents++;
                }
                matrix[playerRow][playerCol] = 'B';
            }

            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", touchedOpponents, playerMovesCount);

        // printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean isOnBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
