package KC.resources;

/*
Resources to write to db through api calls
 */

import KC.DbOperations;
import KC.KCConfiguration;
import KC.entities.*;

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

    public WriteResources(KCConfiguration config){
        this.config = config;
    }

    @POST
    @Path("/kc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response writeKC(KCWriteRequest request) throws Exception {
        //1. check existance of tag string
        Knowledge knowledge = new Knowledge();
        knowledge.setCloud(request.getValue());
        //knowledge.setId(1);
        KnowledgeTag tag = new KnowledgeTag();
        tag.setTag(request.getKeyword());

        // write all
        int knowledgeId = DbOperations.persistKnowledge(knowledge);
        int tagId = DbOperations.persistKnowledgeTag(tag);

        KnowledgeMapping mapping = new KnowledgeMapping();
        mapping.setTagId(tagId);
        mapping.setCloudId(knowledgeId);

        DbOperations.persistKnowledgeMapping(mapping);

        UserKC userKC = new UserKC();
        //userKC.setId();
        userKC.setUserId(request.getUserId());
        userKC.setKnowledgeTagId(tagId);

        DbOperations.persistUserKC(userKC);


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
