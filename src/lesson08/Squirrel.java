package lesson08;

import java.security.SecureRandom;

public class Squirrel extends Animal{
    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(25);
    }

    @Override
    protected boolean flyable() {
        return false;
    }
}
