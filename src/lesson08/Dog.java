package lesson08;

import java.security.SecureRandom;

public class Dog extends Animal{

    @Override
    protected double getSpeed() {
        return new SecureRandom().nextInt(60);
    }

    @Override
    protected boolean flyable() {
        return false;
    }
}
