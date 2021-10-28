package lesson09;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Tiger extends Animal{

    public Tiger(){
        weight = 250 + new SecureRandom().nextInt(150);
    }

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
        return weight * 0.06;
    }

}
