package hs.sample.step1.v3.api.scheme;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaccPartl {

    @JsonProperty("dacc")
    private Dacc dacc;

    public Dacc getDacc() {
        return dacc;
    }

    public void setDacc(Dacc dacc) {
        this.dacc = dacc;
    }
}
