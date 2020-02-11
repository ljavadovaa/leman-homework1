package hw01;
import java.util.Random;
import java.util.Scanner;

public class NumbersApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let the game begin!");
        String name = "Leman";
        int[] a = new int[100];
        int max = 100,i;
        int rand = (int) (Math.random()*(max+1));
        boolean flag = true;
        while (flag)
        {
            i = 0;
            a[i] = sc.nextInt();
            if (a[i] < rand)
                System.out.println("Your number is too small. Please, try again.");
            else if (a[i] > rand)
                System.out.println("Your number is too big. Please, try again.");
            else
            {
                flag = false;
                System.out.printf("Congratulations, %s!",name);
            }
            i++;
        }
    }
}
