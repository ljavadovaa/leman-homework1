package hw05;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int tricklevel;
    private String[] habits;

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getTricklevel() { return tricklevel; }
    public void setTricklevel(int tricklevel) { this.tricklevel = tricklevel; }
    public String[] getHabits() { return habits; }
    public void setHabits(String[] habits) { this.habits = habits; }

    public void eat(){
        System.out.println("I'm eating");
    }

    public void respond(){
        System.out.printf("Hello, owner. I am - %s. I miss you!",nickname);
    }

    public void foul(){
        System.out.println("I need to cover it up");
    }


    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, tricklevel=%d, habits=%s}", species, nickname, age, tricklevel, Arrays.toString(habits));
    }
}
