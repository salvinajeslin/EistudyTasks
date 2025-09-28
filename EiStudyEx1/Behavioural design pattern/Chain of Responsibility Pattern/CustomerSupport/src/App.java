import handler.*;
import model.SupportRequest;
import utils.Logger;

import java.util.Scanner;

public class App {
    private static boolean running = true;

    public static void main(String[] args) {
        Logger.log("CustomerSupportChain system starting...");

        SupportHandler levelOne = new LevelOneSupport();
        SupportHandler levelTwo = new LevelTwoSupport();
        SupportHandler levelThree = new LevelThreeSupport();

        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(levelThree);

        Scanner scanner = new Scanner(System.in);

        while (running) {
            try {
                Logger.log("\nEnter support level (1, 2, 3) or 0 to exit:");
                int level = Integer.parseInt(scanner.nextLine());

                if (level == 0) {
                    running = false;
                    Logger.log("Exiting system...");
                    break;
                }

                Logger.log("Enter your support message:");
                String message = scanner.nextLine();

                SupportRequest request = new SupportRequest(level, message);
                levelOne.handleRequest(request);

            } catch (NumberFormatException e) {
                Logger.log("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                Logger.log("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
