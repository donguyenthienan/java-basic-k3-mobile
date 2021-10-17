package lesson06;

import java.util.ArrayList;
import java.util.List;

public class LAB6 {

    public static Animal getMaxSpeedAnimal(List<Animal> animals){
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

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Horse());
        animals.add(new Tiger());
        Animal winner = getMaxSpeedAnimal(animals);
        System.out.println("Winner is " + winner.getClass().getSimpleName());
    }
}
