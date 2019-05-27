package pl.tss.DAO;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import pl.tss.Model.Post;
import pl.tss.Model.User;
import pl.tss.Provider.ConnectionProvider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostDAOImpl implements PostDAO {

    private static final String CREATE_POST =
            "INSERT INTO posts(title, content, user_name) VALUES(:title, :content, :user_name);";
    private static final String READ_ALL_POSTS =
            "SELECT user.user_name, password, id_post, title, content FROM posts LEFT JOIN user ON posts.user_name=user.user_name;";
    private static final String READ_POST =
            "SELECT user.user_name, password, id_post, title, content FROM posts LEFT JOIN user ON posts.user_name=user.user_name HAVING id_post=:id_post;";
    private final static String DELETE =
            "DELETE FROM posts WHERE id_post=:id_post;";
    private final static String UPDATE =
            "UPDATE posts SET title=:title, content=:content WHERE id_post = :id_post;";

    private NamedParameterJdbcTemplate template;

    public PostDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Post create(Post newObject) {
        Post post = new Post(newObject);
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("title",newObject.getTitle());
        paramMap.put("content",newObject.getContent());
        paramMap.put("user_name",newObject.getUser().getUser_name());
        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_POST,parameterSource,holder);

        if(update>0){
            post.setId(holder.getKey().longValue());
        }

        return post;
    }

    @Override
    public Post read(Long primaryKey) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("id_post",primaryKey);
        List<Post> posts = template.query(READ_POST, namedParameter, new PostRowMapper());
        int i = posts.size();
        return posts.get(i-1);
    }

    @Override
    public boolean update(Post updateObject) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("title",updateObject.getTitle());
        paramMap.put("content",updateObject.getContent());
        paramMap.put("id_post",updateObject.getId());
        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        template.update(UPDATE, parameterSource);
        return true;
    }

    @Override
    public boolean delete(Long key) {
        Post post = read(key);
        SqlParameterSource namedParameter = new MapSqlParameterSource("id_post", post.getId());
        template.update(DELETE,namedParameter);
        return true;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = template.query(READ_ALL_POSTS, new PostRowMapper());
        return posts;
    }

    private class PostRowMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet resultSet, int row) throws SQLException {
            Post post = new Post();
            post.setId(resultSet.getLong("id_post"));
            post.setTitle(resultSet.getString("title"));
            post.setContent(resultSet.getString("content"));
            User user = new User();
            user.setUser_name(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            post.setUser(user);
            return post;
        }
    }
}
