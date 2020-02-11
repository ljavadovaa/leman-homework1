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

        for (int i = 0; i < 7; i++) {
                System.out.println("Please, input the day of the week: ");
                scedule[i][0] = sc.next();
                if (scedule[i][0].equals("exit")) break;

                if(!scedule[i][0].equals("Monday") && !scedule[i][0].equals("Sunday") && !scedule[i][0].equals("Tuesday") && !scedule[i][0].equals("Wednesday") && !scedule[i][0].equals("Thursday") && !scedule[i][0].equals("Friday") && !scedule[i][0].equals("Saturday"))
                    System.out.println("enter valid weekday");
                else
                    switch (scedule[i][0])
                    {
                        case "Sunday":
                            System.out.printf("Your tasks for Sunday: %s\n",scedule[0][1]);
                            break;
                        case "Monday":
                            System.out.printf("Your tasks for Monday: %s\n",scedule[1][1]);
                            break;
                        case "Tuesday":
                            System.out.printf("Your tasks for Tuesday: %s\n",scedule[2][1]);
                            break;
                        case "Wednesday":
                            System.out.printf("Your tasks for Wednesday: %s\n",scedule[3][1]);
                            break;
                        case "Thursday":
                            System.out.printf("Your tasks for Thursday: %s\n",scedule[4][1]);
                            break;
                        case "Friday":
                            System.out.printf("Your tasks for Friday: %s\n",scedule[5][1]);
                            break;
                        case "Saturday":
                            System.out.printf("Your tasks for Saturday: %s\n",scedule[6][1]);
                            break;
                    }
        }

    }

}
