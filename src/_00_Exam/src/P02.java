package _00_Exam.src;

import java.util.Arrays;
import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[size[0]][size[1]];

        int mouseRow = -1;
        int mouseCol = -1;
        int cheese = 0;

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = row;
                mouseCol = line.indexOf("M");
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    cheese++;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isTraped = false;
        while (!"danger".equals(command)) {
            int lastRow = mouseRow;
            int lastCol = mouseCol;

            matrix[mouseRow][mouseCol] = '*';
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "right":
                    mouseCol++;
                    break;
                case "left":
                    mouseCol--;
                    break;
            }
            if (!isInBounds(matrix, mouseRow, mouseCol)) {
                matrix[lastRow][lastCol] = 'M';
                System.out.println("No more cheese for tonight!");
                break;
            } else {
                if (matrix[mouseRow][mouseCol] == 'C') {
                    cheese--;
                    matrix[mouseRow][mouseCol] = 'M';
                } else if (matrix[mouseRow][mouseCol] == '@') {
                    matrix[lastRow][lastCol] = 'M';
                    mouseRow = lastRow;
                    mouseCol = lastCol;
                } else if (matrix[mouseRow][mouseCol] == 'T') {
                    isTraped = true;
                    matrix[mouseRow][mouseCol] = 'M';
                    System.out.println("Mouse is trapped!");
                    break;
                }
            }
            if (cheese == 0) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                break;
            }
            command = scanner.nextLine();
        }
        if (cheese > 0 && isInBounds(matrix,mouseRow,mouseCol) && !isTraped) {
            matrix[mouseRow][mouseCol] = 'M';
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    public static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
