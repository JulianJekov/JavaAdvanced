package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][];

        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            field[row] = line.toCharArray();
            if (line.contains("P")) {
                parisRow = row;
                parisCol = line.indexOf("P");
            }
        }
        boolean isHelena = false;
        field[parisRow][parisCol] = '-';
        while (energy > 0) {
            String[] commands = scanner.nextLine().split("\\s+");
            String move = commands[0];

            int spawnRow = Integer.parseInt(commands[1]);
            int spawnCol = Integer.parseInt(commands[2]);

            int currentRow = parisRow;
            int currentCol = parisCol;

            switch (move) {
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "right":
                    parisCol++;
                    break;
            }
            field[spawnRow][spawnCol] = 'S';
            energy--;

            if (!isInBounds(field, parisRow, parisCol)) {
                parisRow = currentRow;
                parisCol = currentCol;

            } else {
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    field[parisRow][parisCol] = '-';
                    if (energy <= 0) {
                        break;
                    }
                } else if (field[parisRow][parisCol] == 'H') {
                    isHelena = true;
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    break;
                }
            }
        }
        if (energy <= 0 && !isHelena) {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        for (char[] row : field) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }
}
