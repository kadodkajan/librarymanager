import java.util.Scanner;
import java.util.List;

public class Main {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static Library library = new Library();

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayMenu(scanner);



        scanner.close();
    }

    private static void displayMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 9) {
            System.out.println(ANSI_CYAN+"--------------------------");

            System.out.println( "\u001B[35m"+"Welcome to Library Manager"+ANSI_CYAN);
            System.out.println("--------------------------");
            System.out.println("01: LIBRARY");
            System.out.println("02: USERS");
            System.out.println("09: EXIT");

            System.out.println("-------------");
            System.out.print("SELECT: ");
            userSelection = getUserSelection(scanner);

            switch (userSelection) {
                case 1:
                    handleLibraryMenu(scanner);
                    break;
                case 2:
                    handleUsersMenu(scanner);
                    break;
                case 9:
                    //
                    break;

                default:
                    System.out.println(ANSI_RED + "Invalid selection. Please enter a number between 1 and 6." + ANSI_CYAN);
                    break;
            }
        }
    }



    private static void handleLibraryMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 6) {
            System.out.println("--------------------------");
            System.out.println("\u001B[35m"+"        LIBRARY"+ANSI_CYAN);
            System.out.println("--------------------------");
            System.out.println("01: VIEW ALL BOOKS");
            System.out.println("02: ADD BOOK");
            System.out.println("03: REMOVE BOOK");
            System.out.println("04: BORROW BOOK");
            System.out.println("05: RETURN BOOK");
            System.out.println("06: BACK MENU");

            System.out.println("-------------");
            System.out.print("SELECT: ");

            userSelection = getUserSelection(scanner);

            switch (userSelection) {
                case 1:
                    System.out.println(ANSI_CYAN+"--------------------------");
                    System.out.println( "\u001B[35m"+"Books in the Library "+ANSI_CYAN);
                    System.out.println("--------------------------");
                    viewBooks();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    removeBook(scanner);
                break;
                case 4:
                    // Handle BORROW BOOK
                    break;
                case 5:
                    // Handle RETURN BOOK
                    break;
                case 6:
                    // Handle BACK MENU (Optional: You can break or do nothing as the loop will exit)
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid selection. Please enter a number between 1 and 6." + ANSI_CYAN);
                    break;
            }
        }
    }
    private static void handleUsersMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 6) {
            System.out.println("--------------------------");
            System.out.println("\u001B[35m" + "      USERS" + ANSI_CYAN);
            System.out.println("--------------------------");
            System.out.println("01: VIEW ALL USERS");
            System.out.println("02: ADD USER");
            System.out.println("03: REMOVE USER");
            System.out.println("-------------");
            System.out.print("SELECT: ");
            userSelection = getUserSelection(scanner);

            switch (userSelection) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    System.out.println(ANSI_RED + "Invalid selection. Please enter a number between 1 and 6." + ANSI_CYAN);
                    break;
            }

        }
    }
    private static int getUserSelection(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print(ANSI_RED + "Invalid input. Please enter a number: " + ANSI_CYAN);
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }


    private static void addBook(Scanner scanner) {
        System.out.println("--------------------------");
        System.out.println("\u001B[35m"+"        ADD BOOK"+ANSI_CYAN);
        System.out.println("--------------------------");
        System.out.print("Book Id :");
        int bookId = scanner.nextInt();
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
                System.out.println(ANSI_RED + "Invalid choice. Please enter 'y' or 'n'." + ANSI_CYAN);
            }
        } while (userChoice != 'y' && userChoice != 'Y' && userChoice != 'n' && userChoice != 'N');

    }



    private static void viewBooks() {


        List<Book> availableBooks = library.getALLBooks();
        if (availableBooks.isEmpty()) {

            System.out.println("\u001B[33m"+"No books available in the library."+ANSI_CYAN);
        } else {

            System.out.printf("\u001B[34m"+"%-5s%-25s%-15s%-15s%-15s\n", "ID", "Title", "Author", "Genre", "AVAILABLE"+ANSI_CYAN);
            for (Book book : availableBooks) {
                String availabilityStatus = (book.isAvailable() ? "\u001B[32mYes"+ANSI_CYAN : "\u001B[31mNo"+ANSI_CYAN);

                System.out.printf("%-5d%-25s%-15s%-15s%-10s\n",book.getBookID(),book.getTitle(),book.getAuthor(),book.getGenre(),availabilityStatus); // Assuming Book class has a proper toString() method
            }
        }
        System.out.print("\nPress any key to continue...");
        new Scanner(System.in).nextLine();

    }
    private static void removeBook(Scanner scanner) {
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
    private static Book findBookById(int bookID, List<Book> books) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    }
