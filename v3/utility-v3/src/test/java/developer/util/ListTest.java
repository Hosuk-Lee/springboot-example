package developer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListTest {

    @Test
    void LIST() {
        List<String> l = null;
        l = new ArrayList<>();
        System.out.println(l + "," + l.size());
        l.add("1");
        l.add("2");

        System.out.println(l + "," + l.size());
        l.addAll(Collections.nCopies(6 - l.size(), ""));
        System.out.println(l + "," + l.size());

        l = new ArrayList<>(5);
        System.out.println(l + "," + l.size());

        l = new ArrayList<>(Collections.nCopies(5, ""));
        System.out.println(l + "," + l.size());

        l.set(0, "A");
        l.set(2, "C");
        System.out.println(l + "," + l.size());

        String sl[] = new String[5];
        Arrays.fill(sl, "0");
        System.out.println(Arrays.toString(sl));
    }

    public <E> E getOrDefault(int index, E defaultValue, List<E> list) {
        if (index < 0) {
            throw new IllegalArgumentException("index is less than 0: " + index);
        }
        return index <= list.size() - 1 ? list.get(index) : defaultValue;
    }
}
