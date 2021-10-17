package lesson06;

import java.security.SecureRandom;

public class Horse extends Animal{
    public Horse() {
        super(new SecureRandom().nextInt(60));
    }
}
