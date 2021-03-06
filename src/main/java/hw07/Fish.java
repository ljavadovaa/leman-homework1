package hw07;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void eat() {
        System.out.println("I'm fish, I need to eat something");
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n",Species.FISH);
    }
}
