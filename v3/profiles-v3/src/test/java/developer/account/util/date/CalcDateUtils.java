package developer.account.util.date;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalcDateUtils {

    private static String aa;

    static {
        System.out.println("aa" + aa);
        aa = "tq";
    }

    public static long 양편넣기(String start, String end) {
        System.out.println("aa" + aa);
        // 초일과 말일을 포함하여 계산
        return 양편넣기(
                LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd")),
                LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyyMMdd"))
        );
    }

    public static long 양편넣기(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end) + 1L;
    }

    public static long 단편넣기(String start, String end) {
        return 단편넣기(
                LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd")),
                LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyyMMdd"))
        );
    }

    public static long 단편넣기(LocalDate start, LocalDate end) {
        // 초일과 말일을 포함하여 계산하며, 말일을 계산에 포함하지 않는다.
        return ChronoUnit.DAYS.between(start, end);
    }

    public static boolean 윤년확인() {
        return 윤년확인(LocalDate.now());
    }

    public static boolean 윤년확인(String date) {
        return 윤년확인(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    public static boolean 윤년확인(LocalDate date) {
        return IsoChronology.INSTANCE.isLeapYear(date.getYear());
    }

    public static String 만기일산출(String baseDate, long numberOfMonth) {
        // 월 기준으로
        LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return date.plusMonths(numberOfMonth).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static boolean 만기일산출(LocalDate date) {
        return IsoChronology.INSTANCE.isLeapYear(date.getYear());
    }

}
