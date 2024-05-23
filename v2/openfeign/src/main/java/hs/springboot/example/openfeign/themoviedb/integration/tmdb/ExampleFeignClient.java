package hs.springboot.example.openfeign.themoviedb.integration.tmdb;

import feign.Headers;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// name은 클라이언트의 이름, url은 대상 서비스의 URL
@FeignClient(name = "example-service", url = "https://api.themoviedb.org/3",configuration = ClientConfig.class)
public interface ExampleFeignClient {

    @GetMapping("/movie/27205/credits")
//    @Headers("Content-Type: application/json")
    Map getResource();
}
