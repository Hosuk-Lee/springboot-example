package hs.springboot.example.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleProvider {

    private final SampleApiService sub1ApiService;

    public ResponseEntity<Map> inquirySub() {
        sub1ApiService.execute();
        ObjectMapper om = new ObjectMapper();
        Map map = new HashMap();
                // om.convertValue(sub1ApiService.inquiry(), Map.class);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}
