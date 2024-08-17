package _08_IteratorsAndComparators.Lab.ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book otherBook) {
        if(this.getTitle().compareTo(otherBook.getTitle()) == 0){
            //The book titles are equal
            return Integer.compare(this.getYear(),otherBook.getYear());
        }
        return this.getTitle().compareTo(otherBook.getTitle());
    }
}
