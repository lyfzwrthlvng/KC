package KC;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class KCConfiguration extends Configuration {
    @NotEmpty
    String notEmptySample;

    @JsonProperty
    public String getNotEmptySample() {
        return notEmptySample;
    }

    @JsonProperty
    public void setNotEmptySample( String sample ) {
        this.notEmptySample = sample;
    }
}