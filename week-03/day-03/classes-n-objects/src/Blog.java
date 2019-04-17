import java.util.ArrayList;
import java.util.List;

public class Blog {

  private List<BlogPost> blogPosts = new ArrayList<>();

  void add(BlogPost blogPost) {
    blogPosts.add(blogPost);
  }

  void delete(int i) {
    blogPosts.remove(i);
  }

  void update(int i, BlogPost blogPost) {
    blogPosts.set(i, blogPost);
  }

}
