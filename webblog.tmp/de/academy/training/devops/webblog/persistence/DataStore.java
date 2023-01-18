package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Post;
import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private Map<Integer, Post> postMap;
    public int nextPostId = 1;

    public DataStore() {
        postMap = new HashMap<>();
    }

    public void addPost(Post post) {
        postMap.put(nextPostId, post);
        nextPostId++;
    }

    public Post getPost(int id) {
        return postMap.get(id);
    }
}
