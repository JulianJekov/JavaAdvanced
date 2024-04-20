package _07_Generics.Exercise.P10andP11Tupel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        String name = data[0] + " " + data[1];
        String address = data[2];
        String town = data[3];
        Tupel<String, String, String> firstTupel = new Tupel<>(name, address, town);

        System.out.println(firstTupel);

        data = scanner.nextLine().split(" ");
        String firstName = data[0];
        Integer litersOfBeer = Integer.parseInt(data[1]);
        String drunkOrNot = data[2];
        Tupel<String, Integer, String> secondTupel = new Tupel<>(firstName, litersOfBeer);
        if(drunkOrNot.equals("drunk")){
            secondTupel.setThird("true");
        }else{
            secondTupel.setThird("false");
        }

        System.out.println(secondTupel);

        data = scanner.nextLine().split(" ");
        String oneName = data[0];
        Double accountBalance = Double.parseDouble(data[1]);
        String bankName = data[2];
        Tupel<String, Double, String> thirdTupel = new Tupel<>(oneName, accountBalance, bankName);

        System.out.println(thirdTupel);
    }
}
