package _08_IteratorsAndComparators.Lab.Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return null;
    }
    private class LibraryIterator implements Iterator<Book>{
        private int index;

        public LibraryIterator(){
            this.index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
           return books[index++];
        }
    }
}

