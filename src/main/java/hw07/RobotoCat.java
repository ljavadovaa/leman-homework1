package hw07;

public class RobotoCat extends Pet {
    public RobotoCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname,age,trickLevel,habits);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n",Species.ROBOTOCAT);
    }
}
