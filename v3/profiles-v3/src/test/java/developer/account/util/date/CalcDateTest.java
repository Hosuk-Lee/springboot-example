package developer.account.util.date;

import static developer.account.util.date.CalcDateUtils.단편넣기;
import static developer.account.util.date.CalcDateUtils.만기일산출;
import static developer.account.util.date.CalcDateUtils.양편넣기;
import static developer.account.util.date.CalcDateUtils.윤년확인;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcDateTest {

    @Test
    void 테스트_단편넣기() {
        Assertions.assertEquals(149, 단편넣기("20240219", "20240717"));
    }

    @Test
    void 테스트_양편넣기() {
        Assertions.assertEquals(11, 양편넣기("20240219", "20240229"));
        Assertions.assertEquals(150, 양편넣기("20240219", "20240717"));
    }

    @Test
    void 테스트_윤년확인() {
        // year & 3 == 0  (year / 4)
        // year % 100 != 0 || year % 400 == 0
        Assertions.assertEquals(true, 윤년확인("20240101"));
    }

    @Test
    void 테스트_만기일산출() {
        Assertions.assertEquals("20240718", 만기일산출("20230718", 12));
        Assertions.assertEquals("20250718", 만기일산출("20230718", 24));
        Assertions.assertEquals("20260718", 만기일산출("20230718", 36));
        Assertions.assertEquals("20270718", 만기일산출("20230718", 48));
        Assertions.assertEquals("20270818", 만기일산출("20230718", 49));
        Assertions.assertEquals("20270918", 만기일산출("20230718", 50));
        Assertions.assertEquals("20271018", 만기일산출("20230718", 51));
        Assertions.assertEquals("20271118", 만기일산출("20230718", 52));
        Assertions.assertEquals("20271218", 만기일산출("20230718", 53));
        Assertions.assertEquals("20280718", 만기일산출("20230718", 60));
        System.out.println(만기일산출("20230229", 12));
        System.out.println(만기일산출("20240229", 24));
        System.out.println(만기일산출("20250229", 48));
        System.out.println(만기일산출("20260229", 60));
        System.out.println(만기일산출("20240229", 12));
        System.out.println(만기일산출("20240229", 24));
        System.out.println(만기일산출("20240229", 36));
        System.out.println(만기일산출("20240229", 48));
        System.out.println(만기일산출("20240231", 48));
    }

    @Test
    void 월수산출_날코딩() {
        // KB 에서는 월말이면 계산하는??
        LocalDate start = LocalDate.of(2023, 01, 31);
        LocalDate end = LocalDate.of(2024, 02, 29);

        int numberOfYear = end.getYear() - start.getYear();
        int gapMonths = 0;
        System.out.println(numberOfYear);
        if (start.getYear() < end.getYear()) {
            gapMonths = numberOfYear * 12 + (end.getMonthValue() - start.getMonthValue());
        }
        System.out.println(gapMonths);
        if (end.getDayOfMonth() < start.getDayOfMonth()) {
            System.out.println(start.lengthOfMonth());
            System.out.println(end.lengthOfMonth());

        }

        /* Period 객체사용 */
        long months = Period.between(start, end).toTotalMonths();
        System.out.println(months);
    }

    @Test
    void 임시() {
        OffsetDateTime time = OffsetDateTime.of(
                LocalDateTime.parse("202408140000", DateTimeFormatter.ofPattern("yyyyMMddHHmm")),
                ZoneOffset.UTC
        );
        System.out.println(time.toString());
        System.out.println(time.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")));

        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        mm(ld, ldt);

        BigDecimal i1 = BigDecimal.ZERO;
        BigInteger i2 = BigInteger.ZERO;
        mm(i1, i2);
    }

    void mm(Object o1, Object o2) {
        System.out.println(o1.getClass().isAssignableFrom(o2.getClass()));
    }
}
