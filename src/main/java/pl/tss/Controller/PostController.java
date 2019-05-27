package pl.tss.Controller;

import pl.tss.Model.Post;
import pl.tss.Service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        List<Post> allPosts = postService.getAllPosts();
        request.setAttribute("posts", allPosts);
        request.getRequestDispatcher("posts.jsp").forward(request, response);
    }
}
