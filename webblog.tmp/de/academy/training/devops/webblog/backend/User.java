package de.academy.training.devops.webblog.backend;

import java.util.Scanner;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        if (this.username.equals("user") && this.password.equals("123")) {
            return true;
        } else {
            return false;
        }
    }

    public static User prompt() {
        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = userInput.nextLine();
        System.out.println("Please enter your password:");
        String password = userInput.nextLine();
        return new User(username, password);
    }

}
