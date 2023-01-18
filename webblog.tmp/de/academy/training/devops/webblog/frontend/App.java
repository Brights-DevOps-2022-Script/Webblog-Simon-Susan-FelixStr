package de.academy.training.devops.webblog.frontend;

import java.util.Scanner;
import de.academy.training.devops.webblog.backend.*;


public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("********************Welcome on the SuSiFe-Website!********************");

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter Name: ");
            String author = input.nextLine();
            System.out.println("Enter Title: ");
            String title = input.nextLine();
            System.out.println("Enter Text: ");
            String text = input.nextLine();
            Post post = new Post(title, text, author);
            System.out.println(post.getFormattedDateTime());

            System.out.println("Enter comment: ");
            String commentText = input.nextLine();
            Comment comment = new Comment(commentText, author);
            post.addComment(comment);
            System.out.println(post.getFormattedDateTime());

        }

    }
}
