package hw06;

import java.util.Arrays;

public class Pet {
    enum Species {
        DOG, CAT, FISH;
    }

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public String[] getHabits() { return habits; }
    public void setHabits(String[] habits) { this.habits = habits; }

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void eat(){
        System.out.println("I'm eating");
    }

    public void respond(){
        System.out.printf("Hello, owner. I am - %s. I miss you!", nickname);
    }

    public void foul(){
        System.out.println("I need to cover it up");
    }


    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}", species, nickname, age, trickLevel, Arrays.toString(habits));
    }
}
