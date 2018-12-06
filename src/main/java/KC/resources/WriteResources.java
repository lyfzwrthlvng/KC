package KC.resources;

/*
Resources to write to db through api calls
 */

import KC.DbOperations;
import KC.KCConfiguration;
import KC.entities.*;
import KC.executor.Machine;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/write")
@Produces(MediaType.APPLICATION_JSON)
public class WriteResources {
    KCConfiguration config;
    Machine machine

    public WriteResources(KCConfiguration config){
        this.config = config;
        this.machine = new Machine();
    }

    @POST
    @Path("/kc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response writeKC(KCWriteRequest request) throws Exception {

        //TODO perhaps use guice


        return Response.ok().build();
    }

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response writeUser(KCWriteRequest request) throws Exception {
        return Response.ok().build();
    }

    @POST
    @Path("/dummy")
    public Response dummy(DummyJson dummyJson){
        return Response.ok().entity(dummyJson.getDummyString()).build();
    }
}
