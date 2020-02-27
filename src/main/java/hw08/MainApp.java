package hw08;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Map< String,String> schedule = new HashMap<>();
        schedule.put(Human.DayOfWeek.Sunday.name(),"do home work");
        schedule.put(Human.DayOfWeek.Monday.name(),"go to courses; watch a film.");
        schedule.put(Human.DayOfWeek.Tuesday.name(),"go to the cinema");
        schedule.put(Human.DayOfWeek.Wednesday.name(),"meet with friends");
        schedule.put(Human.DayOfWeek.Thursday.name(),"visit your parents");
        schedule.put(Human.DayOfWeek.Friday.name(),"talk to your boss");
        schedule.put(Human.DayOfWeek.Saturday.name(),"go to the lunapark");

        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");

        Pet pet = new Pet(Pet.Species.DOG,"Rock",5,75,habits1);
        Human human = new Human("Name","Surname",1,1, schedule);
        Human mother = new Human("Jane","Karleone");
        Human father = new Human("Vito","Karleone");
        List<Human> children = new ArrayList<>();
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Family family = new Family(mother, father, children,pet);

        family.addChild(child1);   family.addChild(child2);  family.addChild(child3);
        family.deleteChild(1);

        System.out.println(pet.toString());
        System.out.println(family.toString());
        System.out.println(human.toString());
    }
}
