package pl.tss.Service;

import pl.tss.DAO.MysqlDAO;
import pl.tss.DAO.PostDAO;
import pl.tss.Model.Post;
import pl.tss.Model.User;

import java.util.Comparator;
import java.util.List;

public class PostService {

    public void addPost(String title, String content, User user) {
        System.out.println("PostService");
        Post post = createDiscoveryObject(title, content, user);
        MysqlDAO mysql = new MysqlDAO();
        PostDAO postDao = mysql.getPostDAO();
        postDao.create(post);
    }

    private Post createDiscoveryObject(String title, String content, User user) {
        Post post= new Post();
        post.setTitle(title);
        post.setContent(content);
        User userCopy = new User(user);
        post.setUser(userCopy);
        return post;
    }

    public List<Post> getAllPosts() {
        return getAllPosts(null);
    }

    public List<Post> getAllPosts(Comparator<Post> comparator) {
        MysqlDAO mysql = new MysqlDAO();
        PostDAO postDao = mysql.getPostDAO();
        List<Post> posts = postDao.getAll();
        if(comparator != null && posts != null) {
            posts.sort(comparator);
        }
        return posts;
    }

    public void delete(Long id){
        MysqlDAO mysql = new MysqlDAO();
        PostDAO postDao = mysql.getPostDAO();
        postDao.delete(id);
    }

    public Post read(Long id){
        MysqlDAO mysql = new MysqlDAO();
        PostDAO postDao = mysql.getPostDAO();
        return postDao.read(id);
    }

    public void update(Post post){
        MysqlDAO mysqlDAO = new MysqlDAO();
        PostDAO postDAO = mysqlDAO.getPostDAO();
        postDAO.update(post);
    }
}
