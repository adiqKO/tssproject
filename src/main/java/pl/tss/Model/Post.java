package pl.tss.Model;

import java.util.Objects;

public class Post {

    private long id;
    private String title;
    private String content;
    private User user;

    public Post(){}

    public Post(Post post) {
        this.id = post.id;
        this.title = post.title;
        this.content = post.content;
        this.user = post.user;
    }

    public Post(long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                title.equals(post.title) &&
                content.equals(post.content) &&
                user.equals(post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}
