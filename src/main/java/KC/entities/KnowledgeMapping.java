package KC.entities;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(
                        name = "findKnowledgeMappingByTagId",
                        query = "from KnowledgeMapping km where km.tagId = :tagId"
                )
        }
)

@Entity
@Table
public class KnowledgeMapping implements KCEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    Integer tagId;

    Integer cloudId;

    public KnowledgeMapping(){

    }

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
