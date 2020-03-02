package hw06;

public class Human {

    public Human() {

    }

    enum DayOfWeek {
        Sunday, Monday, Tuesday, Wednesday, Thusday, Friday, Saturday;
    }

    private String name;
    private String surname;
    private int year;
    private int IQ;
    private String[][] schedule;
    private Human[] children;

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

    public Human(Human father, Human mother, Human[] child, Pet pet) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public String convert2DArrayToString() {
        StringBuilder sb = new StringBuilder();
        if (schedule == null) return "";
        for (String[] sc1 : schedule) {
            for (String sc2 : sc1)
                sb.append(sc2);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, IQ=%d, schedule=%s}", name, surname, year, IQ, convert2DArrayToString());
    }
}
