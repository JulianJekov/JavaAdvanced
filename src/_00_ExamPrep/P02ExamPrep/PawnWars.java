package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chesBoard = new String[8][8];
        char letter = 'a';
        char digit = '8';
        for (int row = 0; row < chesBoard.length; row++) {
            for (int col = 0; col < chesBoard[row].length; col++) {
                chesBoard[row][col] = (letter + "" + digit + "");
                letter++;
            }
            digit--;
            letter = 'a';
        }
        char[][] board = new char[8][8];
        int blackRow = -1;
        int blackCol = -1;

        int whiteRow = -1;
        int whiteCol = -1;
        for (int row = 0; row < board.length; row++) {
            String line = scanner.nextLine();
            board[row] = line.toCharArray();
            if (line.contains("b")) {
                blackRow = row;
                blackCol = line.indexOf("b");
            }
            if (line.contains("w")) {
                whiteRow = row;
                whiteCol = line.indexOf("w");
            }
        }
        System.out.println();
        while (true) {
            if (whiteCol != 0) {
                if (board[whiteRow - 1][whiteCol - 1] == 'b') {
                    System.out.printf("Game over! White capture on %s.", chesBoard[whiteRow - 1][whiteCol - 1]);
                    break;
                }
            }
            if (whiteCol != board.length - 1) {
                if (board[whiteRow - 1][whiteCol + 1] == 'b') {
                    System.out.printf("Game over! White capture on %s.", chesBoard[whiteRow - 1][whiteCol + 1]);
                    break;
                }
            }

            board[whiteRow][whiteCol] = '-';
            whiteRow--;
            board[whiteRow][whiteCol] = 'w';

            if (whiteRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.", chesBoard[whiteRow][whiteCol]);
                break;
            }
            if (blackCol != 0) {
                if (board[blackRow + 1][blackCol - 1] == 'w') {
                    System.out.printf("Game over! Black capture on %s.", chesBoard[blackRow + 1][blackCol - 1]);
                    break;
                }
            }
            if (blackCol != board.length - 1) {
                if (board[blackRow + 1][blackCol + 1] == 'w') {
                    System.out.printf("Game over! Black capture on %s.", chesBoard[blackRow + 1][blackCol + 1]);
                    break;
                }
            }

            board[blackRow][blackCol] = '-';
            blackRow++;
            board[blackRow][blackCol] = 'b';

            if (blackRow == board.length - 1) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.", chesBoard[blackRow][blackCol]);
                break;
            }
        }
    }
}
