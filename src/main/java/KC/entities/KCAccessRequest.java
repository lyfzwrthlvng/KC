package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KCAccessRequest {
    @JsonProperty
    String userkey;

    @JsonProperty
    String passKey;

    public KCAccessRequest(String userKey) {
        this.userkey = userKey;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String key) {
        this.userkey = userkey;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String key){
        this.passKey = passKey;
    }
}
