package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class ReVolt {
    private static int startRow;
    private static int startCol;
    private static boolean isFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scanner, size, matrix);
        matrix[startRow][startCol] = '-';
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();

            move(matrix,command,size);
            if (isFinish) {
                System.out.println("Player won!");
                printMatrix(matrix);
                return;
            }
        }
        matrix[startRow][startCol] = 'f';
        System.out.println("Player lost!");
        printMatrix(matrix);
    }

    private static void move(char[][] matrix, String command, int size) {

        int lastRow = startRow;
        int lastCol = startCol;

        if ("up".equals(command)) {
            if (startRow != 0) {
                startRow--;
            } else {
                startRow = size - 1;
            }
        } else if ("down".equals(command)) {
            if (startRow != size - 1) {
                startRow++;
            } else {
                startRow = 0;
            }
        } else if ("left".equals(command)) {
            if (startCol != 0) {
                startCol--;
            } else {
                startCol = size - 1;
            }
        } else if ("right".equals(command)) {
            if (startCol != size - 1) {
                startCol++;
            } else {
                startCol = 0;
            }
        }

        if (matrix[startRow][startCol] == 'B') {
            move(matrix, command, size);
        } else if (matrix[startRow][startCol] == 'T') {
            startRow = lastRow;
            startCol = lastCol;
        } else if (matrix[startRow][startCol] == 'F') {
            matrix[startRow][startCol] = 'f';
            isFinish = true;
        }else {
            matrix[startRow][startCol] = '-';
        }
    }

    private static boolean inBounds(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("f")) {
                startRow = r;
                startCol = line.indexOf("f");
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

