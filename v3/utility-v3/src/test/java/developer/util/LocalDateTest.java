package developer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

public class LocalDateTest {

    @Test
    void str2localdate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String var1 = "";
//        System.out.println(LocalDate.parse(var1));
        String var2 = "20240101";
        System.out.println(LocalDate.parse(var2, formatter));
    }
}
