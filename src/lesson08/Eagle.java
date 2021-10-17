package lesson08;

import java.security.SecureRandom;

public class Eagle extends Animal{
    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(50);
    }

    @Override
    protected boolean flyable() {
        return true;
    }
}
