package lesson07;

import java.security.SecureRandom;

public class Animal {
    private final String species;
    private final String name;
    private final int speed;
    private final boolean flyAble;

    private Animal(Builder builder){
        this.species = builder.species;
        this.name = builder.name;
        this.speed = builder.speed;
        this.flyAble = builder.flyAble;
    }
    public int getSpeed(){
        return this.speed;
    }
    public boolean flyAble(){
        return this.flyAble;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public void runOnTheGround(){
        if(flyAble){
            System.out.printf("%s %s can not run on the ground\n", species, name);
            return;
        }
        System.out.printf("%s %s can run on the ground\n", species, name);
    }

    public static class Builder {
        private int speed;
        private boolean flyAble;
        private String species;
        private String name;

        public Builder speed(int speed){
            this.speed = new SecureRandom().nextInt(speed);
            return this;
        }

        public Builder flyAble(boolean flyAble){
            this.flyAble = flyAble;
            return this;
        }

        public Builder species(String species){
            this.species = species;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Animal build(){
            return new Animal(this);
        }
    }
}
