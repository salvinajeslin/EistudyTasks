import command.*;
import observer.ACSystem;
import observer.LightSystem;
import singleton.OfficeManager;
import util.Logger;

import java.util.Scanner;

public class App {
    private static final Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        logger.info("Smart Office Application started.");
        OfficeManager officeManager = OfficeManager.getInstance();
        officeManager.addObserver(new LightSystem());
        officeManager.addObserver(new ACSystem());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Commands: config <roomCount>");
        System.out.println("           config_capacity <roomId> <maxCapacity>");
        System.out.println("           block <roomId> <HH:mm> <durationMinutes>");
        System.out.println("           cancel <roomId>");
        System.out.println("           occupant <roomId> <count>");
        System.out.println("           stats");
        System.out.println("           exit");

        while (running) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();
            try {
                switch (cmd) {
                    case "config" -> {
                        int count = Integer.parseInt(parts[1]);
                        officeManager.configureRooms(count);
                    }
                    case "config_capacity" -> {
                        int roomId = Integer.parseInt(parts[1]);
                        int cap = Integer.parseInt(parts[2]);
                        officeManager.setRoomCapacity(roomId, cap);
                    }
                    case "block", "book" -> {
                        int roomId = Integer.parseInt(parts[1]);
                        String time = parts[2];
                        int duration = Integer.parseInt(parts[3]);
                        Command c = new BookRoomCommand(roomId, time, duration);
                        c.execute();
                    }
                    case "cancel" -> {
                        int roomId = Integer.parseInt(parts[1]);
                        new CancelRoomCommand(roomId).execute();
                    }
                    case "occupant", "add_occupant" -> {
                        int roomId = Integer.parseInt(parts[1]);
                        int count = Integer.parseInt(parts[2]);
                        new AddOccupantCommand(roomId, count).execute();
                    }
                    // In your App.java command loop, add:
                    case "stats"-> {
                        officeManager.printRoomUsageStats();
                    }

                    case "exit" -> {
                        running = false;
                        officeManager.shutdown();
                        logger.info("Shutting down Smart Office Application.");
                        System.out.println("Exiting.");
                    }
                    default -> {
                        logger.warn("Invalid command entered: " + cmd);
                        System.out.println("Invalid command.");
                    }
                }
            } catch (Exception e) {
                logger.error("Error processing command: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
