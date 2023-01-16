import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;



public class Post{

    private String title;
    private String text;
    private String author;
    private ArrayList<Comments> comment;

    

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.comment = new ArrayList<Comments>();

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
    
    public String getAuthor() {
        return author;
    }
    public ArrayList<Comments> getComments() {
        return comment;


        }
    private ArrayList<Comments> comments;
    public void addComment(Comments comment) {
        comments.add(comment);
}}
