package Workshop;

public class CustomStack {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;


    public CustomStack() {
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void push(int element){
        checkCapacity();
        this.data[size] = element;
        this.size++;
    }

    public int pop(){
        this.ensureStackNotEmpty();
        this.size--;
        int itemToRemove = this.data[size];
        this.data[size] = 0;
        if (this.capacity / this.size > 4) {
            shrink();
        }
        return itemToRemove;
    }

    private void ensureStackNotEmpty() {
        if(this.size == 0){
            throw new IndexOutOfBoundsException("Our CustomStack is Empty");
        }
    }

    public int peek(){
        return this.data[size - 1];
    }

    private void checkCapacity() {
        if (this.size == capacity) {
            this.resize();
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
    private void shrink() {
        this.capacity = this.capacity / 2;
        int[] temp = new int[capacity];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }
}
