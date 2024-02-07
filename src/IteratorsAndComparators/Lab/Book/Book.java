package IteratorsAndComparators.Lab.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book>{

    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<String>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }

    }

    @Override
    public int compareTo(Book book) {
        int byName = this.getTitle().compareTo(book.getTitle());
        if (byName == 0){
            return Integer.compare(this.year, book.getYear());
        }else {
            return this.getTitle().compareTo(book.getTitle());
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    //    @Override
//    public String toString(){
//
//        return String.format("%s, %d, %s",this.title,this.year,this.authors)
//                .replace("[","").replace("]","");
//        //return String.format(String.format("%s, %d, ",this.title,this.year) + String.join(", ",getAuthors()));
////
//    }
}
