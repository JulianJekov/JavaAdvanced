package _01_StacksAndQueues.Exercise;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeconds = Integer.parseInt(scanner.nextLine());

        int hours = (totalSeconds / 3600) % 24;

        int minutes = (totalSeconds % 3600) / 60;

        int seconds = totalSeconds % 60;
        System.out.printf("%02d:%02d:%02d%n",hours,minutes,seconds);

    }
}
