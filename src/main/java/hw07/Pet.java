package hw07;


import java.util.Arrays;

public abstract class Pet {

    enum Species {
        DOG, FISH, DOMESTICCAT, ROBOTOCAT, UNKNOWN;
    }

    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() { }

    public abstract void respond();

    public void foul(){
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return String.format("{nickname='%s', age=%d, trickLevel=%d, habits=%s}",nickname, age, trickLevel, Arrays.toString(habits));
    }

}
