package hw12;

import hw12.controller.FamilyController;
import hw12.entities.*;

import java.util.*;

public class Console {
  public static void main(String[] args) {
    StringBuilder inputs = new StringBuilder();
    inputs
            .append("1. Fill with test data.\n")
            .append("2. Display the entire list of families.\n")
            .append("3. Display a list of families where the number of people is greater than the specified number.\n")
            .append("4. Display a list of families where the number of people is less than the specified number.\n")
            .append("5. Calculate the number of families with the number of members.\n")
            .append("6. Create a new family.\n")
            .append("7. Delete a family by its index in the general list.\n")
            .append("8. Edit a family by its index in the general list.\n")
            .append("9. Remove all children over the age of majority.\n")
            .append("Please enter a command:");

    Scanner sc = new Scanner(System.in);
    FamilyController fc = new FamilyController();
    String input = "";

    while (!input.equals("exit")) {
      System.out.println(inputs.toString());
      input = sc.nextLine();
      switch (input) {
        case "1":{
          Map<DayOfWeek, String> schedule = new HashMap<>();
          schedule.put(DayOfWeek.Sunday,"do home work");
          schedule.put(DayOfWeek.Monday,"go to courses; watch a film.");
          schedule.put(DayOfWeek.Tuesday,"go to the cinema");
          schedule.put(DayOfWeek.Wednesday,"meet with friends");
          schedule.put(DayOfWeek.Thursday,"visit your parents");
          schedule.put(DayOfWeek.Friday,"talk to your boss");
          schedule.put(DayOfWeek.Saturday,"go to the lunapark");

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

          fc.famServ.famDao.saveFamily(family1);
          fc.famServ.famDao.saveFamily(family2);

          family1.addChild(child1); family1.addChild(child2); family1.addChild(child3);
          family2.addChild(child4); family2.addChild(child5); //family2.addChild(child6);
          input = sc.nextLine();
          break;
        }
        case "2": {
          System.out.println(fc.displayAllFamilies());
          break;
        }
        case "3": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesBiggerThan(num))
            System.out.println(f.prettyFormat());
          break;
        }
        case "4": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesLessThan(num))
            System.out.println(f.prettyFormat());
          break;
        }
        case "5": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          System.out.println(fc.countFamiliesWithMemberNumber(num));
          break;
        }
        case "6": {
          System.out.print("Enter mother's name:");
          String mothersName = sc.nextLine();

          System.out.print("Enter mother's surname:");
          String mothersSurname = sc.nextLine();

          System.out.print("Enter mother's birthyear:");
          String mothersBirthYear = sc.nextLine();

          System.out.print("Enter mother's birthmonth:");
          String mothersBirthMonth = sc.nextLine();

          System.out.print("Enter mother's birthday:");
          String mothersBirthDay = sc.nextLine();

          System.out.print("Enter mother's IQ:");
          int motherIq = Integer.parseInt(sc.nextLine());

          StringBuilder mothersBirthDate = new StringBuilder();
          mothersBirthDate.append(mothersBirthDay).append("/").append(mothersBirthMonth).append("/").append(mothersBirthYear);

          System.out.print("Enter father's name:");
          String fathersName = sc.nextLine();

          System.out.print("Enter father's surname:");
          String fathersSurname = sc.nextLine();

          System.out.print("Enter father's birthyear:");
          String fathersBirthYear = sc.nextLine();

          System.out.print("Enter father's birthmonth:");
          String fathersBirthMonth = sc.nextLine();

          System.out.print("Enter father's birthday:");
          String fathersBirthDay = sc.nextLine();

          System.out.print("Enter father's IQ:");
          int fathersIq = Integer.parseInt(sc.nextLine());

          StringBuilder fathersBirthDate = new StringBuilder();
          fathersBirthDate.append(fathersBirthDay).append("/").append(fathersBirthMonth).append("/").append(fathersBirthYear);

          Man father = new Man(fathersName, fathersSurname, fathersBirthDate.toString());
          Woman mother = new Woman(mothersName, mothersSurname, mothersBirthDate.toString());
          father.setIQ(fathersIq);
          mother.setIQ(motherIq);

          Set<String> habits = new HashSet<>();
          habits.add("eat"); habits.add("drink"); habits.add("sleep");

          Map<DayOfWeek, String> schedule1 = new HashMap<>();
          schedule1.put(DayOfWeek.Sunday,"do home work");
          schedule1.put(DayOfWeek.Monday,"go to courses; watch a film.");
          schedule1.put(DayOfWeek.Tuesday,"go to the cinema");
          schedule1.put(DayOfWeek.Wednesday,"meet with friends");
          schedule1.put(DayOfWeek.Thursday,"visit your parents");
          schedule1.put(DayOfWeek.Friday,"talk to your boss");
          schedule1.put(DayOfWeek.Saturday,"go to the lunapark");

          ArrayList<Human> children = new ArrayList<>();
          HashSet<Pet> pets = new HashSet<>();
          Dog dog = new Dog("Rock",5,75,habits);
          Human child = new Human("Michael","Karleone","23/02/1977");
          child.setSchedule(schedule1);
          Family family = new Family(mother, father, children);
          family.addChild(child);
          family.setPet(pets);
          pets.add(dog);
          fc.getAllFamilies().add(family);

          System.out.println("Family created. Press 'Enter' to go back to Main Menu.");
          input = sc.nextLine();
          break;
        }
        case "7": {
          System.out.println("Please enter family's ID");
          try {
            int familyID = sc.nextInt();
            fc.getAllFamilies().remove(familyID - 1);
            System.out.println("Family deleted. Press 'Enter' to go back to Main Menu.");
          } catch (Exception e) {
            System.out.println("Wrong input! Press 'Enter' to go back to Main Menu.");
          }
          break;
        }
        case "8": {
          System.out.println("Enter operation: -> 1 to give a birth -> 2 to adopt a child");
          String opr = sc.nextLine();
          try {
            if (opr.equals("1")) {
              System.out.println("Enter family's ID");
              int familyIDtoBirth = sc.nextInt();
              if (fc.getFamilyByID(familyIDtoBirth).countFamily() < 5) {
                System.out.println("Enter a boy's name");
                String boysName = sc.next();

                System.out.println("Enter a girl's name");
                String girlsName = sc.next();

                fc.bornChild(fc.getFamilyByID(familyIDtoBirth), boysName, girlsName);
                fc.saveFamily(fc.getFamilyByID(familyIDtoBirth));
              } else throw new FamilyOverflowException("Family member's cannot bigger than 5!");
            }
            else if (opr.equals("2")) {
              System.out.println("Enter family's ID");
              int familyIDToAdopt = sc.nextInt();
              if (fc.getFamilyByID(familyIDToAdopt).countFamily() < 5) {
                System.out.println("Enter a child's name");
                String childsName = sc.next();

                System.out.println("Enter a child's surname");
                String childsSurname = sc.next();

                System.out.println("Enter a child's birthdate like 'dd/MM/yyyy ");
                String childsBirthYear = sc.next();

                System.out.println("Enter child's IQ");
                int childsIQ = sc.nextInt();

                Human childAdopted = new Human(childsName, childsSurname, childsBirthYear, childsIQ);
                fc.adoptChild(fc.getFamilyByID(familyIDToAdopt), childAdopted);
              } else throw new FamilyOverflowException("Family can not include members more than 5!");
            }

          } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
          } catch (Exception ex) {
            System.out.println("You entered wrong input.  Please press enter to go back to main menu");
          }

          break;
        }
        case "9": {
          System.out.println("Enter age");
          int age = sc.nextInt();
          fc.deleteAllChildrenOlderThen(age);
          break;
        }
      }
    }
  }
}

