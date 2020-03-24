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
      .append("10. Save data.\n\n")
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
          System.out.println("Data loaded. Press 'Enter' to go back to main menu");
          input = sc.nextLine();
          break;
        }
        case "2": {
          System.out.println(fc.displayAllFamilies());
          input = sc.nextLine();
          break;
        }
        case "3": {
          System.out.println("Enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesBiggerThan(num))
            System.out.println(f.prettyFormat());
          input = sc.nextLine();
          break;
        }
        case "4": {
          System.out.println("Enter a number");
          int num = sc.nextInt();
          for (Family f: fc.getFamiliesLessThan(num))
            System.out.println(f.prettyFormat());
          input = sc.nextLine();
          break;
        }
        case "5": {
          System.out.println("Enter a number");
          int num = sc.nextInt();
          System.out.println(fc.countFamiliesWithMemberNumber(num));
          input = sc.nextLine();
          break;
        }
        case "6": {
          System.out.print("Enter mother's name:");
          String mName = sc.nextLine();

          System.out.print("Enter mother's surname:");
          String mSurname = sc.nextLine();

          System.out.print("Enter mother's birthyear:");
          String mBirthYear = sc.nextLine();

          System.out.print("Enter mother's birthmonth:");
          String mBirthMonth = sc.nextLine();

          System.out.print("Enter mother's birthday:");
          String mBirthDay = sc.nextLine();

          System.out.print("Enter mother's IQ:");
          int mIQ = Integer.parseInt(sc.nextLine());

          StringBuilder mBirthDate = new StringBuilder();
          mBirthDate.append(mBirthDay).append("/").append(mBirthMonth).append("/").append(mBirthYear);

          System.out.print("Enter father's name:");
          String fName = sc.nextLine();

          System.out.print("Enter father's surname:");
          String fSurname = sc.nextLine();

          System.out.print("Enter father's birthyear:");
          String fBirthYear = sc.nextLine();

          System.out.print("Enter father's birthmonth:");
          String fBirthMonth = sc.nextLine();

          System.out.print("Enter father's birthday:");
          String fBirthDay = sc.nextLine();

          System.out.print("Enter father's IQ:");
          int fIQ = Integer.parseInt(sc.nextLine());

          StringBuilder fBirthDate = new StringBuilder();
          fBirthDate.append(fBirthDay).append("/").append(fBirthMonth).append("/").append(fBirthYear);

          Man father = new Man(fName, fSurname, fBirthDate.toString());
          Woman mother = new Woman(mName, mSurname, mBirthDate.toString());
          father.setIQ(fIQ);
          mother.setIQ(mIQ);

          Set<String> habits = new HashSet<>();
          habits.add("eat"); habits.add("drink"); habits.add("sleep");

          ArrayList<Human> children = new ArrayList<>();
          HashSet<Pet> pets = new HashSet<>();
          Dog dog = new Dog("Rock",5,75, habits);
          Family family = new Family(mother, father, children);
          family.setPet(pets);
          pets.add(dog);
          fc.getAllFamilies().add(family);

          System.out.println("Family created. Press 'Enter' to go back to Main Menu.");
          input = sc.nextLine();
          break;
        }
        case "7": {
          System.out.println("Enter family's ID");
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
              int familyIDToB = sc.nextInt();

              if (fc.getFamilyById(familyIDToB).countFamily() < 4) {
                System.out.println("Enter boy's name");
                String bName = sc.next();

                System.out.println("Enter girl's name");
                String gName = sc.next();

                fc.bornChild(fc.getFamilyById(familyIDToB), bName, gName);
                fc.saveFamily(fc.getFamilyById(familyIDToB));
              } else throw new FamilyOverflowException("Family member's cannot bigger than 4!");
            }
            else if (opr.equals("2")) {
              System.out.println("Enter family's ID");
              int familyIDToA = sc.nextInt();

              if (fc.getFamilyById(familyIDToA).countFamily() < 4) {
                System.out.println("Enter child's name");
                String cName = sc.next();

                System.out.println("Enter child's surname");
                String cSurname = sc.next();

                System.out.println("Enter child's birthdate like 'dd/MM/yyyy ");
                String cBirthYear = sc.next();

                System.out.println("Enter child's IQ");
                int cIQ = sc.nextInt();

                Human cAdopted = new Human(cName, cSurname, cBirthYear, cIQ);
                fc.adoptChild(fc.getFamilyById(familyIDToA), cAdopted);
              } else throw new FamilyOverflowException("Family can not include members more than 4!");
            }

          } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
          } catch (Exception ex) {
            System.out.println("You entered wrong input. Press 'Enter' to go back to main menu");
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

