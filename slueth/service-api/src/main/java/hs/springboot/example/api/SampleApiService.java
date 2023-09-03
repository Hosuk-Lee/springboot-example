package hs.springboot.example.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleApiService {

    private final SampleRepository repo;

    public void execute(){

        SampleEntity s1 = SampleEntity.builder()
                .account("1102780")
                .sample("hihello")
                .build();
        repo.save(s1);

    }

    public SampleEntity inquiry(){
        Optional<SampleEntity> byId = repo.findById(1L);
        return byId.get();
    }

//    public void

}
