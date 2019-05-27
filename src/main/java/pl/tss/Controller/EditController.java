package pl.tss.Controller;

import pl.tss.Model.Post;
import pl.tss.Service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("inputId");
        PostService postService = new PostService();
        Post post = postService.read(Long.valueOf(id));
        request.setAttribute("post", post);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("inputId");
        String title = request.getParameter("inputTitle");
        String content = request.getParameter("inputContent");
        PostService postService = new PostService();
        Post post = postService.read(Long.valueOf(id));
        post.setTitle(title);
        post.setContent(content);
        postService.update(post);
        response.sendRedirect(request.getContextPath() + "/posts");
    }
}
