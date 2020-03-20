package hw05;

public class MainApp {
    public static void main(String[] args) {
        Pet pet = new Pet("dog","Rock",5,75,new String[]{"eat", "drink", "sleep"});
        Human human = new Human("Name","Surname",1,1,new String[][]{{"Monday, go to courses; watch a film."},{"Tuesday, go to the cinema"}});
        Human mother = new Human("Jane","Karleone");
        Human father = new Human("Vito","Karleone");
        Human[] children = new Human[3];
        Human child1 = new Human("Michael","Karleone",1977,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Human child4 = new Human("Malcolm","Karleone",1981,87);
        Family family = new Family(father,mother,children,pet);

        family.addChild(child1);  family.addChild(child2);  family.addChild(child3);  family.addChild(child4);
        family.deleteChild(1);
        family.deleteObject(child1);

        //System.out.println(human.convert2DArrayToString());
        System.out.println(pet.toString());
        System.out.println(family.toString());
        System.out.println(human.toString());
    }
}
