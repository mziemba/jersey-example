package example.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Simple Jersey resource.
 */
@Path("/hello")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String get(@QueryParam("x") String x) {
        return "query parameter x: "+ (x != null ? x : "not injected");
    }
}
