package _08_IteratorsAndComparators.Exercise.P01ListyIterator;

import java.util.List;

public class ListyIterator {
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
}
