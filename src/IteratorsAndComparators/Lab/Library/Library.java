package IteratorsAndComparators.Lab.Library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book>implements Iterable<Book> {

    private Book[] books;

    public Library (Book...books){
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
    private class LibIterator implements Iterator<Book>{
        private int counter = 0;
        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }

        @Override
        public void forEachRemaining(Consumer<? super Book> action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
