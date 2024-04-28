package _00_Exam.src.P03_automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        if(vehicles.size() < capacity){
            vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getVIN().equals(vin)){
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }
    public int getCount(){
        return this.vehicles.size();
    }
    public Vehicle getLowestMileage(){
        return vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).orElse(null);
    }
    public String report(){
        StringBuilder sb = new StringBuilder("Vehicles in the preparatory:");
        for (Vehicle vehicle : this.vehicles) {
            sb.append(System.lineSeparator());
            sb.append(vehicle);
        }
        return sb.toString().trim();
    }
}
