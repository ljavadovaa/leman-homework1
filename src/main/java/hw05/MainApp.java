package hw05;

public class MainApp {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setSpecies("dog"); pet.setNickname("Rock"); pet.setAge(5);
        pet.setTricklevel(75); pet.setHabits(new String[]{"eat", "drink", "sleep"});

        Human human = new Human();
        human.setName("Name"); human.setSurname("Surname"); human.setYear(1); human.setIQ(1);
        human.setSchedule(new String[]{"[day, task]","[day_2, task_2]"});

        Human mother = new Human();
        mother.setName("Jane"); mother.setSurname("Karleone");

        Human father = new Human();
        father.setName("Vito"); father.setSurname("Karleone");

        Human child = new Human();
        child.setName("Michael"); child.setSurname("Karleone"); child.setYear(1977); child.setIQ(90);

        Human child1 = new Human();
        child1.setName("Mike"); child1.setSurname("Karleone"); child1.setYear(1979); child1.setIQ(91);

        Family family = new Family();
        family.setFather(father); family.setMother(mother); family.setPet(pet); family.setChildren(new Human[]{child, child1});
        family.addChild(child); family.addChild(child1);
        family.deleteChild(0);

        System.out.println(pet.toString());
        System.out.println(family.toString());
        System.out.println(human.toString());
    }
}
