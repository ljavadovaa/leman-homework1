package hw07;

public class Dog extends Pet {
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void foul() {
        super.foul();
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n",Species.DOG);
    }

}
