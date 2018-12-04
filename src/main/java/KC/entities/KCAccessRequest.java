package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KCAccessRequest {
    @JsonProperty
    String userKey;

    @JsonProperty
    String passKey;

    @JsonProperty
    Integer userId;

    public String getUserkey() {
        return userKey;
    }

    public void setUserkey(String key) {
        this.userKey = key;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String key){
        this.passKey = passKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
