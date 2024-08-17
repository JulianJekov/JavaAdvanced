package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class BookWorm {
    private static int startRow;
    private static int startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            int currentRow = startRow;
            int currentCol = startCol;
            if ("up".equals(command)) {
                startRow--;
            } else if ("down".equals(command)) {
                startRow++;
            } else if ("left".equals(command)) {
                startCol--;
            } else if ("right".equals(command)) {
                startCol++;
            }
            if (inBounds(size, startRow, startCol)) {
                char letter = matrix[startRow][startCol];
                if (Character.isLetter(letter)) {
                    sb.append(letter);
                }
                matrix[startRow][startCol] = 'P';
                matrix[currentRow][currentCol] = '-';
            } else {
                sb.delete(sb.length() - 1, sb.length());
                //sb.deleteCharAt(sb.length() -1);
                startRow = currentRow;
                startCol = currentCol;
            }
            command = scanner.nextLine();
        }
        System.out.println(sb);
        printMatrix(matrix);
    }

    private static boolean inBounds(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("P")) {
                startRow = r;
                startCol = line.indexOf("P");
            }
        }
    }
}
