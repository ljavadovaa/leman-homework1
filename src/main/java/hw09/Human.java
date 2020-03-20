package hw09;

import java.util.Map;
import java.util.Objects;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int IQ;
    private Map<DaysOfWeek, String> schedule;

    public Human(String name, String surname, int year, int IQ, Map<DaysOfWeek,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.IQ = IQ;
        this.schedule = schedule;
    }

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

    public Human() { }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public Map<DaysOfWeek,String> getSchedule() { return schedule; }
    public void setSchedule(Map<DaysOfWeek,String> schedule) { this.schedule = schedule; }

    public void greetPet() {
        System.out.printf("Hello, %s!", Species.UNKNOWN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                IQ == human.IQ &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                schedule.equals(human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, IQ, schedule);
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d, schedule=%s}", name, surname, year, IQ, schedule);
    }
}
