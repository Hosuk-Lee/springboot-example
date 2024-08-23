package developer.account.util.date;

import org.junit.jupiter.api.Test;

public class CalcInterestTest {

    @Test
    void 테스트_월적수_이자계산() {
        System.out.println("월적수로 이자계산");
        System.out.println("== 만기해약");
        System.out.println("== 적립식상품이자구분코드 : 2-일적수우대이자계산");

        // 기본 우대이율은 월적수
        // 다른 우대이율은 일적수
        float 기본우대이율 = 0.3f;
        float 약정우대이율 = 0.1f;
        float 계산우대이율 = 기본우대이율 + 약정우대이율;

        float 자동이체우대이율 = 0.1f;
        float 적용이율 = 2.75f; // 기본금리

        float 특별이율 = 계산우대이율 + 자동이체우대이율;

        /**
         * 우대금리(00:전체우대금리) = 계산우대이율 + 자동이체우대이율
         * 우대금리(01:기본우대금리) = 계산우대이율
         * 우대금리(02:자동이체우대이율) = 자동이체우대이율
         * 우대금리(나머지경우) = 개별우대이율
         * */

        // RITVL-IP-INT-DSTCD : 2 적립식상품이자구분코드
        // Regular Interval -- Interest --
        // 일적수 우대이자 계산 (DD-A-PFER-INT-CALC-RTN)

        System.out.println("일적수우대이자계산");
        System.out.println("-- 우대이율구분코드 : 01 기본우대이율");

    }
}
