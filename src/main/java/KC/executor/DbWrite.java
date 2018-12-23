package KC.executor;

import KC.DbOperations;
import KC.entities.*;

public class DbWrite implements Node {

    private KCWriteRequest request;

    public DbWrite() {}

    public DbWrite(KCAccessRequest request) {
        this.request = (KCWriteRequest) request;
    }

    @Override
    public boolean process() {
        KCWriteRequest writeRequest = request;
        //1. check existance of tag string
        Knowledge knowledge = new Knowledge();
        knowledge.setCloud(writeRequest.getValue());
        //knowledge.setId(1);
        KnowledgeTag tag = new KnowledgeTag();
        tag.setTag(writeRequest.getKeyword());

        // write all
        //int knowledgeId = DbOperations.persistKnowledge(knowledge);
        int knowledgeId = DbOperations.persistKCEntity(knowledge);
        //int tagId = DbOperations.persistKnowledgeTag(tag);
        int tagId = DbOperations.persistKCEntity(tag);

        KnowledgeMapping mapping = new KnowledgeMapping();
        mapping.setTagId(tagId);
        mapping.setCloudId(knowledgeId);

        //DbOperations.persistKnowledgeMapping(mapping);
        DbOperations.persistKCEntity(mapping);

        UserKC userKC = new UserKC();
        //userKC.setId();
        userKC.setUserId(request.getUserId());
        userKC.setKnowledgeTagId(tagId);

        //DbOperations.persistUserKC(userKC);
        DbOperations.persistKCEntity(userKC);

        return true;
    }

    @Override
    public boolean process(KCAccessRequest request) {
        this.request = (KCWriteRequest) request;
        return process();
    }
}
