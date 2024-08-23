package developer.stringtest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    void strutltest() {
        String a = null;
        System.out.println(StringUtils.isEmpty(a));
        String b = "";
        System.out.println(StringUtils.isBlank(b));
    }

    @Test
    void ss() {
        // 1. 입력 문자열을 파싱하여 LocalDateTime 객체로 변환
        LocalDateTime inputDateTime = LocalDateTime.parse("20240709003055146",
                DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

        // 2. 1시간을 뺀 LocalDateTime 객체 생성
        LocalDateTime oneHourBeforeDateTime = inputDateTime.minusHours(1);

        // 3. 변환된 LocalDateTime 객체를 원하는 형식의 문자열로 변환
        String formattedDateTime = oneHourBeforeDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        System.out.println(formattedDateTime);

        // 현재 날짜 및 시간 객체 생성
        LocalDateTime now = LocalDateTime.now();

        // yyyyMMddHHmmss 형식의 DateTimeFormatter 객체 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // 현재 날짜 및 시간을 yyyyMMddHHmmss 형식으로 문자열 변환
        String formattedDate = now.format(formatter);

        // 결과 출력
        System.out.println(formattedDate);

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDateTime n = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(n.toString());

        String fullPrdctCd = "010200100051";
//        System.out.println(StringUtils.containsn(fullPrdctCd, "010200500044"));
    }

}
