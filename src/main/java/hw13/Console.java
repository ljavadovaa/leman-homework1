package hw13;

import hw13.controller.FamilyController;
import hw13.entities.*;

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
            .append("10. Save data.\n")
            .append("Please enter a command:");

    Scanner sc = new Scanner(System.in);
    FamilyController fc = new FamilyController();
    String input = "";

    while (!input.equals("exit")) {
      System.out.println(inputs.toString());
      input = sc.nextLine();
      switch (input) {
        case "1":{
          fc.getData();
          System.out.println("Data loaded. Press enter to go back to main menu");
          input = sc.nextLine();
          break;
        }
        case "2": {
          System.out.println(fc.displayAllFamilies());
          input = sc.nextLine();
          break;
        }
        case "3": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesBiggerThan(num))
            System.out.println(f.prettyFormat());
          input = sc.nextLine();
          break;
        }
        case "4": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesLessThan(num))
            System.out.println(f.prettyFormat());
          input = sc.nextLine();
          break;
        }
        case "5": {
          System.out.println("enter a number");
          int num = sc.nextInt();
          System.out.println(fc.countFamiliesWithMemberNumber(num));
          input = sc.nextLine();
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


          ArrayList<Human> children = new ArrayList<>();
          HashSet<Pet> pets = new HashSet<>();
          Dog dog = new Dog("Rock",5,75,habits);
          Family family = new Family(mother, father, children);
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
              if (fc.getFamilyById(familyIDtoBirth).countFamily() < 5) {
                System.out.println("Enter a boy's name");
                String boysName = sc.next();

                System.out.println("Enter a girl's name");
                String girlsName = sc.next();

                fc.bornChild(fc.getFamilyById(familyIDtoBirth), boysName, girlsName);
                fc.saveFamily(fc.getFamilyById(familyIDtoBirth));
              } else throw new FamilyOverflowException("Family member's cannot bigger than 5!");
            }
            else if (opr.equals("2")) {
              System.out.println("Enter family's ID");
              int familyIDToAdopt = sc.nextInt();
              if (fc.getFamilyById(familyIDToAdopt).countFamily() < 5) {
                System.out.println("Enter a child's name");
                String childsName = sc.next();

                System.out.println("Enter a child's surname");
                String childsSurname = sc.next();

                System.out.println("Enter a child's birthdate like 'dd/MM/yyyy ");
                String childsBirthYear = sc.next();

                System.out.println("Enter child's IQ");
                int childsIQ = sc.nextInt();

                Human childAdopted = new Human(childsName, childsSurname, childsBirthYear, childsIQ);
                fc.adoptChild(fc.getFamilyById(familyIDToAdopt), childAdopted);
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
        case "10": {
          fc.loadData();
          System.out.println("Data saved!");
          break;
        }

      }
    }
  }
}

