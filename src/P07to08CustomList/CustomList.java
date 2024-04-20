package P07to08CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();

    }

    public void add(T element){
        list.add(element);
    }

    public void remove(int indexToRemove) {
        list.remove(indexToRemove);
    }

    public boolean contains(T containsElement) {
        return list.contains(containsElement);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(list,firstIndex,secondIndex);
    }
    public int countGreaterThan(T element){
        return (int) list.stream()
                .filter(existingElement->existingElement.compareTo(element) > 0)
                .count();
    }
    public T getMax(){
        return list.stream().max(Comparable::compareTo).get();
    }
    public T getMin(){
        return list.stream().min(Comparable::compareTo).get();
    }

    public int size(){
        return list.size();
    }
    public T get(int index){
        return list.get(index);
    }
    public int getIndex(T element){
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if(element.compareTo(list.get(i)) == 0){
                result = i;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
