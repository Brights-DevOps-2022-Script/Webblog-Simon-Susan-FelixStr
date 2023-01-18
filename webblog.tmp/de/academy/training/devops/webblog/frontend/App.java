package de.academy.training.devops.webblog.frontend;

import java.util.Scanner;
import de.academy.training.devops.webblog.persistence.DataStore;

public class App {

    public static void main(String[] args) throws Exception {

        DataStore dataStore = new DataStore();
        Scanner userInput = new Scanner(System.in);

        System.out.println("********************Welcome on the SuSiFe-Website!********************");
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Create a new post");
            System.out.println("2. Show all posts");
            System.out.println("3. Do you want to comment a post?");
            System.out.println("4. Exit");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if (choice == 1) {
                System.out.println("Please enter the title of your post:");
                String title = userInput.nextLine();
                System.out.println("Please enter the text of your post:");
                String text = userInput.nextLine();
                System.out.println("Please enter your name:");
                String author = userInput.nextLine();
                dataStore.createAndSavePost(title, text, author);
            } else if (choice == 2) {
                System.out.println("All posts:");
                dataStore.showAllPosts();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        userInput.close();
    }
}