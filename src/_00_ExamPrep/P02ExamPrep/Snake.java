package _00_ExamPrep.P02ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
    private static int startRow;
    private static int startCol;
    private static int foodQuantity;
    private static boolean inTheMatrix = true;
    private static List<Integer> lair = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);

        while (foodQuantity < 10) {
            String command = scanner.nextLine();
            snakeMove(matrix, command, size);
            if (!inTheMatrix) {
                break;
            }
        }
        if (!inTheMatrix) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodQuantity);
        printMatrix(matrix);
    }

    private static void snakeMove(char[][] matrix, String command, int size) {

        int lastRow = startRow;
        int lastCol = startCol;

        if ("up".equals(command)) {
            startRow--;
        } else if ("down".equals(command)) {
            startRow++;
        } else if ("left".equals(command)) {
            startCol--;
        } else if ("right".equals(command)) {
            startCol++;
        }

        if (!inBounds(size, startRow, startCol)) {
            matrix[lastRow][lastCol] = '.';
            inTheMatrix = false;
            return;
        }
        if (matrix[startRow][startCol] == '*') {
            foodQuantity++;
        } else if (matrix[startRow][startCol] == 'B') {
            matrix[lair.get(0)][lair.get(1)] = '.';
            matrix[lair.get(2)][lair.get(3)] = '.';
            startRow = lair.get(2);
            startCol = lair.get(3);
        }
        matrix[lastRow][lastCol] = '.';
        matrix[startRow][startCol] = 'S';
    }

    private static boolean inBounds(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("S")) {
                startRow = r;
                startCol = line.indexOf("S");
            }
            if (line.contains("B")) {
                lair.add(r);
                lair.add(line.indexOf("B"));
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
