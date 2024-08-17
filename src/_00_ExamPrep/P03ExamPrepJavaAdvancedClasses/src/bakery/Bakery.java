package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void add(Employee employee){
        if(employees.size() < capacity){
            employees.add(employee);
        }
    }
    public boolean remove(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name){
        return employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder("Employees working at Bakery " + name + ":");
        for (Employee employee : employees) {
            sb.append(System.lineSeparator()).append(employee);
        }

        return sb.toString().trim();
    }
}
