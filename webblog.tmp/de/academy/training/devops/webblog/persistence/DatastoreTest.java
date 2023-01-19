package de.academy.training.devops.webblog.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import de.academy.training.devops.webblog.backend.Post;
import de.academy.training.devops.webblog.backend.Comment;

public class DatastoreTest {

    @Test
    public void testcreatePost() {
        // test vorbereiten
        DataStore dataStore = new DataStore();

        // test logik
        dataStore.createPost("test title", "test text", "test author");

        Post post = dataStore.getPost(1);

        // test erwartung
        assertEquals("test title", post.getTitle());
        assertEquals("test text", post.getText());
        assertEquals("test author", post.getAuthor());
    }

    @Test
    public void testaddComment() {
        // test vorbereiten
        DataStore dataStore = new DataStore();

        // test logik
        dataStore.createPost("test title", "test text", "test author");
        dataStore.addComment(1, new Comment("test text", "test author"));
        ArrayList<Comment> comment = dataStore.getComments(1);

        // test erwartung
        assertEquals("test text", comment.get(0).getText());
        assertEquals("test author", comment.get(0).getAuthor());
    }

    @Test
    public void testaddDoubleComment() {
        // test vorbereiten
        DataStore dataStore = new DataStore();

        // test logik
        dataStore.createPost("test title", "test text", "test author");
        dataStore.addComment(1, new Comment("test text", "test author"));
        dataStore.addComment(1, new Comment("test text2", "test author2"));
        ArrayList<Comment> comment = dataStore.getComments(1);

        // test erwartung
        assertEquals("test text2", comment.get(1).getText());
        assertEquals("test author2", comment.get(1).getAuthor());

    }

    @Test
    public void testshowAllPosts() {
        // test vorbereitung
        DataStore dataStore = new DataStore();

        dataStore.createPost("title1", "text1", "author1");
        dataStore.createPost("title2", "text2", "author2");
        dataStore.createPost("title3", "text3", "author3");
        dataStore.createPost("title4", "text4", "author4");
        dataStore.createPost("title5", "text5", "author5");

        // test logik
        dataStore.postMap.size();

        // test erwartung
        assertEquals(5, dataStore.postMap.size());

    }
}
