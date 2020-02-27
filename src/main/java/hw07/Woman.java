package hw07;

public class Woman extends Human {
    public Woman(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void greetPet() {
        System.out.printf("I'm a woman. Hello, %s!\n", Pet.Species.DOG);
    }

    public void makeup() {
        System.out.printf("I'm a woman, I'm spending 1 hour doing makeup every day\n");
    }
}
