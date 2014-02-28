package example.jersey.exceptions;

import com.google.gson.JsonObject;
import com.google.inject.Singleton;
import com.sun.jersey.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class BadUriException implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException exception){
        final JsonObject res = new JsonObject();
        res.addProperty("error", 404);
        return Response.status(Response.Status.NOT_FOUND).
                entity(res.toString()).
                build();
    }
}