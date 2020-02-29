package hw08;

import java.util.HashSet;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n",Species.FISH);
    }
}
