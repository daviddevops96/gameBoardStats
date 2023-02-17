package org.teamcifo.logic;

import org.teamcifo.domain.User;
import java.util.Scanner;

public class LogIn {
    private UserManager userManager;
    private Scanner scanner;

    public LogIn(UserManager userManager) {
        //this.authService = authService;
        this.userManager= userManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Please log in or register:");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void login() {
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userManager.authenticate(userId, password)) {
            System.out.println("Login successful.");
            showMenu();
        } else {
            System.out.println("Invalid user ID or password.");
        }
    }

    private void register() {
        User user = new User();
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();


        if (userManager.getUser(userId)==null) {
            user.setUserId(userId);
            user.setPassword(password);
            user.setName(name);
            System.out.println("Registration successful. Please log in.");
        } else {
            System.out.println("User ID already in use.");
        }
    }
    //private void
    public boolean showMenu() {
        while (true) {
            System.out.println("Welcome to the game collection app.");
            System.out.println("1. View my games");
            System.out.println("2. Add a game");
            System.out.println("3. Remove a game");
            System.out.println("4. Log out");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewGames();
                    break;
                case "2":
                    addGame();
                    break;
                case "3":
                    removeGame();
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return false;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void viewGames() {
        // Display the user's game collection
    }

    private void addGame() {
        // Add a game to the user's collection
    }

    private void removeGame() {
        // Remove a game from the user's collection
    }
    public <InputStream> void setInputSource(InputStream inputStream) {
        this.scanner = new Scanner((Readable) inputStream);
    }
}

