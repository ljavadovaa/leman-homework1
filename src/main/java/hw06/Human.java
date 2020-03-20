package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private String[][] schedule;
    private Human[] children;

    public Human() { }

    public Human(String name, String surname, int year, int IQ, String[][] schedule) {
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

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String[][] getSchedule() { return schedule; }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                IQ == human.IQ &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                Arrays.equals(schedule, human.schedule) &&
                Arrays.equals(children, human.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, IQ);
        result = 31 * result + Arrays.hashCode(schedule);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d, schedule=%s}", name, surname, year, IQ, Arrays.deepToString(schedule));
    }
}
