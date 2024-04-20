package _08_IteratorsAndComparators.Lab.ComparableBook;

public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean Code", 2000, "Uncle Bob");
        Book secondBook = new Book("Thinking in Java", 2006, "Bruce Eckle");

        System.out.println(firstBook.compareTo(secondBook));
    }
}
