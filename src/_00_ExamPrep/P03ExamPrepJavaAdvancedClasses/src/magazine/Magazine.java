package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)) {
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparingInt(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(e->e.getColor().equals(color)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.type).append(" ").append("magazine").append(" ").append("contains:");
        for (Cloth cloth : this.data) {
            sb.append(System.lineSeparator());
            sb.append(cloth);
        }
        return sb.toString().trim();
    }
}
