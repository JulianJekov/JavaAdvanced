package _02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] dimensions = Arrays.stream(scanner.nextLine()
//                .split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();

        int[][] firstMatrix = new int[arraysCount][sizeOfArray];

        for (int row = 0; row < arraysCount; row++) {
            for (int col = 0; col < sizeOfArray; col++) {
                firstMatrix[row][col] = scanner.nextInt();
            }
        }
        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondMatrix = new int[arraysCount][sizeOfArray];

        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                secondMatrix[row][col] = scanner.nextInt();
            }
        }

        boolean areEqual = firstMatrix.length == secondMatrix.length
           && areArraysEqual(firstMatrix, secondMatrix);


        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean areArraysEqual(int[][] firstMatrix, int[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {

            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int i = 0; i < firstArr.length; i++) {
                int firstNumber = firstArr[i];
                int secondNumber = secondArr[i];
                if (firstNumber != secondNumber) {
                   return  false;
                }
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void printWithForEach(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
