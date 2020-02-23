package hw04;

public class MainApp {
    public static void main(String[] args) {
        Pet pet = new Pet("dog","Rock",5,75, new String[]{"eat", "drink", "sleep"});
        Human mother = new Human("Jane","Karleone");
        Human father = new Human("Vito","Karleone");
        Human child = new Human("Michael","Karleone",1977,90,mother,father,pet);

        Pet pet1 = new Pet("cat","Kitty",3,25, new String[]{"sleep", "run", "jump"});
        Human mother1 = new Human("Amanda","Brown");
        Human father1 = new Human("Jack","Brown");
        Human child1 = new Human("Daniel","Brown",1990,87,mother1,father1,pet1);


        System.out.println(pet.toString());
        System.out.println(child.toString());
        System.out.println();
        System.out.println(pet1.toString());
        System.out.println(child1.toString());
    }
}
