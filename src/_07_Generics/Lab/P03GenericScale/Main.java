package _07_Generics.Lab.P03GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(11, 11);
        System.out.println(scale.getHeavier());
    }
}
