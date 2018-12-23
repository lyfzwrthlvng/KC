package KC.resources;

import KC.Delegator;
import KC.KCConfiguration;
import KC.entities.KCQueryRequest;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    Delegator delegator;

    @Inject
    public SearchResources(KCConfiguration config, Delegator delegator) {
        this.config = config;
        this.delegator = delegator;
    }

    @POST
    @Path("/query")
    public Response query(KCQueryRequest request) {
        // make query to db at the simplest
        return Response.ok().build();
    }

    @GET
    @Path("/dummy")
    public Response dummy() {
        return Response.ok().build();
    }
}
