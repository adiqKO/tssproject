package pl.tss.Controller;

import pl.tss.Model.User;
import pl.tss.Service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class PostAddController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getUserPrincipal() != null) {
            request.getRequestDispatcher("addPost.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("inputTitle");
        String content = request.getParameter("inputContent");
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if(request.getUserPrincipal() != null) {
            PostService postService = new PostService();
            postService.addPost(title, content, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/posts");
        } else {
            response.sendError(403);
        }
    }
}
