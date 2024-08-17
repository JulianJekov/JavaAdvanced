package _06_DefiningClasses.Exercise.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){

            String[] inputData = input.split("\\s+");

            String breed = inputData[0];
            String catName = inputData[1];

            Cat cat = null;

            switch (breed){
                case"Siamese":
                    double earSize = Double.parseDouble(inputData[2]);
                    cat = new Siamese(catName, earSize);
                    break;
                case"Cymric":
                    double furLength = Double.parseDouble(inputData[2]);
                    cat = new Cymric(catName, furLength);
                    break;
                case"StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(inputData[2]);
                    cat = new StreetExtraordinaire(catName, decibelsOfMeows);
                    break;
            }
            cats.put(catName,cat);

            input = scanner.nextLine();
        }
        String catNameToSearch = scanner.nextLine();

        if(cats.containsKey(catNameToSearch)) {
            System.out.println(cats.get(catNameToSearch));
        }
    }
}
