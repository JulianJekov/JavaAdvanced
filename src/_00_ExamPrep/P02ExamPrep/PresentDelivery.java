package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class PresentDelivery {

    private static int startRow;
    private static int startCol;
    private static int niceKidsCount;
    private static int countPresents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        countPresents = totalPresents;
        char[][] matrix = new char[size][size];
        fillMatrix(scanner, size, matrix);
        String command = scanner.nextLine();
        boolean isHappy = false;

        while (!command.equals("Christmas morning")) {
            matrix[startRow][startCol] = '-';
            switch (command) {
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

            if (matrix[startRow][startCol] == 'C') {
                isHappy = true;
            } else if (matrix[startRow][startCol] == 'V') {
                niceKidsCount--;
                countPresents--;
            }
            matrix[startRow][startCol] = 'S';

            if(isHappy){
                move(matrix,-1,0);
                move(matrix,1,0);
                move(matrix,0,-1);
                move(matrix,0,1);
            }
            if(countPresents <= 0){
                break;
            }
            command = scanner.nextLine();
        }
        if(countPresents <= 0){
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if(niceKidsCount <= 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n",totalPresents - countPresents);
        }else {
            System.out.printf("No presents for %d nice kid/s.%n",niceKidsCount);
        }
    }

    private static void move(char[][] matrix, int rowMutator, int colMutator){
        int nextRow = startRow + rowMutator;
        int nextCol = startCol + colMutator;

        if(countPresents <= 0){
            return;
        }

        if(matrix[nextRow][nextCol] == 'V'){
            niceKidsCount--;
            countPresents--;

        }else if(matrix[nextRow][nextCol] == 'X'){
            countPresents--;
        }
        matrix[nextRow][nextCol] = '-';

    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = line.toCharArray();
            if (line.contains("S")) {
                startRow = r;
                startCol = line.indexOf("S");
            }
            for (int col = 0; col < size; col++) {
                if (matrix[r][col] == 'V') {
                    niceKidsCount++;
                }
            }

        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
