package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] directions = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        int startRow = -1;
        int startCol = -1;
        int bombCount = 0;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
            if (line.contains("s")) {
                startRow = row;
                startCol = line.indexOf("s");
            }
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'B') {
                    bombCount++;
                }
            }
        }
        boolean isFinish = false;
        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            int currentRow = startRow;
            int currentCol = startCol;
            switch (direction) {
                case "up":
                    startRow--;
                    break;
                case "down":
                    startRow++;
                    break;
                case "left":
                    startCol--;
                    break;
                case "right":
                    startCol++;
                    break;
            }
            if (!isInBounds(startRow, startCol, size)) {
                startRow = currentRow;
                startCol = currentCol;
            } else {
                if (matrix[startRow][startCol] == 'B') {
                    bombCount--;
                    matrix[startRow][startCol] = '+';
                    System.out.println("You found a bomb!");
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        return;
                    }
                } else if (matrix[startRow][startCol] == 'e') {
                    System.out.println("END! " + bombCount + " bombs left on the field");
                    isFinish = true;
                    return;
                }
            }
        }

        if (bombCount != 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCount, startRow, startCol);
        }

    }

    public static boolean isInBounds(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
