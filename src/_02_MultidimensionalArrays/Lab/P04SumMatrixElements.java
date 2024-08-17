package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsColsSize = readArray(scanner);
        int rows = rowsColsSize[0];
        int cols = rowsColsSize[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }
        int sumOfAllNumbers = 0;
        for (int[] col : matrix) {
            for (int number : col) {
                sumOfAllNumbers += number;
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sumOfAllNumbers);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
