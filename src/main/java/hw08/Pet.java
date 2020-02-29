package hw08;

import java.util.HashSet;

public abstract class Pet {
    String nickname;
    int age;
    int trickLevel;
    HashSet<String> habits;

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public HashSet<String> getHabits() { return habits; }
    public void setHabits(HashSet<String> habits) { this.habits = habits; }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet( String nickname, int age, int trickLevel, HashSet<String> habits) {
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
        return String.format("{nickname='%s', age=%d, trickLevel=%d, habits=%s}", nickname, age, trickLevel, habits);
    }
}
