package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private final List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> findPostsFor(String user) {
        List<Post> result = new ArrayList<>();
        for (Post post: posts) {
            if ( user.equals(post.getOwner())
                    && LocalDate.now().isAfter(post.getPublishedAt())
                    && !post.getContent().isEmpty()
                    && !post.getTitle().isEmpty()) {
                result.add(post);
            }
        }

        return result;
    }
}
