package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KCReadRequest extends KCAccessRequest {
    @JsonProperty
    String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
