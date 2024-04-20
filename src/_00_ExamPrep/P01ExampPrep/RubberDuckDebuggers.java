package _00_ExamPrep.P01ExampPrep;

import java.util.*;
import java.util.stream.Collectors;

public class RubberDuckDebuggers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> programmerQueue = fillQueue(scanner);
        ArrayDeque<Integer> numberOfTasksStack = new ArrayDeque<>();
        fillStack(scanner, numberOfTasksStack);

        Map<String, Integer> rubberDucks = new LinkedHashMap<>();
        fillMap(rubberDucks);

        while (!programmerQueue.isEmpty() && !numberOfTasksStack.isEmpty()) {
            int currentProgrammerTime = programmerQueue.poll();
            int currentTask = numberOfTasksStack.pop();
            int neededTime = currentProgrammerTime * currentTask;

            tryToCompleteTasks(programmerQueue, numberOfTasksStack, rubberDucks, currentProgrammerTime, currentTask, neededTime);
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        rubberDucks.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void tryToCompleteTasks(ArrayDeque<Integer> programmerQueue, ArrayDeque<Integer> numberOfTasksStack, Map<String, Integer> rubberDucks, int currentProgrammerTime, int currentTask, int neededTime) {
        if (neededTime > 0 && neededTime < 241) {
            if (neededTime <= 60) {
                rubberDucks.put("Darth Vader Ducky", rubberDucks.get("Darth Vader Ducky") + 1);
            } else if (neededTime <= 120) {
                rubberDucks.put("Thor Ducky", rubberDucks.get("Thor Ducky") + 1);
            } else if (neededTime <= 180) {
                rubberDucks.put("Big Blue Rubber Ducky", rubberDucks.get("Big Blue Rubber Ducky") + 1);
            } else{
                rubberDucks.put("Small Yellow Rubber Ducky", rubberDucks.get("Small Yellow Rubber Ducky") + 1);
            }
        } else {
            numberOfTasksStack.push(currentTask - 2);
            programmerQueue.offer(currentProgrammerTime);
        }
    }

    private static void fillStack(Scanner scanner, ArrayDeque<Integer> numberOfTasksStack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numberOfTasksStack::push);
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> programmerQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        return programmerQueue;
    }

    private static void fillMap(Map<String, Integer> rubberDucks) {
        rubberDucks.put("Darth Vader Ducky", 0);
        rubberDucks.put("Thor Ducky", 0);
        rubberDucks.put("Big Blue Rubber Ducky", 0);
        rubberDucks.put("Small Yellow Rubber Ducky", 0);
    }
}
