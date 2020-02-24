package hw05;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private String[][] schedule;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getIQ() { return IQ; }
    public void setIQ(int IQ) { this.IQ = IQ; }
    public String[][] getSchedule() { return schedule; }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }


    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d, schedule=%s}", name, surname, year, IQ, Arrays.deepToString(schedule));
    }
}
