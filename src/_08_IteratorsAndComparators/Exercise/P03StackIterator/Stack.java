package _08_IteratorsAndComparators.Exercise.P03StackIterator;


import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    private ArrayDeque<Integer> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int element) {
        stack.push(element);
    }
    public void push(int[] elements){
        for (int element : elements) {
            stack.push(element);
        }
    }

    public void pop() {
       if(this.stack.isEmpty()){
           System.out.println("No elements");
           return ;
       }
       this.stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private ArrayDeque<Integer> tempStack = new ArrayDeque<>(stack);
            @Override
            public boolean hasNext() {
                return !tempStack.isEmpty();
            }

            @Override
            public Integer next() {
                return tempStack.pop();
            }
        };
    }
}
