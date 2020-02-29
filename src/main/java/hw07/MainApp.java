package hw07;


public class MainApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Rock",5,75,new String[]{"eat", "drink", "sleep"});
        DomesticCat domesticCat = new DomesticCat("Kitty",3,34,new String[]{"jump", "eat", "sleep"});
        Human human = new Human("Name","Surname",1,1);
        Woman woman = new Woman("Jane","Karleone");
        Man man = new Man("Vito","Karleone");
        Human[] children1 = new Human[2];
        Human[] children2 = new Human[1];
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Family family1 = new Family(woman,man,children1,dog);
        Family family2 = new Family(woman,man,children2,domesticCat);


        family1.addChild(child1);  family1.addChild(child2);  family2.addChild(child3);
        family1.deleteChild(1);

        //domesticCat.foul();
        System.out.println(dog.toString());
        System.out.println(family1.toString());
        System.out.println(family2.toString());
        System.out.println(human.toString());
    }
}
