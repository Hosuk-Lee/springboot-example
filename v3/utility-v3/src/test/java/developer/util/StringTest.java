package developer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void strTest() {

        Integer a = (int) (Math.random() * 10);
        System.out.println(a);
        
//        String a = null;
//        assert a != null;
        assertEquals("2024", "20240101".substring(0, 4));
    }
}
