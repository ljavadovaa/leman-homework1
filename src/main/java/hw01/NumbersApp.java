package hw01;
import java.util.Scanner;

public class NumbersApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let the game begin!");
        System.out.println("Please, enter player's name");
        String name = input.next();
        System.out.println("Please, enter any number between 0-100");
        final int MAX = 100;
        int i;
        int random = (int) (Math.random()*(MAX+1));
        while (true)
        {
            i = 0;
            int a = input.nextInt();
            if (a < random)
                System.out.println("Your number is too small. Please, try again.");
            else if (a > random)
                System.out.println("Your number is too big. Please, try again.");
            else
            {
                System.out.printf("Congratulations, %s!",name);
                break;
            }
            i++;
        }
    }
}
