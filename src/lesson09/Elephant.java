package lesson09;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Elephant extends Animal{

    public Elephant(){
        legLength = (3000.0 + new SecureRandom().nextInt(1000))/1000;
    }
    public static Map<String, Integer> countMap = new HashMap<String, Integer>(){{
        put("raceCount", 0);
    }};

    public static int raceCount = 0;

    @Override
    public boolean flyAble() {
        return false;
    }

    @Override
    public double speed() {
        return legLength * 6;
    }
}
