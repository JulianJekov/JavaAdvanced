package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);

        int[][] matrix = new int[matrixSize][matrixSize];

        String pattern = input[1];

        int count = 1;
        if(pattern.equals("A")){
            patternA(matrixSize, matrix, count);

        }else{
            patternB(matrixSize, matrix, count);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int matrixSize, int[][] matrix, int count) {
        for (int col = 0; col < matrixSize; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < matrixSize; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            }else{
                for (int row = matrixSize - 1; row >=0 ; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }

    private static void patternA(int matrixSize, int[][] matrix, int count) {
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
