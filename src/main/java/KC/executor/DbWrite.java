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
        KnowledgeTag tag = null;

        // this assumes KnowledgeTag is indexed on tag
        tag = DbOperations.getKnowledgeTag(writeRequest.getKeyword());
        int tagId;
        if(tag == null) {
            tag = new KnowledgeTag();
            tag.setTag(writeRequest.getKeyword());
            tagId = DbOperations.persistKCEntity(tag);
        } else {

            tagId = tag.getId();
        }
        //2. write the cloud
        int knowledgeId = DbOperations.persistKCEntity(knowledge);

        //3. Persist knowledge tag mapping
        KnowledgeMapping mapping = new KnowledgeMapping();
        mapping.setTagId(tagId);
        mapping.setCloudId(knowledgeId);

        DbOperations.persistKCEntity(mapping);

        //4. persist user tag mapping
        UserKC userKC = new UserKC();
        userKC.setUserId(request.getUserId());
        userKC.setKnowledgeTagId(tagId);
        DbOperations.persistKCEntity(userKC);
        return true;
    }

    @Override
    public NodeResult getOutput() {
        return null;
    }

    @Override
    public void setOutput(NodeResult result) {

    }

    @Override
    public boolean process(KCAccessRequest request) {
        this.request = (KCWriteRequest) request;
        return process();
    }
}
