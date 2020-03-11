package hw09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    public FamilyService fs;

    @BeforeEach
    void beforeEach() {
        this.fs = new FamilyService();

        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");
        Set<String> habits2 = new HashSet<>();
        habits2.add("jump"); habits2.add("sleep");

        Dog dog = new Dog("Rock",5,75,habits1);
        Woman woman1 = new Woman("Jane","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        HashSet<Pet> pets1 = new HashSet<>();
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Family family1 = new Family(woman1, man1, children1, pets1);
        pets1.add(dog);

        DomesticCat cat = new DomesticCat("Mikky",2,75,habits2);
        Woman woman2 = new Woman("Janeee","Karleoneee");
        Man man2 = new Man("Vitooo","Karleoneee");
        List<Human> children2 = new ArrayList<>();
        HashSet<Pet> pets2 = new HashSet<>();
        Human child4 = new Human("Michaeeeeel","Karleoneeeee",1977,90);
        Human child5 = new Human("Mikeeeeeee","Karleoneeeeee",1979,91);
        Family family2 = new Family(woman2, man2, children2, pets2);
        pets2.add(cat);

        fs = new FamilyService();
        fs.famDao.saveFamily(family1);
        fs.famDao.saveFamily(family2);

        family1.addChild(child1);   family1.addChild(child2);  family1.addChild(child3);
        family2.addChild(child4);   family2.addChild(child5);
    }

    @Test
    void getAllFamilies() {
        int expected = 2;
        int actual =  fs.getAllFamilies().size();
        assertEquals(expected, actual);
    }

    @Test
    void getFamiliesBiggerThan() {
        int num = 4;
        int expected = 1;
        int actual = fs.getFamiliesBiggerThan(num).size();
        assertEquals(expected, actual);
    }

    @Test
    void getFamiliesLessThan() {
        int num = 6;
        int expected = 2;
        int actual = fs.getFamiliesLessThan(num).size();
        assertEquals(expected, actual);
    }

    @Test
    void countFamiliesWithMemberNumber() {
        int num = 4;
        int expected = 1;
        int actual = fs.countFamiliesWithMemberNumber(num);
        assertEquals(expected, actual);
    }

    @Test
    void createNewFamily() {
        Woman woman1 = new Woman("Jane","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Family family3 = new Family(woman1, man1, children1);
        family3.addChild(child1);   family3.addChild(child2);
        fs.famDao.saveFamily(family3);

        int expected = 3;
        int actual = fs.getAllFamilies().size();
        assertEquals(expected, actual);
    }

    @Test
    void bornChild() {
        Woman woman1 = new Woman("Jannee","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Family family3 = new Family(woman1, man1, children1);
        fs.bornChild(family3, "Lisa", "Kinder");
        int expected = 3;
        int actual = family3.countFamily();
        assertEquals(expected,actual);
    }

    @Test
    void adoptChild() {
        Woman woman1 = new Woman("Jannee","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Human child2 = new Human("Mike","Karleone",1979,91);
        Family family3 = new Family(woman1, man1, children1);
        fs.adoptChild(family3,child2);
        int expected = 3;
        int actual = family3.countFamily();
        assertEquals(expected,actual);
    }

    @Test
    void deleteAllChildrenOlderThen() {
        Woman woman1 = new Woman("Jane","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Human child1 = new Human("Michael","Karleone",2000,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Family family5 = new Family(woman1, man1, children1);
        family5.addChild(child1);   family5.addChild(child2);
        fs.famDao.saveFamily(family5);
        fs.deleteAllChildrenOlderThen(22);

        int expected = 3;
        int actual = family5.countFamily();
        assertEquals(expected,actual);
    }

    @Test
    void getFamilyById() {
        int index = 0;
        Family expected = fs.getFamilyById(index);
        Family actual = fs.getAllFamilies().get(index);
        assertEquals(expected,actual);
    }

    @Test
    void getPets() {
        Woman woman1 = new Woman("Jannee","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Human child2 = new Human("Mike","Karleone",1979,91);
        HashSet<Pet> pets1 = new HashSet<>();
        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");
        Dog dog = new Dog("Rock",5,75,habits1);
        pets1.add(dog);
        Family family3 = new Family(woman1, man1, children1, pets1);
        family3.addChild(child2);

        int expected = 1;
        int actual = family3.getPet().size();
        assertEquals(expected,actual);
    }

    @Test
    void addPet() {
        Woman woman1 = new Woman("Jannee","Karleone");
        Man man1 = new Man("Vito","Karleone");
        List<Human> children1 = new ArrayList<>();
        Human child2 = new Human("Mike","Karleone",1979,91);
        HashSet<Pet> pets1 = new HashSet<>();
        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");
        Dog dog = new Dog("Rock",5,75,habits1);
        Family family4 = new Family(woman1, man1, children1, pets1);
        family4.addChild(child2);
        fs.addPet(1,dog);

        int expected = 2;
        int actual = fs.getPets(1).size();
        assertEquals(expected,actual);
    }

    @Test
    void count() {
        int expected = 2;
        int actual = fs.getAllFamilies().size();
        assertEquals(expected,actual);
    }

    @Test
    void displayAllFamilies() {
    }

}
