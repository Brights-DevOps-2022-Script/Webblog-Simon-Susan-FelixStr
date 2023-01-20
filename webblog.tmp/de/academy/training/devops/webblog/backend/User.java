package de.academy.training.devops.webblog.backend;

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
