import model.Student;
import util.AppLogger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        boolean running = true;

        while (running) {
            try {
                System.out.println("\n--- Student Registration System (Builder Pattern) ---");
                System.out.println("1. Register New Student");
                System.out.println("2. View All Students");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        try {
                            Student student = registerStudent(scanner);
                            studentList.add(student);
                            AppLogger.info("Student registered successfully: " + student);
                        } catch (Exception e) {
                            AppLogger.error("Error while registering student", e);
                        }
                    }
                    case 2 -> {
                        if (studentList.isEmpty()) {
                            System.out.println("No students registered yet.");
                        } else {
                            studentList.forEach(System.out::println);
                        }
                    }
                    case 3 -> {
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                        continue; // skip asking yes/no
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }

                // Ask user if they want to continue
                if (running) {
                    System.out.print("Do you want to continue? (yes/no): ");
                    String answer = scanner.nextLine().trim().toLowerCase();
                    if (!answer.equals("yes")) {
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                    }
                }

            } catch (InputMismatchException e) {
                AppLogger.error("Invalid input type", e);
                scanner.nextLine(); // clear buffer
            } catch (Exception e) {
                AppLogger.error("Unexpected error occurred", e);
            }
        }

        scanner.close();
    }

    private static Student registerStudent(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter GPA (0.0 - 10.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new Student.Builder()
                .setName(name)
                .setAge(age)
                .setDepartment(department)
                .setGpa(gpa)
                .setEmail(email)
                .build();
    }
}
