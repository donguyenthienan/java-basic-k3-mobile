package lesson08;

import java.security.SecureRandom;

public class Falcon extends Animal{
    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(45);
    }

    @Override
    protected boolean flyable() {
        return true;
    }
}
