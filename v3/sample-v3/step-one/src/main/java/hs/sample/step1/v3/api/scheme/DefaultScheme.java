package hs.sample.step1.v3.api.scheme;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DefaultScheme {

    @JsonProperty
    private DaccPartl daccPartl;

    public DaccPartl getDaccPartl() {
        return daccPartl;
    }

    public void setDaccPartl(DaccPartl daccPartl) {
        this.daccPartl = daccPartl;
    }
}
