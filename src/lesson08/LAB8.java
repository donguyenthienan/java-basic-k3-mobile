package lesson08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LAB8 {

    private static List<Animal> filter(List<Animal> animalList, boolean flyAble){
        List<Animal> animals = new ArrayList<Animal>();
        for (Animal animal : animalList) {
            if(animal.flyable() == flyAble){
                animals.add(animal);
            }
        }
        return animals;
    }

    public static Animal getMaxSpeedAnimal(List<Animal> animals){
        Animal winner = null;
        double maxSpeed = 0;
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

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal horse = new Horse();
        Animal tiger = new Tiger();
        Animal eagle = new Eagle();
        Animal squirrel = new Squirrel();
        Animal falcon = new Falcon();

        List<Animal> RunAbleAnimals = filter(Arrays.asList(dog, horse, tiger, eagle, squirrel, falcon), false);
        Animal winner = getMaxSpeedAnimal(RunAbleAnimals);
        System.out.printf("Winner is %s", winner.getClass().getSimpleName());
    }
}