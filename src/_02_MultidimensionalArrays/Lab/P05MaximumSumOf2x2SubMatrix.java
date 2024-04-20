package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsColsSize = readArray(scanner);
        int rows = rowsColsSize[0];
        int cols = rowsColsSize[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] maxSumMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(maxSum < sum){
                    maxSum = sum;
                    maxSumMatrix[0][0] = matrix[row][col];
                    maxSumMatrix[0][1] = matrix[row][col + 1];
                    maxSumMatrix[1][0] = matrix[row + 1][col];
                    maxSumMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int[] sumMatrix : maxSumMatrix) {
            for (int number : sumMatrix) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
