package lesson08;

import java.security.SecureRandom;

public class Horse extends Animal{
    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(70);
    }

    @Override
    protected boolean flyable() {
        return false;
    }
}
