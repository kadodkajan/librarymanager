package library.model;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;
public class Library {
    private  List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }


    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to check the availability of a book
    public boolean isBookAvailable(Book book) {
        return books.contains(book) && book.isAvailable();
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public List<Book> getALLBooks() {

        return books;
    }
}
