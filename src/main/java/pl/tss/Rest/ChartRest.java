package pl.tss.Rest;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("chartRest")
public class ChartRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        Gson gsonBuilder = new GsonBuilder().create();
        Random r = new Random();
        NumberClass nb = new NumberClass(r.nextInt(20));
        String json = gsonBuilder.toJson(nb);
        return Response.ok(json).build();
    }

    class NumberClass{
        int amountOfClient;
        NumberClass(int amountOfClient) {
            this.amountOfClient = amountOfClient;
        }
        int getAmountOfClient() { return amountOfClient; }
        void setAmountOfClient(int amountOfClient) { this.amountOfClient = amountOfClient; }
        @Override
        public String toString() {
            return "NumberClass{" +
                    "amountOfClient=" + amountOfClient +
                    '}';
        }
    }
}
