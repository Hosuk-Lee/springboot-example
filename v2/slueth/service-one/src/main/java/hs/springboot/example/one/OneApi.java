package hs.springboot.example.one;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "One", description = "One API")
public interface OneApi {

//    public OneProvider getDelegate();

    /**
     * GET /info
     *
     * @return 조회 생성 응답 (status code 200)
     */
    @Operation(summary = "One API", operationId = "inquiryOne", description = "api 1 description", tags={ "api", "one" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 응답"),  })
    @GetMapping(
            value = "/one"
//            produces = { "application/json" },
//            consumes = { "application/json" }
    )
    public ResponseEntity<Map> inquirySub();

    @Operation(summary = "One Call Two API", operationId = "inquiryOneCallTwo", description = "api 1 description", tags={ "api", "one", "sub call" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 응답"),  })
    @GetMapping(
            value = "/one-call-two"
//            produces = { "application/json" },
//            consumes = { "application/json" }
    )
    public ResponseEntity<Map> inquiryOneCallTwo();
}
