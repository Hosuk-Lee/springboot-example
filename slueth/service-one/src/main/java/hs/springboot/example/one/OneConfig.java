package hs.springboot.example.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OneConfig {
    @Bean
    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        HttpClient httpClient =
//        HttpClientBuilder.
        return new RestTemplate();
    }
}
