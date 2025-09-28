import coffee.*;
import decorator.*;
import java.io.File;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            setupLogger();

            logger.info("StarBuzz Coffee Shop Application Started");

            Scanner scanner = new Scanner(System.in);
            boolean runApp = true;

            System.out.println("========================================");
            System.out.println(" Welcome to StarBuzz Coffee Shop ☕ ");
            System.out.println("========================================");

            while (runApp) {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Espresso");
                System.out.println("2. House Blend");
                System.out.println("3. Exit");

                System.out.print("Choose your coffee (1-3): ");
                String choice = scanner.nextLine();

                Beverage beverage;
                switch (choice) {
                    case "1" -> beverage = new Espresso();
                    case "2" -> beverage = new HouseBlend();
                    case "3" -> {
                        runApp = false;
                        logger.info("Application exited by user.");
                        System.out.println("Thank you for visiting StarBuzz Coffee Shop ☕");
                        continue;
                    }
                    default -> {
                        System.out.println("❌ Invalid choice. Please try again.");
                        continue;
                    }
                }

                System.out.println("\nAdd condiments:");
                System.out.println("1. Milk");
                System.out.println("2. Mocha");
                System.out.println("3. No Condiment");

                System.out.print("Your choice (1-3): ");
                String condimentChoice = scanner.nextLine();

                switch (condimentChoice) {
                    case "1" -> beverage = new Milk(beverage);
                    case "2" -> beverage = new Mocha(beverage);
                    case "3" -> {}
                    default -> System.out.println("❌ Invalid condiment choice. Skipping condiments.");
                }

                System.out.println("\n--- Order Summary ---");
                System.out.println("Order: " + beverage.getDescription());
                System.out.printf("Total cost: $%.2f\n", beverage.cost());

                logger.info("Order placed: " + beverage.getDescription() + " - Cost: $" + beverage.cost());

                System.out.println("\nPress ENTER to continue...");
                scanner.nextLine(); // Pause so user sees the output
            }

        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void setupLogger() throws Exception {
        File logDir = new File("logs");
        if (!logDir.exists()) logDir.mkdir();

        Handler fileHandler = new FileHandler("logs/application.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(fileHandler);
    }
}
