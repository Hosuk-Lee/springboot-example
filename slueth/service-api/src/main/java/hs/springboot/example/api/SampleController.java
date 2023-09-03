package hs.springboot.example.api;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@RestController(value = "/api/v1")
@RestController
@RequestMapping("/api/v1")
public class SampleController implements SampleApi
{

    private final SampleProvider delegate;

    public SampleController(SampleProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public ResponseEntity<Map> inquirySub() {
        System.out.println("@@@@@@@@@@@");
        return delegate.inquirySub();
    }
}
