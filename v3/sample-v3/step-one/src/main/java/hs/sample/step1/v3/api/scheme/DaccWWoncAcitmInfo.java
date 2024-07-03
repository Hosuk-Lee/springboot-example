package hs.sample.step1.v3.api.scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class DaccWWoncAcitmInfo {

    @JsonProperty("wAcctgBaseDstcd")
    private String wAcctgBaseDstcd;

    @JsonProperty("wWoncTrfamt")
    private BigDecimal wWoncTrfamt;

    public String getwAcctgBaseDstcd() {
        return wAcctgBaseDstcd;
    }

    public void setwAcctgBaseDstcd(String wAcctgBaseDstcd) {
        this.wAcctgBaseDstcd = wAcctgBaseDstcd;
    }

    public BigDecimal getwWoncTrfamt() {
        return wWoncTrfamt;
    }

    public void setwWoncTrfamt(BigDecimal wWoncTrfamt) {
        this.wWoncTrfamt = wWoncTrfamt;
    }
}
