import java.time.LocalDate;
import java.time.LocalTime;

public class Comments {
 
    private String text;
    private String author;
    
        public Comments(String text, String author) {
            this.text = text;
            this.author = author;
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
    }

    public String getText() {
        return text;
    }
}
