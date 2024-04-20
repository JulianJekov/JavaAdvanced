package Workshop;

import java.util.function.Consumer;

public class SmartArray {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;


    public SmartArray() {
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        checkCapacity();
        this.data[size] = element;
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        int numberToRemove = this.get(index);
        this.shift(index);
        this.size--;
        if (this.capacity / this.size > 4) {
            shrink();
        }
        return numberToRemove;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return false;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        checkIndex(index);
        checkCapacity();
        this.size++;
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = element;
    }

    public int size() {
        return this.size;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void checkCapacity() {
        if (this.size == capacity) {
            this.resize();
        }
    }

    private void shift(int index) {
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.data[size - 1] = 0;
    }

    private void shrink() {
        this.capacity = this.capacity / 2;
        int[] temp = new int[capacity];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    private void checkIndex(int index) {
        if (index > this.size || index < 0) {
            String errorMessage = String.format("Index %d is out of bounds for our SmartArray", index);
            throw new IndexOutOfBoundsException(errorMessage);
        }
    }

    private void resize() {
        this.capacity = capacity * 2;
        int[] temp = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        //System.arraycopy(data, 0, temp, 0, data.length);
        this.data = temp;
    }

}
