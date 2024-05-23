package hs.springboot.example.api;

//import brave.Tracing;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleApiService {
    private final SampleRepository repo;

    private final RestTemplate restTemplate;
//    @Autowired
//    Tracing tracing;
    String oneBaseUrl = System.getProperty("spring.example.oneBaseUrl", "http://localhost:22011");
    String twoBaseUrl = System.getProperty("spring.example.oneBaseUrl", "http://localhost:22012");

    public void execute(String id){
        log.info("CALL::FUNCTION::>>{}",SampleApiService.class.getName());
        SampleEntity s1 = SampleEntity.builder()
                .traceId(id)
                .sample("hi hello")
                .build();
        repo.save(s1);

        String one = restTemplate.getForObject(oneBaseUrl + "/api/v1/one", String.class);
        log.info("ONE::API::>>{}",one);
        String two = restTemplate.getForObject(twoBaseUrl + "/api/v1/two", String.class);
        log.info("TWO::API::>>{}",two);
        String oneCallTwo = restTemplate.getForObject(oneBaseUrl + "/api/v1/one-call-two", String.class);
        log.info("ONE-CALL-TWO::API::>>{}",oneCallTwo);

//        tracing.propagation().extractor(Request::getHeader);
//        tracing.propagation().extractor();

    }

    public SampleEntity inquiry(String id){
        Optional<SampleEntity> byId = repo.findById(1L);
        return byId.get();
    }


}
