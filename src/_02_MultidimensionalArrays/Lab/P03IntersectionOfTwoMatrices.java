package _02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        readCharMatrix(scanner, firstMatrix);
        readCharMatrix(scanner, secondMatrix);

        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    resultMatrix[row][col] = '*';
                } else {
                    resultMatrix[row][col] = firstMatrix[row][col];
                }
            }
        }
        System.out.println();
        for (char[] charArr : resultMatrix) {
            for (char symbol : charArr) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    private static void readCharMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
    }
}