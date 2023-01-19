package de.academy.training.devops.webblog.backend;

import java.util.Scanner;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User promptForCred() {
        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = userInput.nextLine();
        System.out.println("Enter your password:");
        String password = userInput.nextLine();
        return new User(username, password);
    }

    public boolean login() {
        if (this.username.equals("user") && this.password.equals("123")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean adminpassword(String adminPassword) {
        if (adminPassword.equals("admin")) {
            System.out.println("Enter the ID of the Post you want to delete:");
            return true;
        } else {
            System.out.println("Wrong password!");
            return false;
        }
    }

}
