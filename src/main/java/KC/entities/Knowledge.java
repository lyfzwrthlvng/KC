package KC.entities;

import javax.persistence.*;

@Entity
@Table
public class Knowledge implements KCEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // The actual knowledge cloud
    // This id (above) will be associated with multiple
    // tags, tags are stored separately
    private String cloud;

    public Knowledge(){

    }

    public Knowledge(Integer id, String cloud) {
        this.id = id;
        this.cloud = cloud;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCloud() {
        return this.cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }
}
