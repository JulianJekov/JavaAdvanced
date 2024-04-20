package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsColsSize = readArray(scanner);

        int rows = rowsColsSize[0];
        int cols = rowsColsSize[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == numberToFind){
                    output.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }
        System.out.println(output.toString().isEmpty() ? "not found" : output);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
