package KC.resources;

/*
Resources to write to db through api calls
 */

import KC.DbOperations;
import KC.Delegator;
import KC.KCConfiguration;
import KC.constants.EndService;
import KC.entities.*;
import KC.executor.Machine;
import com.google.inject.Inject;

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
    Delegator delegator;
    //Machine machine = new Machine();

    @Inject
    public WriteResources(KCConfiguration config, Delegator delegator){
        this.config = config;
        this.delegator = delegator;
        //this.machine = new Machine();
    }

    @POST
    @Path("/kc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response writeKC(KCWriteRequest request) throws Exception {

        Machine executionMachine = delegator.getMachine(EndService.WRITE_KNOWLEDGE, request);
        Boolean result = executionMachine.execute();
        Response response = null;
        if(!result) {
            response = Response.serverError().build();
        } else {
            response = Response.ok().build();
        }
        return response;
        //return Response.ok().build();
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
