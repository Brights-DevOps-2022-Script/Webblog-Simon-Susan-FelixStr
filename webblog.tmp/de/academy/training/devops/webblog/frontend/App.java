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
            System.out.println("3. Show me a post and its comments");
            System.out.println("4. Add a comment to a post");
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
                dataStore.showAllPosts();

            } else if (choice == 3) {
                System.out.println("Which Post do you want to see?");
                int postId = userInput.nextInt();
                dataStore.showPostAndComments(postId);

            } else if (choice == 4) {
                System.out.println("Which Post do you want to comment?");
                int postID = userInput.nextInt();
                userInput.nextLine();
                System.out.println("What is your name?");
                String commentauthor = userInput.nextLine();
                System.out.println("Type your comment:");
                String commenttext = userInput.nextLine();
                Comment comment = new Comment(commenttext, commentauthor);
                Post post = dataStore.getPost(postID);
                post.addComment(comment);
                System.out.println("--------------------Your comment has been created!--------------------");

            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        userInput.close();
    }
}