package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char outsideLetter = ((char) ('a' + row));
                char middleLetter = ((char) ('a' + col + row));
                matrix[row][col] = "" + outsideLetter + middleLetter + outsideLetter;
            }
        }
        for (String[] arr : matrix) {
            for (String letters : arr) {
                System.out.print(letters + " ");
            }
            System.out.println();
        }
    }
}
