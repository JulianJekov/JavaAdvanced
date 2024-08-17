package _02_MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowColSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(rowColSize[0]);
        int cols = Integer.parseInt(rowColSize[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                numbers.add(count++);
            }
            matrix.add(numbers);
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            String[] commands = input.split("\\s+");

            int row = Integer.parseInt(commands[0]);
            int col = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);

            for (int i = col - radius; i <= col + radius; i++) {
                if (row >= 0 && row < matrix.size() && i >= 0 && i < matrix.get(row).size()) {
                    matrix.get(row).set(i, -1);
                }
            }

            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < matrix.size() && col >= 0 && col < matrix.get(i).size()) {
                    matrix.get(i).set(col, -1);
                }
            }
            for (List<Integer> rowsz : matrix) {
               rowsz.removeIf(n->n == -1);
            }

            input = scanner.nextLine();
            matrix.removeIf(List::isEmpty);
        }



        for (List<Integer> row : matrix) {
            for (Integer integer : row) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
