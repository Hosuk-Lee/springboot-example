package developer.stringtest;


import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

    // Nodm 월수
    // Noday 일수

    @Test
    void installment_goal_amount() {
        String 계산공식코드 = "7"; // 적립식 적수 이자계산
        int 월수 = 12;
        String 양편계산여부 = "N";
        String 단수처리여부 = "Y";
        String 단수처리구분코드 = "0";
        float 연이율 = 2.75f;
        long 계산금액 = 500_000;

        BigDecimal rtn = BigDecimal.ZERO;
        // 계산금액 * (월수 * (월수 + 1 )) * 연이율) / ( 2 * 12 * 100)
        float 계산된이자 = 계산금액 * (월수 * (월수 + 1) * 연이율) / (2 * 12 * 100);
        System.out.println(계산된이자);

        float 총불입금액 = (계산금액 * 월수);
        float 계약금액 = 총불입금액 + 계산된이자;
        System.out.println(총불입금액);
        System.out.println(계약금액);

    }

    @Test
    void calc() {
//        long contractAmount = 500_000L;
//        float interest = 2.75f;
//        long contractTermCount = 12;
        float interest = 2.75f;
        float contractTermCount = 1 * 12;
        float amountOfContractTermCount = new BigDecimal("500000").floatValue() * 12;
        float v = amountOfContractTermCount * (contractTermCount + 1) / 2.0f * (interest / 100) / 12.0f;
        BigDecimal calc = BigDecimal.valueOf(
                v
        );
        System.out.println(calc.longValue());
        System.out.println(calc.toString());
    }
}
