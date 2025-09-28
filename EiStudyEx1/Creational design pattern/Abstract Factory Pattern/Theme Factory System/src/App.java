import client.ThemeApplication;
import factory.AbstractThemeFactory;
import factory.LightThemeFactory;
import factory.DarkThemeFactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\nSelect Theme:");
                System.out.println("1. Light Theme");
                System.out.println("2. Dark Theme");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                AbstractThemeFactory themeFactory = null;

                switch (choice) {
                    case 1:
                        themeFactory = new LightThemeFactory();
                        break;
                    case 2:
                        themeFactory = new DarkThemeFactory();
                        break;
                    case 3:
                        running = false;
                        continue;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        continue;
                }

                ThemeApplication app = new ThemeApplication(themeFactory);
                app.renderUI();

                // Ask every time
                System.out.print("Do you want to continue? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("yes")) {
                    running = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        System.out.println("Exiting application. Goodbye!");
        scanner.close();
    }
}
