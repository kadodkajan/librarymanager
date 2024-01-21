package library.model;

public class Book {
    // Attributes
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;

    // Constructor
    public Book(int bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        // new book will available
        this.availability = true;
    }

    // Getter methods
    public int getBookID() {
        return bookID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }



    public boolean isAvailable() {
        return availability;
    }
    public void setAvailable(boolean available) {
        this.availability = available;
    }
    // Setter method for changing availability status
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
