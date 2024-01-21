package library.view;
import java.util.Scanner;


public class Helper {
    public static int getValidIntInput(Scanner scanner, String prompt) {
        int userInput = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                userInput = scanner.nextInt();
                validInput = true; // If no exception occurred, input is valid
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return userInput;
    }

}
