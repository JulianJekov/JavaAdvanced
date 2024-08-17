package _06_DefiningClasses.Exercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String information = scanner.nextLine();

        Map<String, Person> peopleData = new HashMap<>();

        while (!information.equals("End")) {
            String[] data = information.split("\\s+");
            String name = data[0];
            if (!peopleData.containsKey(name)) {
                peopleData.put(name, new Person());
            }

            switch (data[1]) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    peopleData.get(name).getParents().add(parents);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Children children = new Children(childName, childBirthday);
                    peopleData.get(name).getChildren().add(children);
                    break;
                case "car":
                    String carMode = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carMode, carSpeed);
                    peopleData.get(name).setCar(car);
                    break;
            }

            information = scanner.nextLine();
        }
        String searchName = scanner.nextLine();

        System.out.println(searchName);

        Person personData = peopleData.get(searchName);
        System.out.println(personData);
    }
}