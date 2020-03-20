package hw07;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private Pet pet;

    public Human(String name, String surname, int year, int IQ) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.IQ = IQ;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }


    public void greetPet() {
        System.out.printf("Hello, %s!", Species.UNKNOWN);
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d}", name, surname, year, IQ);
    }
}
