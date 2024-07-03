package hs.springboot.example;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SampleController {

//    private final RestTemplate restTemplate;

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

//    @GetMapping("/sample")
//    public void sample(){
//        final String uri = "https://api.themoviedb.org/3/search/movie?query=Batman&callback=test";
//        HttpHeaders headers =
//        ResponseEntity<Object> response = restTemplate.exchange(
////            "http://example.com/api/v1/users",
//                uri,
//                HttpMethod.GET,
//                HttpEntity.EMPTY,
//                Object.class
//        );
//    }
}
