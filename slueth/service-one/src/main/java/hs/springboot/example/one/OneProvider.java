package hs.springboot.example.one;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OneProvider {

    private final OneApiService sub1ApiService;

    public ResponseEntity<Map> inquirySub() {
        sub1ApiService.execute();
        ObjectMapper om = new ObjectMapper();
        Map map = om.convertValue(sub1ApiService.inquiry(), Map.class);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    public ResponseEntity<Map> inquiryOneCallTwo() {
        sub1ApiService.execute();
        ObjectMapper om = new ObjectMapper();
        Map map = om.convertValue(sub1ApiService.inquiry(), Map.class);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}
