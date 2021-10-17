package lesson08;

import java.security.SecureRandom;

public class Tiger extends Animal{
    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(100);
    }

    @Override
    protected boolean flyable() {
        return false;
    }
}
