package hw01;
import java.util.Random;
import java.util.Scanner;

public class NumbersApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let the game begin!");
        System.out.println("Please, enter player's name");
        String name = input.next();
        System.out.println("Please, enter any number between 0-100");
        final int MAX = 100;
        int[] a = new int[MAX];
        int i;
        int random = (int) (Math.random()*(MAX+1));
        while (true)
        {
            i = 0;
            a[i] = input.nextInt();
            if (a[i] < random)
                System.out.println("Your number is too small. Please, try again.");
            else if (a[i] > random)
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
