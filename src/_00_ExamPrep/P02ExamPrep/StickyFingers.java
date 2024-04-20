package _00_ExamPrep.P02ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        List<String> commands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        int startRow = -1;
        int startCol = -1;
        char[][] field = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            field[row] = line.toCharArray();
            if (line.contains("D")) {
                startRow = row;
                startCol = line.indexOf("D");
            }
        }
        boolean isCaught = false;
        int money = 0;
        for (int i = 0; i < commands.size(); i++) {
            int currentRow = startRow;
            int currentCol = startCol;
            String command = commands.get(i);
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
            if (!isInBounds(field, startRow, startCol)) {
                startRow = currentRow;
                startCol = currentCol;
                System.out.println("You cannot leave the town, there is police outside!");
            } else {
                field[currentRow][currentCol] = '+';
                if (field[startRow][startCol] == '$') {
                    money += (startRow * startCol);
                    field[startRow][startCol] = '+';
                    System.out.printf("You successfully stole %d$.%n",startRow * startCol);
                } else if (field[startRow][startCol] == 'P') {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n",money);
                    field[startRow][startCol] = '#';
                    isCaught = true;
                    break;
                }
            }
        }
        if(!isCaught){
            field[startRow][startCol] = 'D';
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",money);
        }
        for (char[] row : field) {
            for (char symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }
}
