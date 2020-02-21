package hw04;

public class MainApp {
    public static void main(String[] args) {
        Pet pet = new Pet("dog","Rock",5,75, new String[]{"eat", "drink", "sleep"});
        Human mother = new Human("Jane","Karleone",1978);
        Human father = new Human("Vito","Karleone",1975);
        Human child = new Human("Michael","Karleone",1977,90,mother,father,pet);

        System.out.println(pet.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(child.toString());
    }
}
