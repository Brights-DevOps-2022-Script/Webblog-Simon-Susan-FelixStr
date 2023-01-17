package de.ithoc.webblog.persistence;

import java.util.HashMap;
import java.util.Map;

import de.ithoc.webblog.model.Post;

/**
 * Storage to keep the posts with their IDs as key.
 */
public class DataStore {
    
    private Map<Integer, Post> map = new HashMap<>();

    /* Store last maximum index to ensure IDs are unique. */
    private Integer maxIndex = 0;


    /**
     * Saves a new post object for which the id is unset.
     * In case the ID is already set, nothing happens and
     * the post object will just be returned.
     * 
     * @param post Newly created post object to be saved.
     */
    public Post save(Post post) {
        if(post.getId() != null) {
            return post;
        }

        maxIndex = maxIndex + 1; // equivalent: maxIndex++
        post.setId(maxIndex);
        map.put(post.getId(), post);

        return post;
    }
    
    public Post get(Integer id) {
        return map.get(id);
    }


    /**
     * Updates a given post object in the storage. In case 
     * the ID is unset, no update will take place and 
     * the post object is just returned as is.
     */
    public Post update(Post post) {

        // TODO Implement this update method.

        return null;
    }

}
