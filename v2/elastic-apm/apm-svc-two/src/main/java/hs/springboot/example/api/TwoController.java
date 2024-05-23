package hs.springboot.example.api;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value = "/api/v1")
@RestController
@RequestMapping("/api/v1")
public class TwoController implements TwoApi
{

    private final TwoProvider delegate;

    public TwoController(TwoProvider delegate) {
        this.delegate = delegate;
    }

    @GetMapping("/fu")
    public String sample(){
        return "!";
    }

    @Override
    public ResponseEntity<Map> inquiryTwo() {
        System.out.println("@@@@@@@@@@@");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("two","hello");
        return ResponseEntity.ok(objectObjectHashMap);
    }
}
