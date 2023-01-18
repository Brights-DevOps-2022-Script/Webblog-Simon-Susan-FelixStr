package de.academy.training.devops.webblog.frontend;

import java.util.Scanner;

import de.academy.training.devops.webblog.backend.*;
import de.academy.training.devops.webblog.persistence.*;

public class App {

    public static void main(String[] args) throws Exception {

        DataStore dataStore = new DataStore();
        Scanner userInput = new Scanner(System.in);

        System.out.println("********************Welcome on the SuSiFe-Website!********************");
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Create a new post");
            System.out.println("2. Show all posts");
            System.out.println("3. Add a comment to a post");
            System.out.println("4. Show me a post and its comments");
            // System.out.println("5. Show me how much comments a post has");
            System.out.println("9. Delete a post (admin only)");
            System.out.println("0. Exit");
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
                dataStore.showAllPosts();

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
                System.out.println("Which Post do you want to see?");
                int postId = userInput.nextInt();
                dataStore.showPostAndComments(postId);

            } else if (choice == 9) {
                System.out.println("Enter the admin password:");
                String enteredPassword = userInput.nextLine();
                if (!enteredPassword.equals(dataStore.expectedPassword)) {
                    System.out.println("Wrong password!");
                    continue;
                }
                System.out.println("Enter the id of the post you want to delete:");
                int postId = userInput.nextInt();
                dataStore.deletePost(postId);

            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        userInput.close();
    }
}