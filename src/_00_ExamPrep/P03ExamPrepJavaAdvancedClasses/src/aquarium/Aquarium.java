package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }
    public void add(Fish fish){
        if(getFishInPool() < getCapacity()){
            if(!fishInPool.contains(fish)){
                fishInPool.add(fish);
            }
        }
    }
    public boolean remove(String name){
        for (Fish fish : fishInPool) {
            if(fish.getName().equals(name)){
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }
    public Fish findFish(String name){
        return fishInPool.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);

    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d",name, size));
        for (Fish fish : fishInPool) {
            sb.append(System.lineSeparator()).append(fish);
        }
        return sb.toString().trim();
    }
}
