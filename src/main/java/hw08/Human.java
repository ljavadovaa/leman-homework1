package hw08;

import java.util.Map;

public class Human {

    enum DayOfWeek {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
    }

    private String name;
    private String surname;
    private int year;
    private int IQ;
    private Map< String,String> schedule;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getIQ() { return IQ; }
    public void setIQ(int IQ) { this.IQ = IQ; }
    public Map< String,String> getSchedule() { return schedule; }
    public void setSchedule(Map< String,String> schedule) { this.schedule = schedule; }

    public Human(String name, String surname, int year, int IQ, Map< String,String> schedule) {
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

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d, schedule=%s}", name, surname, year, IQ, schedule);
    }
}
