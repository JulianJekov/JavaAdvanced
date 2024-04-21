package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firsName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firsName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        List<Child> orderedChild = registry.stream().sorted(Comparator.comparingInt(Child::getAge).thenComparing(
                Comparator.comparing(Child::getFirstName).thenComparing(Child::getLastName)
        )).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");
        for (Child child : orderedChild) {
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(child.toString());
        }
        return sb.toString().trim();
    }
}
