package com.uestc.designpattern.iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.addBook(new Book("ab"));
        bookShelf.addBook(new Book("cd"));
        bookShelf.addBook(new Book("ef"));
        bookShelf.addBook(new Book("gh"));
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }

    }
}
