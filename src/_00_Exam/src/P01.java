package _00_Exam.src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = fillQueue(scanner);
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        fillStack(scanner, substancesStack);
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !challenges.isEmpty()) {
            int currentTool = toolsQueue.peek();
            int currentSubstances = substancesStack.peek();
            int result = currentTool * currentSubstances;

            boolean isChallenge = false;
                    //challenges.stream().anyMatch(c -> c == result);
            for (Integer challenge : challenges) {
                if(challenge == result){
                    isChallenge = true;
                    break;
                }
            }
            if (isChallenge) {
                toolsQueue.poll();
                substancesStack.pop();
                for (Integer challenge : challenges) {
                    if(challenge == result){
                        challenges.remove(challenge);
                        break;
                    }
                }
               // challenges.removeIf(c -> c == result);
            } else {
                toolsQueue.poll();
                toolsQueue.offer(currentTool + 1);

                substancesStack.pop();
                substancesStack.push(currentSubstances - 1);
                if (substancesStack.peek() == 0) {
                    substancesStack.pop();
                }
            }
        }
        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }
        if(!toolsQueue.isEmpty()){
            System.out.print("Tools: ");
            System.out.println(toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if(!substancesStack.isEmpty()){
            System.out.print("Substances: ");
            System.out.println(substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if(!challenges.isEmpty()){
            System.out.print("Challenges: ");
            System.out.println(challenges.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static void fillStack(Scanner scanner, ArrayDeque<Integer> stack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
