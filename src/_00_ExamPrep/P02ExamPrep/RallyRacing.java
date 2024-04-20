package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        int tunel1Row = -1;
        int tunel1Col = -1;

        int tunel2Row = -1;
        int tunel2Col = -1;

        int countTunnels = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col].equals("T") && countTunnels == 0) {
                    countTunnels++;
                    tunel1Row = row;
                    tunel1Col = col;
                } else if (matrix[row][col].equals("T") && countTunnels != 0) {
                    tunel2Row = row;
                    tunel2Col = col;
                }
            }
        }
        int carRow = 0;
        int carCol = 0;
        int distance = 0;
        boolean isFinish = false;
        String direction = scanner.nextLine();

        while (!direction.equals("End")) {

            switch (direction) {
                case "up":
                    carRow--;
                    break;
                case "down":
                    carRow++;
                    break;
                case "left":
                    carCol--;
                    break;
                case "right":
                    carCol++;
                    break;
            }

            if (matrix[carRow][carCol].equals("T")) {
                if (carRow == tunel1Row && carCol == tunel1Col) {
                    carRow = tunel2Row;
                    carCol = tunel2Col;
                } else {
                    carRow = tunel1Row;
                    carCol = tunel1Col;
                }
                matrix[tunel1Row][tunel1Col] = ".";
                matrix[tunel2Row][tunel2Col] = ".";
                distance += 30;
            } else if (matrix[carRow][carCol].equals(".")) {
                distance += 10;
            } else {
                matrix[carRow][carCol] = "C";
                distance += 10;
                isFinish = true;
                break;
            }
            direction = scanner.nextLine();
        }
        if (isFinish) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            matrix[carRow][carCol] = "C";
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);

        for (String[] row : matrix) {
            for (String symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }


}
