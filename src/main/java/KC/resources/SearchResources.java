package KC.resources;

import KC.KCConfiguration;
import KC.entities.KCQueryRequest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Map;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResources {

    KCConfiguration config;

    public SearchResources(KCConfiguration config) {
        this.config = config;
    }

    @Path("/query")
    public Response query(KCQueryRequest request) {
        // make query to db at the simplest
        return Response.ok().build();
    }
}
