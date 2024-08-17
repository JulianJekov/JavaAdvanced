package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String commands = scanner.nextLine();

        while (!commands.equals("END")) {
            String[] commandData = commands.split("\\s+");

            if (isCommandValid(commands, matrix, cols)) {

                int row1 = Integer.parseInt(commandData[1]);
                int col1 = Integer.parseInt(commandData[2]);
                int row2 = Integer.parseInt(commandData[3]);
                int col2 = Integer.parseInt(commandData[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            commands = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String string : arr) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static boolean isCommandValid(String commands, String[][] matrix, int cols) {
        String[] commandData = commands.split("\\s+");
        String command = commandData[0];
        if (!command.equals("swap")) {
            return false;
        }
        if (commandData.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(commandData[1]);
        int col1 = Integer.parseInt(commandData[2]);
        int row2 = Integer.parseInt(commandData[3]);
        int col2 = Integer.parseInt(commandData[4]);

        if (row1 < 0 || row1 >= matrix.length || col1 < 0 || col1 >= cols ||
                row2 < 0 || row2 >= matrix.length || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }
}
