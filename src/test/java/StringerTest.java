import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringerTest {
    @Test
    public void testReverse(){
        Stringer stringer = new Stringer();
        assertEquals(5, stringer.computeLength("hello"));
        String[] monthss = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> months = new ArrayList<>();
        for (String month : monthss) {
            months.add(month);
        }
        assertEquals(stringer.jedisList("months"), months.toString());
    }
}
