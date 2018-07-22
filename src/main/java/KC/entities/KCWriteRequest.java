package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KCWriteRequest extends KCAccessRequest {

    @JsonProperty
    String keyword;

    @JsonProperty
    String value;

    public KCWriteRequest(String userKey) {
        super(userKey);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
