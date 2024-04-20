package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class Bee {
    private static int row;
    private static int col;
    private static boolean isInTerritory = true;
    private static int pollinatedFlowers = 0;
    private static final int neededFlowers = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            move(command, size, matrix);
            if (!isInTerritory) {
                break;
            }
            command = scanner.nextLine();
        }
        if (!isInTerritory) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        } else {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (neededFlowers - pollinatedFlowers) + " flowers more");
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("B")) {
                row = r;
                col = line.indexOf("B");
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean inTheMatrix(int size, int beeStartRow, int beeStartCol) {
        return beeStartRow >= 0 && beeStartRow < size && beeStartCol >= 0 && beeStartCol < size;
    }

    private static void move(String command, int size, char[][] matrix) {

        int currentRow = row;
        int currentCol = col;
        boolean isBonusHit = false;
        if ("up".equals(command)) {
            row--;
        } else if ("down".equals(command)) {
            row++;
        } else if ("left".equals(command)) {
            col--;
        } else if ("right".equals(command)) {
            col++;
        }

        if (!inTheMatrix(size, row, col)) {
            matrix[currentRow][currentCol] = '.';
            isInTerritory = false;
            return;
        }

        if (matrix[row][col] == 'f') {
            pollinatedFlowers++;
        } else if (matrix[row][col] == 'O') {
            isBonusHit = true;
        }

        matrix[currentRow][currentCol] = '.';
        matrix[row][col] = 'B';
        if (isBonusHit) {
            move(command, size, matrix);
        }
    }
}

