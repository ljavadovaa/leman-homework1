package hw08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTest {
    public Family task;

    @BeforeEach
    void setUp() {
        Woman woman = new Woman("Jane","Karleone");
        Man man = new Man("Vito","Karleone");
        Set<String> habits1 = new HashSet<>();
        habits1.add("eat"); habits1.add("drink"); habits1.add("sleep");
        Dog dog = new Dog("Rock",5,75,habits1);
        ArrayList<Human> children = new ArrayList<>();
        this.task = new Family(woman, man, children, Collections.singleton(dog));
    }

    @Test
    void countFamily() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        task.deleteChild(0);
        int expected = 3;
        int actual = task.countFamily();
        assertEquals(expected,actual);
    }

    @Test
    void addChild() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        int expected = 2;
        int actual = task.getChildren().size();
        assertEquals(expected,actual);
    }

    @Test
    void deleteChild1() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        if (child1.getName().equals("Michael")) task.deleteChildObject(child1);
        int expected = 1;
        int actual = task.getChildren().size();
        assertEquals(expected,actual);
    }

    @Test
    void deleteChild2() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1);  task.addChild(child2);
        if (child1.getName().equals("Mic") && child2.getSurname().equals("Karleone"))
            task.deleteChildObject(child1);
        int expected = 2;
        int actual = task.getChildren().size();
        assertEquals(expected,actual);
    }

    @Test
    void deleteChild3() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        boolean expected = true;
        boolean actual = task.deleteChild(0);
        assertEquals(expected,actual);
    }

    @Test
    void deleteChild4() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        boolean expected = false;
        boolean actual = task.deleteChild(3);
        assertEquals(expected,actual);
    }

}
