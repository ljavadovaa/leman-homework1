package hw10;

import hw08.DaysOfWeek;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Map<DaysOfWeek, String> schedule = new HashMap<>();
        schedule.put(DaysOfWeek.Sunday,"do home work");
        schedule.put(DaysOfWeek.Monday,"go to courses; watch a film.");
        schedule.put(DaysOfWeek.Tuesday,"go to the cinema");
        schedule.put(DaysOfWeek.Wednesday,"meet with friends");
        schedule.put(DaysOfWeek.Thursday,"visit your parents");
        schedule.put(DaysOfWeek.Friday,"talk to your boss");
        schedule.put(DaysOfWeek.Saturday,"go to the lunapark");

        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");

        Set<String> habits2 = new HashSet<>();
        habits2.add("jump"); habits2.add("sleep");

        Human human = new Human("Name","Surname","20/03/2016",1, schedule);

        Dog dog = new Dog("Rock",5,75,habits1);
        Woman woman1 = new Woman("Jane","Karleone","21/10/1978");
        Man man1 = new Man("Vito","Karleone","08/04/1980");
        List<Human> children1 = new ArrayList<>();
        HashSet<Pet> pets1 = new HashSet<>();
        Human child1 = new Human("Michael","Karleone","23/02/1977",90);
        Human child2 = new Human("Mike","Karleone","12/05/1979",91);
        Human child3 = new Human("Matthew","Karleone","25/08/1980",89);
        Family family1 = new Family(woman1, man1, children1, pets1);
        pets1.add(dog);

        DomesticCat cat = new DomesticCat("Mikky",2,75,habits2);
        Woman woman2 = new Woman("Janeee","Karleoneee","08/04/1980");
        Man man2 = new Man("Vitooo","Karleoneee","13/04/1980");
        List<Human> children2 = new ArrayList<>();
        HashSet<Pet> pets2 = new HashSet<>();
        Human child4 = new Human("Michaeeeeel","Karleoneeeee","09/08/1977",90);
        Human child5 = new Human("Mikeeeeeee","Karleoneeeeee","12/10/1979",91);
        Family family2 = new Family(woman2, man2, children2, pets2);
        pets2.add(cat);

        Woman woman3 = new Woman("Jaaaaaane","Karleone","08/10/1980");
        Man man3 = new Man("Viiiiiiitooo","Karleoneee","08/04/1970");

        Human child6 = new Human("Mikkkkkkee","Kaaaarleoneeeeee","30/12/1979",91);

        FamilyController fc = new FamilyController();
        fc.famServ.famDao.saveFamily(family1);
        fc.famServ.famDao.saveFamily(family2);

        family1.addChild(child1);   family1.addChild(child2);  family1.addChild(child3);
        family1.deleteChild(1);
        family2.addChild(child4);   family2.addChild(child5);
        family2.deleteChild(0);

        System.out.println(fc.getFamiliesBiggerThan(3));
        System.out.println(fc.getFamiliesLessThan(6));
        System.out.println(fc.countFamiliesWithMemberNumber(3));
        System.out.println(fc.count());
        fc.adoptChild(family2,child6);
        System.out.println(fc.displayAllFamilies());
        fc.deleteAllChildrenOlderThen(20);
        System.out.println(fc.getFamilyById(0));
        System.out.println(fc.getPets(1));
        fc.addPet(1,dog);
        fc.createNewFamily(woman3,man3);
        fc.bornChild(family2,"Lisa","Mac");
        System.out.println(fc.displayAllFamilies());
        System.out.println(fc.getAllFamilies());

         //System.out.println(human.toString());
    }
}
