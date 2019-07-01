package com.uestc.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Iterable<Book>{

    private static int DEFAULT_BOOKS_SIZE = 10;

    private List<Book> books;

    private int capacity;

    public BookShelf() {
        this(DEFAULT_BOOKS_SIZE);
    }

    public BookShelf(int capacity) {
        books = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public void addBook(Book book) {
        checkSize();
        books.add(book);
    }

    public Book getBookByIndex(int index) {
        checkRange(index);
        return books.get(index);
    }

    private void checkRange(int index) {
        if (index >= books.size() || index < 0) {
            throw new RuntimeException("输入索引不合法， index: " + index);
        }
    }

    private void checkSize() {
        if (books.size() == capacity) {
            throw new RuntimeException("容量已满，不能再继续添加了");
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new Itr();
    }


    class Itr implements Iterator<Book> {
        int cur;
        @Override
        public boolean hasNext() {
            return cur != books.size();
        }

        @Override
        public Book next() {
            Book res = books.get(cur);
            cur++;
            return res;
        }
    }
}
