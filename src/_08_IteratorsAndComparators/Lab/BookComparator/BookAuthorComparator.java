package _08_IteratorsAndComparators.Lab.BookComparator;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        return Integer.compare(firstBook.getAuthors().size(),secondBook.getAuthors().size());
    }
}
