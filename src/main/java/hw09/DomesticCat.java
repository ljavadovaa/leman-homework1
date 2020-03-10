package hw09;


import java.util.Set;

public class DomesticCat extends Pet {
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
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
