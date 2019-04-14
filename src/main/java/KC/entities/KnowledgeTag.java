package KC.entities;

import org.hibernate.annotations.Index;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(
                        name = "findTagByKeyword",
                        query = "from KnowledgeTag kt where kt.tag = :keyword"
                ),
                @NamedQuery(
                        name = "findTagByKeywordAndUserId",
                        query = "from KnowledgeTag kt where kt.tag = :keyword"
                )
        }
)

@Entity
@Table
public class KnowledgeTag implements KCEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Index(name="tag")
    private String tag;

    public KnowledgeTag(){

    }

    public KnowledgeTag(Integer id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
