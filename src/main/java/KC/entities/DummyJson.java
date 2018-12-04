package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DummyJson {

    @JsonProperty
    String dummyString;

    public String getDummyString() {
        return dummyString;
    }

    public void setDummyString(String dummyString) {
        this.dummyString = dummyString;
    }

}
