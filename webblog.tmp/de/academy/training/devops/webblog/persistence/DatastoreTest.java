package de.academy.training.devops.webblog.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import de.academy.training.devops.webblog.backend.Post;

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

}
