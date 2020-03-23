package hw12.entities;

public final class Man extends Human {
    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public void greetPet() {
        System.out.printf("I'm a man. Hello, %s!\n", Species.DOMESTICCAT);
    }

    public void repairCar() {
        System.out.println("I'm a man, I repair my car by myself\n");
    }
}
