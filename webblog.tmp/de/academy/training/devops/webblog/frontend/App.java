package de.academy.training.devops.webblog.frontend;

import java.util.ArrayList;
import java.util.Scanner;
import de.academy.training.devops.webblog.backend.*;
import de.academy.training.devops.webblog.persistence.DataStore;

public class App {

    public static void main(String[] args) throws Exception {

        DataStore dataStore = new DataStore();
        Scanner userInput = new Scanner(System.in);

        System.out.println();
        System.out.println("******************** Welcome on the SuSiFe-Website! ********************" + "\n"
                + "\n" + "------------ Please login first to be a part of the Webblog ------------");
        System.out.println("Please enter your username:");
        String username = userInput.nextLine();
        System.out.println("Please enter your password:");
        String password = userInput.nextLine();
        User user = new User(username, password);
        boolean result = user.login();
        if (result) {
            System.out.println("---Login successful!---");
        } else {
            System.out.println("---Login failed!---");
            System.exit(0);
        }

        System.out.println();
        System.out.println("******************** Menu ********************");
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Create a new post");
            System.out.println("2. Show all posts");
            System.out.println("3. Do you want to comment a post?");
            System.out.println("4. Show a specific post with all it's comments");
            System.out.println("5. Exit");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if (choice == 1) {
                System.out.println("Please enter the title of your post:");
                String title = userInput.nextLine();
                System.out.println("Please enter the text of your post:");
                String text = userInput.nextLine();
                System.out.println("Please enter your name:");
                String author = userInput.nextLine();
                dataStore.createPost(title, text, author);
            } else if (choice == 2) {
                System.out.println("All posts:");
                for (int i = 1; i < dataStore.nextPostId; i++) {
                    Post post = dataStore.getPost(i);
                    System.out.println("ID: " + i);
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Text: " + post.getText());
                    System.out.println("Author: " + post.getAuthor());
                    System.out.println("Date: " + post.getFormattedDateTime());
                    System.out.println("--------------------------------------------------");
                }

            } else if (choice == 3) {
                System.out.println("Enter the ID of the Post you want to comment:");
                int postID = userInput.nextInt();
                userInput.nextLine();
                System.out.println("Add your username:");
                String commentauthor = userInput.nextLine();
                System.out.println("Type your comment:");
                String commenttext = userInput.nextLine();
                Comment comment = new Comment(commenttext, commentauthor);
                dataStore.addComment(postID, comment);

            } else if (choice == 4) {
                System.out.println("Enter the ID of the Post you want to read with comments");
                int postID = userInput.nextInt();
                Post post = dataStore.getPost(postID);
                System.out.println("Post-ID: " + postID);
                System.out.println("Title: " + post.getTitle());
                System.out.println("Author: " + post.getAuthor());
                System.out.println("Post: " + post.getText());
                System.out.println("Date: " + post.getFormattedDateTime());
                System.out.println("---------Comment(s)------------");

                ArrayList<Comment> comments = dataStore.getComments(postID);
                for (Comment comment : comments) {
                    System.out.println("Author: " + comment.getAuthor());
                    System.out.println("Comment: " + comment.getText());
                    System.out.println("Date: " + comment.getFormattedDateTime());
                }

            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        userInput.close();
    }
}
