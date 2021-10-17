package lesson07;

import java.util.ArrayList;
import java.util.List;

public class LAB7_1 {
    private static Animal getMaxSpeedAnimal(List<Animal> animals){
        Animal winner = null;
        int maxSpeed = 0;
        for (Animal currentAnimal : animals) {
            System.out.println("Animal is " + currentAnimal.getClass().getSimpleName());
            System.out.println("Speed is " + currentAnimal.getSpeed());
            if(maxSpeed < currentAnimal.getSpeed()){
                maxSpeed = currentAnimal.getSpeed();
                winner = currentAnimal;
            }
        }
        return winner;
    }

    private static List<Animal> Filter(List<Animal> animalList, boolean flyAble){
        List<Animal> animals = new ArrayList<Animal>();
        for (Animal animal : animalList) {
            if(animal.flyAble() == flyAble) animals.add(animal);
        }
        return animals;
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        Animal dog = new Animal.Builder().species("Dog").name("Lulu").speed(60).flyAble(false).build();
        Animal tiger = new Animal.Builder().species("Tiger").name("Tom").speed(100).flyAble(false).build();
        Animal goose = new Animal.Builder().species("Goose").name("Lili").speed(30).flyAble(true).build();
        Animal horse = new Animal.Builder().species("Horse").name("Flash").speed(70).flyAble(false).build();
        Animal eagle = new Animal.Builder().species("Eagle").name("Flaky").speed(40).flyAble(true).build();
        Animal falcon = new Animal.Builder().species("Falcon").name("RedWing").speed(50).flyAble(true).build();

        animals.add(dog);
        animals.add(tiger);
        animals.add(goose);
        animals.add(horse);
        animals.add(eagle);
        animals.add(falcon);

        dog.runOnTheGround();
        tiger.runOnTheGround();
        goose.runOnTheGround();
        horse.runOnTheGround();
        eagle.runOnTheGround();
        falcon.runOnTheGround();

        List<Animal> flyAbleAnimals = Filter(animals, true);
        List<Animal> runAbleAnimals = Filter(animals, false);
        for (Animal flyableAnimal : flyAbleAnimals) {
            flyableAnimal.runOnTheGround();
        }

        for (Animal runAbleAnimal : runAbleAnimals) {
            runAbleAnimal.runOnTheGround();
        }

    }
}
