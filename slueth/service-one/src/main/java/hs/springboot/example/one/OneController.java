package hs.springboot.example.one;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value = "/api/v1")
@RestController
@RequestMapping("/api/v1")
public class OneController implements OneApi
{

    private final OneProvider delegate;

    public OneController(OneProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public ResponseEntity<Map> inquirySub() {
        System.out.println("@@@@@@@@@@@");
        return delegate.inquirySub();
    }
}
