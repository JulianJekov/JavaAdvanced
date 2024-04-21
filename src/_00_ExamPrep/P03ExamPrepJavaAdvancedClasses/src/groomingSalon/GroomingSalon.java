package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owener){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owener)){
                return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner());
        }
        return sb.toString().trim();
    }
}
