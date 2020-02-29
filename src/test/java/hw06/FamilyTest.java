package hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTest {
    public Family task;

    @BeforeEach
    void beforeEach() {
        Human[] child = new Human[5];
        Human mother = new Human("Jane","Karleone");
        Human father = new Human("Vito","Karleone");
        Pet pet = new Pet(Pet.Species.DOG,"Rock",5,75,new String[]{"eat", "drink", "sleep"});
        this.task = new Family(father,mother,child,pet);
    }

    @Test
    void test1() {
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        task.addChild(child1); task.addChild(child2);
        task.deleteChild(0);
        int expected = 3;
        int actual = task.countFamily();
        assertEquals(expected,actual);
    }

}
