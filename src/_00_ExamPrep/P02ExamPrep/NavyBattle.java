package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int playerRow = -1;
        int playerCol = -1;

        int cruisers = 3;
        int hitMines = 0;

        for (int row = 0; row < matrix.length; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow.split("")[col];
                if (matrix[row][col].equals("S")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        while (cruisers != 0 && hitMines != 3) {
            int currentRow = playerRow;
            int currentCol = playerCol;
            String direction = scanner.nextLine();
            switch (direction) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
           if (matrix[playerRow][playerCol].equals("*")) {
                hitMines++;
            } else if (matrix[playerRow][playerCol].equals("C")) {
                cruisers--;
            }
            matrix[currentRow][currentCol] = "-";
            matrix[playerRow][playerCol] = "S";
        }
        if(cruisers == 0){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        if(hitMines == 3){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",playerRow,playerCol);
        }
        for (String[] row : matrix) {
            for (String symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
