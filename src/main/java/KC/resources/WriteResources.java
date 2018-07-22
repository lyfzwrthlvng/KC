package KC.resources;

/*
Resources to write to db through api calls
 */

import KC.KCConfiguration;
import KC.entities.KCResourceConfig;
import KC.entities.KCWriteRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/write")
@Produces(MediaType.APPLICATION_JSON)
public class WriteResources {
    KCConfiguration config;

    public WriteResources(KCConfiguration config){
        this.config = config;
    }

    @POST
    @Path("/kc")
    public Response writeKC(KCWriteRequest request) throws Exception {
        return Response.ok().build();
    }

    @POST
    @Path("/user")
    public Response writeUser(KCWriteRequest request) throws Exception {
        return Response.ok().build();
    }
}
