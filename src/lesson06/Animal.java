package lesson06;

import java.security.SecureRandom;

public class Animal {
    private int speed = 0;

    public Animal(){

    }

    public Animal(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }
}
