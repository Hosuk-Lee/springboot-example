package hs.springboot.example.api;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@RestController(value = "/api/v1")
@RestController
@RequestMapping("/api/v1")
public class OneController implements OneApi
{

    private final OneProvider delegate;
    private final RestTemplate restTemplate;

    public OneController(OneProvider delegate, RestTemplate restTemplate) {
        this.delegate = delegate;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Map> inquirySub() {
        System.out.println("@@@@@@@@@@@");

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return delegate.inquirySub();
    }

    @Override
    public ResponseEntity<Map> inquiryOneCallTwo() {

        String twoBaseUrl = System.getProperty("spring.example.oneBaseUrl", "http://localhost:22012");
        String two = restTemplate.getForObject(twoBaseUrl + "/api/v1/two", String.class);
        Map m = new HashMap();
//        m.put("two_response", two);
        m.put("two_response", "one-call-two");
        System.out.println(m);
        return ResponseEntity.ok(m);
    }
}
