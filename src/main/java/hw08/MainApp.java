package hw08;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        HashMap< String,String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.Sunday.name(),"do home work");
        schedule.put(DayOfWeek.Monday.name(),"go to courses; watch a film.");
        schedule.put(DayOfWeek.Tuesday.name(),"go to the cinema");
        schedule.put(DayOfWeek.Wednesday.name(),"meet with friends");
        schedule.put(DayOfWeek.Thursday.name(),"visit your parents");
        schedule.put(DayOfWeek.Friday.name(),"talk to your boss");
        schedule.put(DayOfWeek.Saturday.name(),"go to the lunapark");

        HashSet<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");

        Dog dog = new Dog("Rock",5,75,habits1);
        Human human = new Human("Name","Surname",1,1, schedule);
        Woman woman = new Woman("Jane","Karleone");
        Man man = new Man("Vito","Karleone");
        ArrayList<Human> children = new ArrayList<>();
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Family family = new Family(woman, man, children, dog);

        family.addChild(child1);   family.addChild(child2);  family.addChild(child3);
        family.deleteChild(1);

        System.out.println(dog.toString());
        System.out.println(family.toString());
        System.out.println(human.toString());
    }
}
