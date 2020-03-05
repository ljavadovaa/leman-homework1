package hw10;

import java.util.HashSet;

public class DomesticCat extends Pet {
    public DomesticCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void foul() {
        System.out.println("I'm cat, I need to cover it up");
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", Species.DOMESTICCAT);
    }
}
