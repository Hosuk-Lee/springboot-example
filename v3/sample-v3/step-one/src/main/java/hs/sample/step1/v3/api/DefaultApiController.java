package hs.sample.step1.v3.api;


import hs.sample.step1.v3.api.scheme.Dacc;
import hs.sample.step1.v3.api.scheme.DaccPartl;
import hs.sample.step1.v3.api.scheme.DaccWWoncAcitmInfo;
import hs.sample.step1.v3.api.scheme.DefaultScheme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultApiController {


    @PostMapping("/api/default")
    public DefaultScheme defaultApi() {

        List<DaccWWoncAcitmInfo> wWoncAcitmInfoList = new ArrayList<>();
        DaccWWoncAcitmInfo wWoncAcitmInfo = new DaccWWoncAcitmInfo();
        wWoncAcitmInfoList.add(wWoncAcitmInfo);
        wWoncAcitmInfoList.add(wWoncAcitmInfo);

        Dacc dacc = new Dacc();
        dacc.setTranYmd("20240101");
        dacc.setwWoncAcitmInfos(wWoncAcitmInfoList);

        DaccPartl daccPartl = new DaccPartl();
        daccPartl.setDacc(dacc);

        DefaultScheme d = new DefaultScheme();
        d.setDaccPartl(daccPartl);

        return d;
    }
}
