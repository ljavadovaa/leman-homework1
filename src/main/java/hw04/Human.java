package hw04;

public class Human {
    String name;
    String surname;
    int year;
    int IQ;
    Pet pet;
    Human mother;
    Human father;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }
    public Human(String name, String surname, int year, int IQ, Human mother, Human father, Pet pet ) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.IQ = IQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
    }
    public Human() {
    }

    public void greetPet(){
        System.out.printf("Hello, %s!",pet.nickname);
    }

    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is ",pet.species,pet.age);
        if (pet.tricklevel > 50) System.out.print("very sly");
        else System.out.print("almost not sly");
    }


    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s, father=%s, pet=%s}", name, surname, year, IQ, mother, father, pet);
    }
}
