package hs.sample.step1.v3.api.scheme;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Dacc {

    @JsonProperty("tranYmd")
    private String tranYmd;

    @JsonProperty("wWoncAcitmInfo")
    private List<DaccWWoncAcitmInfo> wWoncAcitmInfos;

    public String getTranYmd() {
        return tranYmd;
    }

    public void setTranYmd(String tranYmd) {
        this.tranYmd = tranYmd;
    }

    public List<DaccWWoncAcitmInfo> getwwoncacitminfos() {
        return wWoncAcitmInfos;
    }

    public void setwWoncAcitmInfos(List<DaccWWoncAcitmInfo> wWoncAcitmInfos) {
        this.wWoncAcitmInfos = wWoncAcitmInfos;
    }
}
