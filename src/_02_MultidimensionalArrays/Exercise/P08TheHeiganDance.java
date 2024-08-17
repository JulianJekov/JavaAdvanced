package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //player

        int playerHealth = 18_500;
        double playerDamage = Double.parseDouble(scanner.nextLine());
        int playerRow = 7;
        int playerCol = 7;

        //boss
        double bossHealth = 3_000_000;
        String lastSpell = "";

        boolean activeCloud = false;

        while (playerHealth > 0 && bossHealth > 0) {
            bossHealth -= playerDamage;
            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;

                if (playerHealth < 0) {
                    break;
                }
            }
            if (bossHealth < 0) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][] matrix = new boolean[15][15];

            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < matrix.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < matrix[row].length) {
                            matrix[i][j] = true;
                        }
                    }
                }
            }

            if (matrix[playerRow][playerCol]) {
                if (isValidRow(matrix, playerRow - 1) && !matrix[playerRow - 1][playerCol]) {
                    playerRow--;
                } else if (isValidCol(matrix, playerCol + 1, playerRow) && !matrix[playerRow][playerCol + 1]) {
                    playerCol++;
                } else if (isValidRow(matrix, playerRow + 1) && !matrix[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (isValidCol(matrix, playerCol - 1, playerRow) && !matrix[playerRow][playerCol - 1]) {
                    playerCol--;
                }

                if (matrix[playerRow][playerCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            lastSpell = "Eruption";

                            break;
                    }
                }
            }
        }
        if (bossHealth > 0) {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth > 0) {
            System.out.printf("Player: %d%n", playerHealth);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean isValidCol(boolean[][] matrix, int playerCol, int playerRow) {
        return playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    private static boolean isValidRow(boolean[][] matrix, int playerRow) {
        return playerRow >= 0 && playerRow < matrix.length;
    }
}
