package _05_FunctionalProgramming.Exercise;

import java.util.function.*;

public class cheat {
    public static void main(String[] args) {


        Function<String, Integer> parseString = text -> Integer.parseInt(text); //Integer::parsInt;

        Function<String, String> function = s-> "Hello " + s;

        UnaryOperator<String> unaryOperator = s -> "Hello " + s;

        Predicate<String> predicate = s -> s.length() > 5;

        Consumer<String> consumer = System.out::println; // name - > System.out.println(name);

        Supplier<String> supplier = () -> "Pesho";

        BiFunction<String,Integer,Integer> biFunction = (text, number) -> text.length() + number;

        BiPredicate<String,String> biPredicate = (text1, text2) -> text1.length() > text2.length();

        BiConsumer<String,String> biConsumer = (text1,text2) -> System.out.println(text1 + text2);

        BinaryOperator<Integer> binaryOperator = (number1, number2) -> number1 + number2; //Integer::sum;
    }
}
