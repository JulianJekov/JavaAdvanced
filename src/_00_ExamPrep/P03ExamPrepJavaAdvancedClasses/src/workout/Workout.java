package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        if(exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle){
        return exercises.stream().filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle)).findFirst().orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise(){
        return exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }
    public int getExerciseCount(){
        return exercises.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder("Workout type: " + type);
        for (Exercise exercise : exercises) {
            sb.append(System.lineSeparator()).append(exercise);
        }

        return sb.toString().trim();
    }
}
