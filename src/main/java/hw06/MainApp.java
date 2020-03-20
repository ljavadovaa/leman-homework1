package hw06;


public class MainApp {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        schedule[0][0] = DayOfWeek.Sunday.name();
        schedule[0][1] = "do home work";
        schedule[1][0] = DayOfWeek.Monday.name();
        schedule[1][1] = "go to courses; watch a film.";
        schedule[2][0] = DayOfWeek.Tuesday.name();
        schedule[2][1] = "go to the cinema";
        schedule[3][0] = DayOfWeek.Wednesday.name();
        schedule[3][1] = "meet with friends";
        schedule[4][0] = DayOfWeek.Thusday.name();
        schedule[4][1] = "visit your parents";
        schedule[5][0] = DayOfWeek.Friday.name();
        schedule[5][1] = "talk to your boss";
        schedule[6][0] = DayOfWeek.Saturday.name();
        schedule[6][1] = "go to the lunapark";

        Pet pet = new Pet(Species.DOG,"Rock",5,75,new String[]{"eat", "drink", "sleep"});
        Human human = new Human("Name","Surname",1,1,new String[][]{{DayOfWeek.Monday.name(),", go to courses; watch a film."},{DayOfWeek.Tuesday.name(),", go to the cinema"}});
        Human mother = new Human("Jane","Karleone");
        Human father = new Human("Vito","Karleone");
        Human child1 = new Human("Michael","Karleone",19777,90);
        Human child2 = new Human("Mike","Karleone",1979,91);
        Human child3 = new Human("Matthew","Karleone",1980,89);
        Human child4 = new Human("Malcolm","Karleone",1981,87);
        Human[] children = new Human[]{child1,child2,child3};
        Family family = new Family(father,mother,children,pet);


        family.addChild(child1);  family.addChild(child2);  family.addChild(child3);  family.addChild(child4);
        family.deleteChild(1);
        family.deleteObject(child1);
        System.out.println(family.countFamily());
        System.out.println(pet.toString());
        System.out.println(family.toString());
        System.out.println(human.toString());

        for (int i = 0; i < 10000000; i++) {
            new Human();
        }
    }
}
