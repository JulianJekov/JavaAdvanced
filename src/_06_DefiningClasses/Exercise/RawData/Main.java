package _06_DefiningClasses.Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");

            String carModel = carData[0];

            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);

            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);

            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);

            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);

            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(carModel, engine, cargo, tire);
            cars.add(car);
        }
        String command = scanner.nextLine();

        cars.forEach(car-> car.extract(command));
//        if (command.equals("flamable")) {
//            for (Car car : cars) {
//                if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
//                    System.out.println(car.getModel());
//                }
//            }
//        } else {
//            for (Car car : cars) {
//                if (car.getCargo().getType().equals("fragile") && car.getTire().isPressureUnderOne()) {
//                    System.out.println(car.getModel());
//                }
//            }
//        }
    }
}
