package hw07;

public class Man extends Human {
    public Man(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void greetPet() {
        System.out.printf("I'm a man. Hello, %s!\n", Pet.Species.DOMESTICCAT);
    }

    public void repairCar() {
        System.out.printf("I'm a man, I repair my car by myself\n");
    }
}
