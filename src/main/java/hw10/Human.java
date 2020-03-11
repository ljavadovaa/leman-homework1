package hw10;

import hw08.DaysOfWeek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private long birthDate;
    private int IQ;
    private Map<DaysOfWeek, String> schedule;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public long getBirthDate() { return birthDate; }
    public void setBirthDate(long birthDate) { this.birthDate = birthDate; }
    public int getIQ() { return IQ; }
    public void setIQ(int IQ) { this.IQ = IQ; }
    public Map<DaysOfWeek,String> getSchedule() { return schedule; }
    public void setSchedule(Map<DaysOfWeek,String> schedule) { this.schedule = schedule; }

    public Human(String name, String surname, String birthDate, int IQ, Map<DaysOfWeek,String> schedule) {
        this.name = name;
        this.surname = surname;
        DateFormat frmt = new SimpleDateFormat("dd/MM/YYYY");
        try {
            Date dt = frmt.parse(birthDate);
            this.birthDate = dt.getTime();
        } catch (Exception e){
            System.out.println("Couldn't be parsed");
        }

        this.IQ = IQ;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, int IQ) {
        this.name = name;
        this.surname = surname;
        DateFormat frmt = new SimpleDateFormat("dd/MM/YYYY");
        try {
            Date dt = frmt.parse(birthDate);
            this.birthDate = dt.getTime();
        } catch (Exception e){
            System.out.println("Couldn't be parsed");
        }
        this.IQ = IQ;
    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        DateFormat frmt = new SimpleDateFormat("dd/MM/YYYY");
        try {
            Date dt = frmt.parse(birthDate);
            this.birthDate = dt.getTime();
        } catch (Exception e){
            System.out.println("Couldn't be parsed");
        }
    }

    public Human() {
    }

    public void greetPet() {
        System.out.printf("Hello, %s!", Species.UNKNOWN);
    }

    public String describeAge() {
        LocalDate now1 = LocalDate.now(ZoneId.of("GMT+3"));
        int year = now1.getYear();
        Month month = now1.getMonth();
        int dayOfMonth = now1.getDayOfMonth();

        return String.format("%s-%d-%d", month, dayOfMonth, year);
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String f = df.format(birthDate);
        return String.format("Human{name='%s', surname='%s', dateOfBirth=%s, IQ=%d, schedule=%s}", name, surname, f, IQ, schedule);
    }
}
