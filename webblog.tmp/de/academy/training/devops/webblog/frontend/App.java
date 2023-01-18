package de.academy.training.devops.webblog.frontend;

import java.util.Scanner;
import de.academy.training.devops.webblog.backend.*;
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
            System.out.println("Do you want to comment a post?");
            System.out.println("3. Exit");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if (choice == 1) {
                System.out.println("Please enter the title of your post:");
                String title = userInput.nextLine();
                System.out.println("Please enter the text of your post:");
                String text = userInput.nextLine();
                System.out.println("Please enter your name:");
                String author = userInput.nextLine();
                Post post = new Post(title, text, author);
                System.out.println(post.getFormattedDateTime());
                dataStore.addPost(post);
                System.out.println("--------------------Your post has been created!--------------------");
            } else if (choice == 2) {
                System.out.println("All posts:");
                for (int i = 1; i < dataStore.nextPostId; i++) {
                    Post post = dataStore.getPost(i);
                    System.out.println("ID: " + i);
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Text: " + post.getText());
                    System.out.println("Author: " + post.getAuthor());
                    System.out.println("Comments: " + post.getComments());
                    System.out.println("Date: " + post.getFormattedDateTime());
                    System.out.println("--------------------------------------------------");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        userInput.close();
    }
}