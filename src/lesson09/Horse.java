package lesson09;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Horse extends Animal{

    public static int raceCount = 0;
    public static Map<String, Integer> countMap = new HashMap<String, Integer>(){{
        put("raceCount", 0);
    }};
    @Override
    public boolean flyAble() {
        return false;
    }

    @Override
    public double speed() {
        return 15 + new SecureRandom().nextInt(9);
    }

}
