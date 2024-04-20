package _02_MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotation = scanner.nextLine().split("[()]");

        int rotationNumber = Integer.parseInt(rotation[1]);
        int angleOfRotation = rotationNumber % 360;

        String input = scanner.nextLine();

        List<String> inputList = new ArrayList<>();

        int maxInputLength = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            inputList.add(input);

            if (input.length() > maxInputLength) {
                maxInputLength = input.length();
            }
            input = scanner.nextLine();
        }
        int rows = inputList.size();
        int cols = maxInputLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < inputList.get(row).length()) {
                    matrix[row][col] = inputList.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
