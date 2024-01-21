package library.view;

import library.model.Book;
import library.model.Library;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void displayMainMenu() {
        System.out.println(ANSI_CYAN + "--------------------------");
        System.out.println(ANSI_CYAN + "Welcome to Library Manager" + ANSI_CYAN);
        System.out.println("--------------------------");
        System.out.println("01: LIBRARY");
        System.out.println("02: USERS");
        System.out.println("09: EXIT");
        System.out.println("-------------");
        System.out.print("SELECT: ");
    }

    public static void displayLibraryMenu() {
        System.out.println("--------------------------");
        System.out.println(ANSI_CYAN + "        LIBRARY" + ANSI_CYAN);
        System.out.println("--------------------------");
        System.out.println("01: VIEW ALL BOOKS");
        System.out.println("02: ADD BOOK");
        System.out.println("03: REMOVE BOOK");
        System.out.println("04: BORROW BOOK");
        System.out.println("05: RETURN BOOK");
        System.out.println("06: BACK MENU");
        System.out.println("-------------");
        System.out.print("SELECT: ");
    }

    public static void displayUsersMenu() {
        System.out.println("--------------------------");
        System.out.println(ANSI_CYAN + "      USERS" + ANSI_CYAN);
        System.out.println("--------------------------");
        System.out.println("01: VIEW ALL USERS");
        System.out.println("02: ADD USER");
        System.out.println("03: REMOVE USER");
        System.out.println("04: BACK MENU");


        System.out.println("-------------");
        System.out.print("SELECT: ");
    }

    public static void displayBooks(List<Book> books) {
        System.out.println("--------------------------");
        System.out.println(ANSI_CYAN + "Books in the Library" + ANSI_CYAN);
        System.out.println("--------------------------");

        if (books.isEmpty()) {
            System.out.println("\u001B[33m" + "No books available in the library." + ANSI_CYAN);
        } else {
            System.out.printf(ANSI_CYAN + "%-5s%-25s%-15s%-15s%-15s\n", "ID", "Title", "Author", "Genre", "AVAILABLE" + ANSI_CYAN);
            for (Book book : books) {
                String availabilityStatus = (book.isAvailable() ? "\u001B[32mYes" + ANSI_CYAN : "\u001B[31mNo" + ANSI_CYAN);
                System.out.printf("%-5d%-25s%-15s%-15s%-10s\n", book.getBookID(), book.getTitle(), book.getAuthor(), book.getGenre(), availabilityStatus);
            }
        }

    }
    public static void displayAddBook(Library library,  Scanner scanner) {
        System.out.println("--------------------------");
        System.out.println("\u001B[35m"+"        ADD BOOK"+"\u001B[36m");
        System.out.println("--------------------------");
        int bookId = Helper.getValidIntInput(scanner,"Book Id :");
        System.out.print("Book Title :");
        String bookTitle = scanner.next();
        System.out.print("Book Author :");
        String bookAuthor = scanner.next();

        System.out.print("Book Genre :");
        String bookGenre = scanner.next();
        char userChoice;

        do {
            System.out.print("Add this book [y/n]: ");
            userChoice = scanner.next().charAt(0);

            if (userChoice == 'y' || userChoice == 'Y') {
                Book newBook = new Book(bookId, bookTitle, bookAuthor, bookGenre);
                library.addBook(newBook);
                System.out.println("Book added!");
                // Do something with the newBook object, e.g., add it to a library
            } else if (userChoice == 'n' || userChoice == 'N') {
                System.out.println("Book not added.");
            } else {
                System.out.println("\u001B[31m" + "Invalid choice. Please enter 'y' or 'n'." + "\u001B[36m");
            }
        } while (userChoice != 'y' && userChoice != 'Y' && userChoice != 'n' && userChoice != 'N');

    }
    public static int getUserSelection(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("\u001B[31m" + "Invalid input. Please enter a number: " + ANSI_CYAN);
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    public static void displayErrorMessage(String message) {
        System.out.println("\u001B[31m" + message + ANSI_CYAN);
    }

    public static void displayRemoveBook(Library library,Scanner scanner) {
        System.out.println(ANSI_CYAN+"--------------------------");

        System.out.println( "\u001B[35m"+"Remove a Book"+ANSI_CYAN);
        System.out.println("--------------------------");
        List<Book> availableBooks = library.getALLBooks();
        if (availableBooks.isEmpty()) {

            System.out.println("\u001B[33m"+"No books available in the library."+ANSI_CYAN);
        } else {

            System.out.printf("\u001B[34m"+"%-5s%-25s%-15s%-15s%-15s\n", "ID", "Title", "Author", "Genre", "AVAILABLE"+ANSI_CYAN);
            for (Book book : availableBooks) {
                String availabilityStatus = (book.isAvailable() ? "\u001B[32mYes"+ANSI_CYAN : "\u001B[31mNo"+ANSI_CYAN);

                System.out.printf("%-5d%-25s%-15s%-15s%-10s\n",book.getBookID(),book.getTitle(),book.getAuthor(),book.getGenre(),availabilityStatus); // Assuming Book class has a proper toString() method
            }

            System.out.print("\u001B[36mEnter the ID of the book to remove (or 0 to cancel): ");
            int bookIDToRemove = scanner.nextInt();
            if (bookIDToRemove != 0) {
                Book bookToRemove = findBookById(bookIDToRemove, availableBooks);
                if (bookToRemove != null) {
                    library.removeBook(bookToRemove);
                    System.out.println("\u001B[32mBook removed successfully.\u001B[0m");
                } else {
                    System.out.println("\u001B[31mBook not found.\u001B[0m");
                }
            }
        }



    }
    public static void displayBorrowBook(Library library,Scanner scanner) {
        System.out.println(ANSI_CYAN+"--------------------------");

        System.out.println( "\u001B[35m"+"Borrow a Book"+ANSI_CYAN);
        System.out.println(ANSI_CYAN+"--------------------------");

        List<Book> availableBooks = library.getAvailableBooks();

        if (availableBooks.isEmpty()) {
            System.out.println("\u001B[33m" + "No books available to borrow in the library." + ANSI_CYAN);
        } else {
            System.out.printf(ANSI_CYAN + "%-5s%-25s%-15s%-15s\n", "ID", "Title", "Author", "Genre" + ANSI_CYAN);
            for (Book book : availableBooks) {
                System.out.printf("%-5d%-25s%-15s%-15s\n", book.getBookID(), book.getTitle(), book.getAuthor(), book.getGenre());
            }
            System.out.print("\u001B[36mEnter the ID (or 0 to cancel): ");
            int bookIDToBorrow = scanner.nextInt();
            if (bookIDToBorrow != 0) {
                Book bookToBorrow = findBookById(bookIDToBorrow, availableBooks);
                if (bookToBorrow != null) {
                    library.setBookAvailability(bookToBorrow, false);

                    System.out.println("\u001B[32mBook Borrowed successfully.\u001B[0m");
                } else {
                    System.out.println("\u001B[31mBook not found.\u001B[0m");
                }
            }
        }









    }
    public static void displayReturnBook(Library library,Scanner scanner) {
        System.out.println(ANSI_CYAN+"--------------------------");

        System.out.println( "\u001B[35m"+"Return a Book"+ANSI_CYAN);
        List<Book> borrowedBooks = library.getBorrowedBooks();

        if (borrowedBooks.isEmpty()) {
            System.out.println("\u001B[33m" + "No books available to borrow in the library." + ANSI_CYAN);
        } else {
            System.out.printf(ANSI_CYAN + "%-5s%-25s%-15s%-15s\n", "ID", "Title", "Author", "Genre" + ANSI_CYAN);
            for (Book book : borrowedBooks) {
                System.out.printf("%-5d%-25s%-15s%-15s\n", book.getBookID(), book.getTitle(), book.getAuthor(), book.getGenre());
            }
            System.out.print("\u001B[36mEnter the ID (or 0 to cancel): ");
            int bookIDToBorrow = scanner.nextInt();
            if (bookIDToBorrow != 0) {

                Book bookToBorrow = findBookById(bookIDToBorrow, borrowedBooks);
                if (bookToBorrow != null) {
                    library.setBookAvailability(bookToBorrow, true);

                    System.out.println("\u001B[32mBook returned successfully.\u001B[0m");
                } else {
                    System.out.println("\u001B[31mBook not found.\u001B[0m");
                }
            }
        }








    }














        private static Book findBookById(int bookID, List<Book> books) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }



}
