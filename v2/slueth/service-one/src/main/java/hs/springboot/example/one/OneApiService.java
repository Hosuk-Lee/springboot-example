package hs.springboot.example.one;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OneApiService {

    private final OneRepository repo;

    public void execute(){

        OneEntity s1 = OneEntity.builder()
                .account("1102780")
                .sample("hihello")
                .build();
        repo.save(s1);

    }

    public OneEntity inquiry(){
        Optional<OneEntity> byId = repo.findById(1L);
        return byId.get();
    }

//    public void

}
