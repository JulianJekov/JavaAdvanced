package _06_DefiningClasses.Exercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String[] carData = scanner.nextLine().split("\\s+");

            String carModel = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCostFor1KM = Double.parseDouble(carData[2]);

            Car car = new Car(carModel,fuelAmount,fuelCostFor1KM);
            cars.put(carModel,car);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")){

            String[] commandData = command.split("\\s+");

            String carModel = commandData[1];
            int distance = Integer.parseInt(commandData[2]);

            Car currentCar = cars.get(carModel);

            currentCar.drive(distance);

            command = scanner.nextLine();
        }
        cars.values().forEach(System.out::println);
    }
}
