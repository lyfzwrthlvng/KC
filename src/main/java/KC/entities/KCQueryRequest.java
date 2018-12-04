package KC.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class KCQueryRequest extends KCAccessRequest {
    @JsonProperty
    ArrayList<String> keywordList;

    public ArrayList<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(ArrayList<String> list) {
        this.keywordList = list;
    }
}
