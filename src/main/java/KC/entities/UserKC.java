package KC.entities;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(
                        name = "findKnowledgeTagIdByUserId",
                        query = "from UserKC ukc where ukc.userId = :userId"
                )
        }
)

@Entity
@Table
public class UserKC implements KCEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer knowledgeTagId;

    public UserKC() {

    }

    public UserKC(Integer id, Integer userId, Integer knowledgeTagId){
        this.id = id;
        this.userId = userId;
        this.knowledgeTagId = knowledgeTagId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getKnowledgeTagId() {
        return knowledgeTagId;
    }

    public void setKnowledgeTagId(Integer knowledgeTagId) {
        this.knowledgeTagId = knowledgeTagId;
    }

}
