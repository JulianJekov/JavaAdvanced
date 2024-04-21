package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        Elephant elephant = data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (elephant != null) {
            data.remove(elephant);
            return true;
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(e -> e.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }
    public int getAllElephants(){
        return data.size();
    }
    public String getReport(){
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        for (Elephant elephant : data) {
            sb.append(System.lineSeparator()).append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom());
        }
        return sb.toString().trim();
    }
}

