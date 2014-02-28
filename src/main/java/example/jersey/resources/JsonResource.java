package example.jersey.resources;

import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Simple json resource.
 */
@Path("/json/hello")
public class JsonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getResource() {
        final JsonObject obj = new JsonObject();
        obj.addProperty("message", "hello");
        return obj.toString();
    }
}
