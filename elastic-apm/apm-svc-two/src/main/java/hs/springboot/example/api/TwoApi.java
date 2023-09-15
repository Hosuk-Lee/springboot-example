package hs.springboot.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Two", description = "Two API")
public interface TwoApi {

//    public TwoProvider getDelegate();

    /**
     * GET /info
     *
     * @return 조회 생성 응답 (status code 200)
     */
    @Operation(summary = "Two API", operationId = "inquiryTwo", description = "api 1 description", tags={ "api", "one" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 응답"),  })
    @GetMapping(
            value = "/two"
//            produces = { "application/json" },
//            consumes = { "application/json" }
    )
    public ResponseEntity<Map> inquiryTwo();
}
