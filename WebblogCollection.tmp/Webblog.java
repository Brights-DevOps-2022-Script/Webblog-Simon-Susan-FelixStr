import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import java.time.LocalTime;

public class Webblog{

    public static void main (String[] args) throws Exception{
    
        
        System.out.println("********************Welcome on the SuSiFe-Website!********************");

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter Name: ");
            String author = input.nextLine();
            System.out.println("Enter Title: ");
            String title = input.nextLine();
            System.out.println("Enter Text: ");
            String text = input.nextLine();
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            Post post = new Post(title, text, author);
            System.out.println("Enter comment: ");
            String commentText = input.nextLine();
            Comments comment = new Comments(commentText, author);
            post.addComment(comment);
        }
        
}}
