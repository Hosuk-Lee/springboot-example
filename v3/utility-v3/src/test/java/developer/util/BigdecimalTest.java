package developer.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BigdecimalTest {

    @Test
    void test() {
        float c = 2.8f;
        System.out.println(c);
        BigDecimal cc = BigDecimal.valueOf(c);
        System.out.println(cc);

        double a = 2.8;
        System.out.println(a);
        BigDecimal b = new BigDecimal(2.8f);
        System.out.println(b + ":" + b.toPlainString() + ":" + b.toEngineeringString());
        BigDecimal d = b.setScale(3, RoundingMode.HALF_UP);
        System.out.println(d);
    }

    @Test
    void BigdecimalToString() {
        DecimalFormat df = new DecimalFormat("###,##0.000");
        BigDecimal b = new BigDecimal("2.8");
        System.out.println(df.format(b));

        BigDecimal c = BigDecimal.valueOf(2.8);
        System.out.println(df.format(c));
    }

    @Test
    void BD() {
        BigDecimal var1 = new BigDecimal(65000000.00);
        System.out.println(var1);

        BigDecimal var2 = BigDecimal.valueOf(65000000);
        System.out.println(var2);

        BigDecimal var33 = new BigDecimal(10000L);

        BigDecimal var3 = new BigDecimal("10000.00");
        System.out.println(var3);
        System.out.println(var33.add(var3));
        System.out.println(new BigDecimal(var3.longValue() + var33.longValue()));

        BigDecimal var4 = new BigDecimal("10000.00").stripTrailingZeros();
        System.out.println(var4.toPlainString());

        System.out.println(var3.setScale(0));

        new BigDecimal("26");

    }

    @Test
    void compare() {
        BigDecimal var1 = new BigDecimal("0");
        Assertions.assertTrue(BigDecimal.ZERO.equals(var1));
    }
}
