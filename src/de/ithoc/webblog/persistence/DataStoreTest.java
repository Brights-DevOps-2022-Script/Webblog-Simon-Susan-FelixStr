package de.ithoc.webblog.persistence;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import de.ithoc.webblog.model.Post;

public class DataStoreTest {
    
    @Test
    public void save_post() {

        Post post = new Post();

        DataStore dataStore = new DataStore();
        Post savedPost = dataStore.save(post);

        Assert.assertSame(post.getId(), savedPost.getId());
    }

    @Test
    public void check_unique_ids() {
        Post post1 = new Post();
        Post post2 = new Post();

        DataStore dataStore = new DataStore();
        Post savedPost1 = dataStore.save(post1);
        Post savedPost2 = dataStore.save(post2);

        Assert.assertTrue(savedPost1.getId() == savedPost2.getId() -1);

    }

    @Test
    public void get_post() {
        
        // TODO Implement get test method.

        Assert.fail("Get test method shall be implemented.");
    }

}
