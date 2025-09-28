import proxy.Image;
import proxy.ProxyImage;
import util.Logger;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Logger.log("Starting Eistudy Proxy Pattern Example...");

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Proxy Pattern Menu ---");
            System.out.println("1. Display Image");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter image file name (e.g., image.jpg): ");
                    String fileName = scanner.nextLine();
                    Image image = new ProxyImage(fileName);
                    image.display();
                    break;
                case "2":
                    Logger.log("Exiting program...");
                    isRunning = false;
                    break;
                default:
                    Logger.error("Invalid choice.");
            }
        }
        scanner.close();
    }
}
