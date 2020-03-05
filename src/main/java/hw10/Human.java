package hw10;

import java.util.HashMap;

public class Human {

    private String name;
    private String surname;
    private long birthDate;
    private String birth;
    private int IQ;
    private HashMap< String,String> schedule;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public long  getBirthDate() { return birthDate; }
    public void setBirthDate(long  birthDate) { this.birthDate = birthDate; }
    public int getIQ() { return IQ; }
    public void setIQ(int IQ) { this.IQ = IQ; }
    public HashMap< String,String> getSchedule() { return schedule; }
    public void setSchedule(HashMap< String,String> schedule) { this.schedule = schedule; }

    public Human(String name, String surname, long birthDate, int IQ, HashMap< String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.IQ = IQ;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birth, int IQ) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.IQ = IQ;
    }

    public Human(String name, String surname, long  birthDate, int IQ) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.IQ = IQ;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void greetPet() {
        System.out.printf("Hello, %s!", Species.UNKNOWN);
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%s, IQ=%d, schedule=%s}", name, surname, birthDate, IQ, schedule);
    }
}
