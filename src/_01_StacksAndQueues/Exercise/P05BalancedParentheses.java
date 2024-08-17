package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '['){
                openBrackets.push(currentBracket);
            }else {
                if(openBrackets.isEmpty()){
                   isBalanced = false;
                   break;
                }
                char lastOpenBracket = openBrackets.pop();
                if(currentBracket == ')' && lastOpenBracket != '('){
                    isBalanced =false;
                    break;
                }else if(currentBracket == '}' && lastOpenBracket != '{'){
                    isBalanced = false;
                    break;
                }else if(currentBracket == ']' && lastOpenBracket != '['){
                    isBalanced = false;
                    break;
                }
            }
        }
        if(isBalanced && openBrackets.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
