package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsColsSize = readArray(scanner);

        int rows = rowsColsSize[0];
        int cols = rowsColsSize[1];

        int[][] firstMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = readArray(scanner);
        }
        rowsColsSize = readArray(scanner);

        rows = rowsColsSize[0];
        cols = rowsColsSize[1];

        int[][] secondMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = readArray(scanner);
        }

        boolean areEquals = areEquals(firstMatrix, secondMatrix);

        System.out.println(areEquals ? "equal" : "not equal");
    }

    private static boolean areEquals(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {

            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
