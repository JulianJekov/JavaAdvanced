package _01_StacksAndQueues.Exercise;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if(n == 0){
            System.out.println(0);
            return;
        }
        if (n != 1) {
            n += 1;
        }

        long[] fibonacciArr = new long[n];


        fibonacciArr[0] = 1;


        for (int i = 2; i < fibonacciArr.length; i++) {
            fibonacciArr[1] = 1;
            fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];

        }
        System.out.println(fibonacciArr[fibonacciArr.length - 1]);
    }
}
