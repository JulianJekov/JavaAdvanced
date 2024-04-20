package _06_DefiningClasses.Practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Person> map = new HashMap<>();
        while (!line.equals("End")) {

            String[] data = line.split("\\s+");
            String name = data[0];
            if (!map.containsKey(name)) {
                map.put(name, new Person(name));
            }
            switch (data[1]) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    map.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String type = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    map.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parents parents = new Parents(parentName,parentBirthday);
                    map.get(name).getParents().add(parents);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Children children = new Children(childName,childBirthday);
                    map.get(name).getChildren().add(children);
                    break;
                case "car":
                    String carName = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carName,carSpeed);
                    map.get(name).setCar(car);
                    break;
            }
            line = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();

        System.out.print(map.get(nameToPrint));

    }
}
