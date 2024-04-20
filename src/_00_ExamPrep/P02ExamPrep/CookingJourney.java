package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int startRow = -1;
        int startCol = -1;

        int firstPillarRow = -1;
        int firstPillarCol = -1;

        int secondPillarRow = -1;
        int secondPillarCol = -1;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
            if (line.contains("P") && firstPillarRow == -1) {
                firstPillarRow = row;
                firstPillarCol = line.indexOf("P");
            } else if (line.contains("P") && firstPillarRow != -1) {
                secondPillarRow = row;
                secondPillarCol = line.indexOf("P");
            }
        }
        int money = 0;
        matrix[startRow][startCol] = '-';
        boolean inMatrix = true;
        while (money < 50) {
            String command = scanner.nextLine();
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
            if (startRow >= 0 && startRow < size && startCol >= 0 && startCol < size) {
                if (Character.isDigit(matrix[startRow][startCol])) {
                    money += Integer.parseInt(matrix[startRow][startCol] + "");
                } else if (matrix[startRow][startCol] == 'P') {
                    matrix[firstPillarRow][firstPillarCol] = '-';
                    matrix[secondPillarRow][secondPillarCol] = '-';
                    if (matrix[startRow][startCol] == matrix[firstPillarRow][firstPillarCol]) {
                        startRow = secondPillarRow;
                        startCol = secondPillarCol;
                    } else {
                        startRow = firstPillarRow;
                        startCol = firstPillarCol;
                    }
                }
                matrix[startRow][startCol] = '-';
            } else {
                inMatrix = false;
                break;
            }
        }
        if (inMatrix) {
            matrix[startRow][startCol] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.println("Money: " + money);

        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
