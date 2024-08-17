package _05_FunctionalProgramming.Lab;

import java.util.Random;
import java.util.function.*;

public class cheat {
    public static void main(String[] args) {
        Function<String, Integer> func = e -> Integer.parseInt(e);
        func.apply("12");

        BiFunction<Integer, Integer, String> sum = (x, y) -> "Sum is " + (x + y);

        Consumer<Integer> printer = e -> System.out.println(e);
        printer.accept(12);

        BiConsumer<String, Integer> myBiconsumer = (String name, Integer age) -> System.out.println(name + " " + age);

        Supplier<Integer> getRandomInt = () -> new Random().nextInt(51);
        getRandomInt.get();

        Predicate<Integer> checkIfEven = e -> e % 2 == 2;
        checkIfEven.test(12);

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;


    }
}
