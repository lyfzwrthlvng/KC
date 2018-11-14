package KC.entities;

import org.hibernate.annotations.Index;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class KnowledgeTag {

    @Id
    @GeneratedValue
    private Integer id;

    @Index(name="index_tag")
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
