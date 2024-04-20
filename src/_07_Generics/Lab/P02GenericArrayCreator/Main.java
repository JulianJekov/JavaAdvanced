package _07_Generics.Lab.P02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();

        String[] strings = ArrayCreator.create(String.class, 5, "s");
        Integer[] integers = ArrayCreator.create(4, 2);
        System.out.println();
    }
}
