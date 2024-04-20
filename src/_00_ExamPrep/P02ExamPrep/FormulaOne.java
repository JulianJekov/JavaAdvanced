package _00_ExamPrep.P02ExamPrep;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int[] playerPos = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("P")) {
                playerPos[0] = row;
                playerPos[1] = line.indexOf("P");
            }
        }
        boolean isFinish = false;
        matrix[playerPos[0]][playerPos[1]] = '.';
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            int currentRow = playerPos[0];
            int currentCol = playerPos[1];

            carMove(playerPos,size,command);

            if (matrix[playerPos[0]][playerPos[1]] == 'B') {
                carMove(playerPos,size,command);
            } else if (matrix[playerPos[0]][playerPos[1]] == 'T') {
                playerPos[0] = currentRow;
                playerPos[1] = currentCol;
            } else if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                isFinish = true;
                break;
            }
        }
        matrix[playerPos[0]][playerPos[1]] = 'P';
        if (isFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    public static boolean inTheMatrix(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
    public static void carMove(int[] pos, int size, String command) {
        if(command.equals("up")){
            if(inTheMatrix(pos[0] - 1, pos[1], size)) {
                pos[0]--;
            } else {
                pos[0] = size -1;
            }
        } else if (command.equals("down")){
            if(inTheMatrix(pos[0] + 1, pos[1], size)) {
                pos[0]++;
            } else {
                pos[0] = 0;
            }
        } else if (command.equals("left")){
            if(inTheMatrix(pos[0], pos[1] - 1, size)) {
                pos[1]--;
            } else {
                pos[1] = size -1;
            }
        } else if (command.equals("right")){
            if(inTheMatrix(pos[0], pos[1] + 1, size)) {
                pos[1]++;
            } else {
                pos[1] = 0;
            }
        }
    }
}
