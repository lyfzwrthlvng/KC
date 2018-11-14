package KC.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class KnowledgeMapping {

    @Id
    @GeneratedValue
    private Integer id;

    Integer tagId;

    Integer cloudId;

    KnowledgeMapping(Integer id, Integer tagId, Integer cloudId) {
        this.id = id;
        this.tagId = tagId;
        this.cloudId = cloudId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCloudId() {
        return cloudId;
    }

    public void setCloudId(Integer cloudId) {
        this.cloudId = cloudId;
    }
}
