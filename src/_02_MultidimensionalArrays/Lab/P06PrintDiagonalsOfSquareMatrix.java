package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                if (row == col) {
//                    System.out.print(matrix[row][col] + " ");
//                }
//            }
//        }
//        System.out.println();
//        int count = 0;
//        for (int row = size - 1; row >= 0 ; row--) {
//            for (int col = count; col <= count; col++) {
//                System.out.print(matrix[row][col] + " ");
//
//            }
//            count++;
//        }
        int row = 0;
        int col = 0;

        while (row < matrix.length && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        row = matrix.length - 1;
        col = 0;
        while (row >= 0 && col < matrix[row].length){
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}
