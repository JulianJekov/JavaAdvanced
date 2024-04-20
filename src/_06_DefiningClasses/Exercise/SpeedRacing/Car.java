package _06_DefiningClasses.Exercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1KM;
    private int distanceTravel;

    public Car(String model, double fuelAmount, double fuelCostFor1KM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1KM = fuelCostFor1KM;
        this.distanceTravel = 0;
    }

    public double fuelCost(int distance){
        return this.fuelCostFor1KM * distance;
    }

    public boolean hasEnoughFuel(int distance){
        return this.fuelAmount >= fuelCost(distance);
    }

    public void drive(int distance){
        if(hasEnoughFuel(distance)){
            this.fuelAmount -= fuelCost(distance);
            this.distanceTravel = distanceTravel + distance;
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1KM() {
        return fuelCostFor1KM;
    }

    public void setFuelCostFor1KM(double fuelCostFor1KM) {
        this.fuelCostFor1KM = fuelCostFor1KM;
    }

    public int getDistanceTravel() {
        return distanceTravel;
    }

    public void setDistanceTravel(int distanceTravel) {
        this.distanceTravel = distanceTravel;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",model, fuelAmount, distanceTravel);
    }
}
