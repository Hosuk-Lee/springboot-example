package hs.springboot.example.api;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Transaction;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value = "/api/v1")
@RestController
@RequestMapping("/hs/springboot/example/api/v1")
@Slf4j
public class SampleController implements SampleApi
{

    private final SampleProvider delegate;

    public SampleController(SampleProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public ResponseEntity<Map> inquirySub() {
        log.info("hello");
        Transaction transaction = ElasticApm.currentTransaction();
        log.info("{}.{}", transaction.getId(), transaction.getTraceId());

        return delegate.inquirySub(transaction.getId());
    }
}
