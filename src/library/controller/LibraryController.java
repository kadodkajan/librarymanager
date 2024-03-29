package library.controller;
import library.model.Book;
import library.model.Library;
import java.util.Scanner;

import library.view.ConsoleView;

public class LibraryController {
    private Library library;
    private ConsoleView view;

    public LibraryController(Library library, ConsoleView view) {
        this.library = library;
        this.view = view;
    }

    public void handleMainMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 9) {
            view.displayMainMenu();
            userSelection = view.getUserSelection(scanner);

            switch (userSelection) {
                case 1:
                    handleLibraryMenu(scanner);
                    break;
                case 2:
                    handleUsersMenu(scanner);
                    break;
                case 9:
                    // Handle exit
                    break;
                default:
//                    view.displayErrorMessage("Invalid selection. Please enter a number between 1 and 9.");
                    break;
            }
        }
    }

    public void handleUsersMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 4) {
            ConsoleView. displayUsersMenu();
            userSelection = ConsoleView.getUserSelection(scanner);

            switch (userSelection) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;

                default:
                    break;
            }
        }
    }

    public void handleLibraryMenu(Scanner scanner) {
        int userSelection = 0;

        while (userSelection != 6) {
            ConsoleView.displayLibraryMenu();
            userSelection = ConsoleView.getUserSelection(scanner);

            switch (userSelection) {
                case 1:
                    ConsoleView.displayBooks(library.getALLBooks());
                    System.out.print("\nPress any key to continue...");
                    new Scanner(System.in).nextLine();
                    break;
                case 2:
                    ConsoleView.displayAddBook(library,scanner);
                    break;
                case 3:
                    ConsoleView.displayRemoveBook(library,scanner);
                    break;
                case 4:
                    ConsoleView.displayBorrowBook(library,scanner);
                    break;
                case 5:
                    ConsoleView.displayReturnBook(library,scanner);
                    break;
                case 6:
                    // Handle back to main menu
                    break;
                default:
//                    view.displayErrorMessage("Invalid selection. Please enter a number between 1 and 6.");
                    break;
            }
        }    }
}
