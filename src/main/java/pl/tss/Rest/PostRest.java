package pl.tss.Rest;

import pl.tss.Model.Post;
import pl.tss.Service.PostService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("myresource")
public class PostRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        PostService postService = new PostService();
        List<Post> allPosts = postService.getAllPosts();
        return Response.ok(allPosts).build();
    }
}
