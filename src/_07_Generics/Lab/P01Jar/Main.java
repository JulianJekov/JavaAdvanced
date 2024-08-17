package _07_Generics.Lab.P01Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("Blue Cookie");
        jar.add("Red Cookie");
        jar.add("Green Cookie");

        System.out.println(jar.remove());
    }
}