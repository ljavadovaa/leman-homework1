package hw10;

import java.util.Set;

public abstract class Pet {
    String nickname;
    int age;
    int trickLevel;
    Set<String> habits;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet( String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() { }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public Set<String> getHabits() { return habits; }
    public void setHabits(Set<String> habits) { this.habits = habits; }

    public abstract void respond();

    public void foul(){
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return String.format("{nickname='%s', age=%d, trickLevel=%d, habits=%s}", nickname, age, trickLevel, habits);
    }
}
