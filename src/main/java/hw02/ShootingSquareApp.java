package hw02;

import java.util.Scanner;

public class ShootingSquareApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("All set. Get ready to rumble!");
        char[][] a = new char[25][25];
        int[] num1 = new int[25];
        int[] num2 = new int[25];
        int max=5;
        boolean flag = true;
        int rand1 = (int) (Math.random()*(max+1));
        int rand2 = (int) (Math.random()*(max+1));
        System.out.printf("%d %d\n",rand1,rand2);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                a[i][j]='-';
            }
        }

        while (flag)
        {
            int i=1,j=1;
            num1[i]=sc.nextInt();
            if(num1[i]<1 || num1[i]>5) System.out.println("Please, enter number in the range of 1-5");
            num2[j]=sc.nextInt();
            if(num2[i]<1 || num2[i]>5) System.out.println("Please, enter number in the range of 1-5");

            if(rand1==num1[i] && rand2==num2[j])
            {
                a[num1[i]][num2[j]]='x';
                System.out.println("You have won!");
                flag=false;
                break;
            }
            else
            {
                a[num1[i]][num2[j]]='*';
                for (int m = 1; m <= 5; m++) {
                    for (int n = 1; n <= 5; n++) {
                        System.out.printf("%s ",a[m][n]);
                    }
                    System.out.println();
                }
            }
            i++; j++;
        }

        for (int m = 1; m <= 5; m++) {
            for (int n = 1; n <= 5; n++) {
                System.out.printf("%s ",a[m][n]);
            }
            System.out.println();
        }

    }


}
