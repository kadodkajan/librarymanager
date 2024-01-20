import library.controller.LibraryController;
import library.model.Book;
import library.model.Library;
import library.view.ConsoleView;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        System.out.print("here");
        ConsoleView view = new ConsoleView();
        LibraryController controller = new LibraryController(library, view);

        controller.handleMainMenu(scanner);

        scanner.close();
    }
}