import redis.clients.jedis.Jedis;

import java.util.List;

public class Stringer {
    public int computeLength(String input) {
        return input.length();
    }

    public static void main(String args[]) {
        String ar = "months";
        System.out.println("Length of " + ar + " is: " + new Stringer().computeLength(ar));
        new Stringer().jedisList(ar);

    }

    public String jedisList(String ar) {
        Jedis jedis = new Jedis("localhost");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String res = "";
        if (!jedis.exists(ar)) {
            jedis.rpush("months", months);
            List<String> lrange = jedis.lrange(ar, 0, 13);
            res = lrange.toString();
            System.out.println("1 "+res);
        }
        else {
            List<String> lrange = jedis.lrange(ar, 0, 13);
            res = lrange.toString();
            System.out.println("2: "+res);
        }
        jedis.close();
        return res;
    }

}
