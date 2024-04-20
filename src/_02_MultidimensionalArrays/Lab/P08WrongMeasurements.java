package _02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }
        int[] indexes = readArray(scanner);

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        List<int[]> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == valueToReplace) {
                    int correctValue = replacedValue(matrix, row, col, valueToReplace);
                    correctValues.add(new int[]{row, col, correctValue});
                }
            }
        }
        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }
        for (int[] intArr : matrix) {
            for (int number : intArr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int replacedValue(int[][] matrix, int row, int col, int valueToReplace) {
        int sum = 0;
        if (isValidIndex(row + 1, col, matrix) && matrix[row + 1][col] != valueToReplace) {
            sum += matrix[row + 1][col];
        }
        if (isValidIndex(row - 1, col, matrix) && matrix[row - 1][col] != valueToReplace) {
            sum += matrix[row - 1][col];
        }
        if (isValidIndex(row, col - 1, matrix) && matrix[row][col - 1] != valueToReplace) {
            sum += matrix[row][col - 1];
        }
        if (isValidIndex(row, col + 1, matrix) && matrix[row][col + 1] != valueToReplace) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static boolean isValidIndex(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
