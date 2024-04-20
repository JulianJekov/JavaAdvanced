package _02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
        int[] indexes = readArray(scanner);

        List<int[]> correctValues = new ArrayList<>();

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == valueToReplace){
                    int correctValue = getNearbySum(matrix, row, col, valueToReplace);
                    correctValues.add(new int[]{row,col,correctValue});
                }
            }
        }
        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int row, int col, int valueToreplace) {

        int sum = 0;
        if(isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != valueToreplace){
            sum+= matrix[row + 1][col];
        }
        if(isInBounds(row -1, col, matrix) && matrix[row - 1][col] != valueToreplace){
            sum+= matrix[row - 1][col];
        }
        if(isInBounds(row,col+1,matrix) && matrix[row][col + 1] != valueToreplace){
            sum+= matrix[row][col + 1];
        }
        if(isInBounds(row,col -1,matrix) && matrix[row][col - 1] != valueToreplace){
            sum+= matrix[row][col - 1];
        }

        return sum;
    }

    private static boolean isInBounds(int row, int col, int[][]matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    private static boolean isOutOfBounds(int row, int col, int[][]matrix){
        return !isInBounds(row,col,matrix);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
