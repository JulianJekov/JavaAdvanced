package _00_ExamPrep.P02ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        List<String> directions = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());

        char[][] matrix = new char[size][size];

        int snakeRow = -1;
        int snakeCol = -1;
        int foodCount = 0;
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col] == 'f') {
                    foodCount++;
                }
            }

        }
        int snakeSize = 1;
        boolean isAlive = true;
        for (int i = 0; i < directions.size(); i++) {
            String command = directions.get(i);
            if (command.equals("up")) {
                if (snakeRow == 0) {
                    snakeRow = size - 1;
                } else {
                    snakeRow--;
                }
            } else if (command.equals("down")) {
                if (snakeRow == size - 1) {
                    snakeRow = 0;
                } else {
                    snakeRow++;
                }
            } else if (command.equals("left")) {
                if (snakeCol == 0) {
                    snakeCol = size - 1;
                } else {
                    snakeCol--;
                }
            } else if (command.equals("right")) {
                if (snakeCol == size - 1) {
                    snakeCol = 0;
                } else {
                    snakeCol++;
                }
            }
            if (matrix[snakeRow][snakeCol] == 'f') {
                snakeSize++;
                foodCount--;
            } else if (matrix[snakeRow][snakeCol] == 'e') {
                isAlive = false;
                break;
            }
        }
        if (foodCount == 0) {
            System.out.println("You win! Final python length is " + snakeSize);
        } else if (!isAlive) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println("You lose! There is still " + foodCount + " food to be eaten.");
        }
    }
}
