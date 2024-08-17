package _00_ExamPrep.P02ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int startRow = -1;
        int startCol = -1;

        int swordValue = 0;

        List<Integer> mirrorsIndeces = new ArrayList<>();

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("A")) {
                startRow = row;
                startCol = line.indexOf("A");
            }
            if (line.contains("M")) {
                mirrorsIndeces.add(row);
                mirrorsIndeces.add(line.indexOf("M"));
            }
        }
        boolean isInArmory = true;
        while (swordValue < 65) {
            String command = scanner.nextLine();
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

            if (!isInBounds(matrix, startRow, startCol)) {
                isInArmory = false;
                System.out.println("I do not need more swords!");
                break;
            } else {
                if (Character.isDigit(matrix[startRow][startCol])) {
                    String symbol = matrix[startRow][startCol] + "";
                    swordValue += Integer.parseInt(symbol);
                    matrix[startRow][startCol] = '-';

                } else if (matrix[startRow][startCol] == 'M') {
                    startRow = mirrorsIndeces.get(2);
                    startCol = mirrorsIndeces.get(3);
                    matrix[mirrorsIndeces.get(0)][mirrorsIndeces.get(1)] = '-';
                    matrix[mirrorsIndeces.get(2)][mirrorsIndeces.get(3)] = '-';
                }
            }
        }
        if(isInArmory){
            matrix[startRow][startCol] = 'A';
        }
        if(swordValue >= 65){
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",swordValue);

        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
