package _02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessMatrix = new char[8][8];
        readCharMatrix(scanner, chessMatrix);

        for (int row = 0; row < chessMatrix.length; row++) {
            for (int col = 0; col < chessMatrix[row].length; col++) {
                if (chessMatrix[row][col] == 'q' && isValidQueen(chessMatrix, row, col))
                    System.out.println(row + " " + col);
            }
        }

    }

    private static boolean isValidQueen(char[][] matrix, int row, int col) {

        for (int rowDirection = -1; rowDirection <= 1; rowDirection++) {
            for (int colDirection = -1; colDirection <= 1; colDirection++) {
                if (rowDirection == 0 && colDirection == 0) {
                    continue;
                }
                int currentRow = row + rowDirection;
                int currentCol = col + colDirection;

                while (isValidPosition(matrix, currentRow, currentCol)) {
                    if (matrix[currentRow][currentCol] == 'q') {
                        return false;
                    }
                    currentRow += rowDirection;
                    currentCol += colDirection;
                }
            }
        }

        return true;
    }

    private static boolean isValidPosition(char[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

    private static void readCharMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
    }
}
