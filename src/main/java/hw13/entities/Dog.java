package hw13.entities;

import java.util.Set;

public class Dog extends Pet {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        this.setSpecies(Species.DOG);
        this.setNickname(nickname);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);
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
