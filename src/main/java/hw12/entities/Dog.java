package hw12.entities;

import hw12.entities.Pet;
import hw12.entities.Species;

import java.util.Set;

public class Dog extends Pet {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void foul() {
        System.out.println("I'm dog, I need to cover it up");
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", Species.DOG);
    }

}
