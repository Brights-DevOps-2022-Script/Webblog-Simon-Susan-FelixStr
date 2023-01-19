package de.academy.training.devops.webblog.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import de.academy.training.devops.webblog.backend.Post;
import de.academy.training.devops.webblog.persistence.DataStore;

public class DatastoreTest {
    
    // test vorbereiten
    @Test
    public void testcreatePost() {
        DataStore dataStore = new DataStore();

        dataStore.createPost("test title", "test text", "test author");

        Post post = dataStore.getPost(1);

        //test erwartung
        assertEquals("test title", post.getTitle());
        assertEquals("test text", post.getText());
        assertEquals("test author", post.getAuthor());
    }


}
