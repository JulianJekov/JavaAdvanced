package _06_DefiningClasses.Exercise.Google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String model, int speed) {
        this.carModel = model;
        this.carSpeed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d",carModel,carSpeed);
    }
}
