package hs.springboot.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Sample", description = "Sample API")
public interface SampleApi {

//    public OneProvider getDelegate();

    /**
     * GET /info
     *
     * @return 조회 생성 응답 (status code 200)
     */
    @Operation(summary = "One API", operationId = "inquiryOne", description = "Sample Service description", tags={ "API", "Sample" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 응답"),  })
    @GetMapping(
            value = "/sample"
//            produces = { "application/json" },
//            consumes = { "application/json" }
    )
    public ResponseEntity<Map> inquirySub();
}
