package _08_IteratorsAndComparators.Exercise.P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> emelemnts;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.emelemnts = List.of(elements);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < emelemnts.size() - 1;
    }
    public boolean move(){
        if(hasNext()){
            currentIndex++;
            return true;
        }
        return false;
    }
    public void print(){
        if(emelemnts.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(emelemnts.get(currentIndex));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int internalIndex;
            @Override
            public boolean hasNext() {
                return internalIndex < emelemnts.size();
            }

            @Override
            public String next() {
                String element = emelemnts.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }
    public void printAll(){
        String result = String.join(" ", emelemnts);
        System.out.printf("%s%n",result);
    }
}
