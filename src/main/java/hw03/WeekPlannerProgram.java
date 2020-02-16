package hw03;

import java.util.Scanner;

public class WeekPlannerProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film.";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "go to the cinema";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "meet with friends";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "visit your parents";
        scedule[5][0] = "Friday";
        scedule[5][1] = "talk to your boss";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "go to the lunapark";
        String week = "";

        do {
                System.out.println("Please, input the day of the week: ");
                week = sc.next().toLowerCase().trim();

                if(week.equals("exit"))
                    break;

                if(!week.equals("monday")  && !week.equals("sunday") && !week.equals("tuesday") && !week.equals("wednesday") && !week.equals("thursday") && !week.equals("friday") && !week.equals("saturday"))
                    System.out.println("enter valid weekday");
                else
                    switch (week)
                    {
                        case "sunday":
                            System.out.printf("Your tasks for Sunday: %s\n",scedule[0][1]);
                            break;
                        case "monday":
                            System.out.printf("Your tasks for Monday: %s\n",scedule[1][1]);
                            break;
                        case "tuesday":
                            System.out.printf("Your tasks for Tuesday: %s\n",scedule[2][1]);
                            break;
                        case "wednesday":
                            System.out.printf("Your tasks for Wednesday: %s\n",scedule[3][1]);
                            break;
                        case "thursday":
                            System.out.printf("Your tasks for Thursday: %s\n",scedule[4][1]);
                            break;
                        case "friday":
                            System.out.printf("Your tasks for Friday: %s\n",scedule[5][1]);
                            break;
                        case "saturday":
                            System.out.printf("Your tasks for Saturday: %s\n",scedule[6][1]);
                            break;
                    }

        } while (!week.equals("exit"));

    }

}
