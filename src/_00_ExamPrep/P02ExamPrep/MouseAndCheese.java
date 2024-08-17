package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];

        int mouseRow = -1;
        int mouseCol = -1;
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            territory[row] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = row;
                mouseCol = line.indexOf("M");
            }
        }
        int eatenCheeses = 0;

        String command = scanner.nextLine();

        territory[mouseRow][mouseCol] = '-';
        boolean isInTerritoy = true;
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if (!isInBounds(territory, mouseRow, mouseCol)) {
                isInTerritoy = false;
                System.out.println("Where is the mouse?");
                break;
            } else {
                if (territory[mouseRow][mouseCol] == 'c') {
                    eatenCheeses++;
                    territory[mouseRow][mouseCol] = '-';
                } else if (territory[mouseRow][mouseCol] == 'B') {
                    territory[mouseRow][mouseCol] = '-';
                    continue;
                }
            }
            command = scanner.nextLine();
        }
        if (isInTerritoy) {
            territory[mouseRow][mouseCol] = 'M';
        }
        if (eatenCheeses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheeses);
        }
        for (char[] row : territory) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(char[][] territory, int row, int col) {
        return row >= 0 && row < territory.length && col >= 0 && col < territory[row].length;
    }
}
