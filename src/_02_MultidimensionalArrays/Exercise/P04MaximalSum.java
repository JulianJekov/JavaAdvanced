package _02_MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int currentRow = row; currentRow < row + 3 ; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3 ; currentCol++) {
                      sum+= matrix[currentRow][currentCol];
                    }
                }
                if(sum > bestSum){
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        for (int row = bestRow; row < bestRow + 3  ; row++) {
            for (int col = bestCol; col < bestCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
