package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public int getCount(){
        return data.size();
    }
    public String insert(Student student){
        String result;
        for (Student currentStudent : data) {
            if(currentStudent.getFirstName().equals(student.getFirstName())){
                result = "Student is already in the hall.";
              return result;
            }
        }
        if (getCount() < getCapacity()) {
            data.add(student);
            result = String.format("Added student %s %s.",student.getFirstName(),student.getLastName());
        }else {
            result = "The hall is full.";
        }
        return  result;
    }
    public String remove(Student student){
        String result;
        for (Student currentStudent : data) {
            if(currentStudent.getFirstName().equals(student.getFirstName())){
                result = String.format("Removed student %s %s.",student.getFirstName(),student.getLastName());
                data.remove(currentStudent);
                return result;
            }
        }
        result = "Student not found.";
        return result;
    }
    public Student getStudent(String firstName, String lastName){
        for (Student currentStudent : data) {
            if(currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)){
                return currentStudent;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount());
        for (Student student : data) {
            sb.append(System.lineSeparator()).append(student);
        }
        return sb.toString().trim();
    }
}
