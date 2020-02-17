package hw02;

import java.util.Scanner;

public class ShootingSquareApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("All set. Get ready to rumble!");
        String[][] a = new String[6][6];
        final int MAX=5;
        int random1 = (int) (Math.random()*MAX+1);
        int random2 = (int) (Math.random()*MAX+1);
        //System.out.printf("%d %d\n",random1,random2);

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                a[i][j]="-";
            }
        }

        for (int i = 0; i < 6; i++) {
            a[0][i]= String.valueOf(i);
        }
        for (int j = 0; j < 6; j++) {
            a[j][0]= String.valueOf(j);
        }

        while (true)
        {
            int number1=sc.nextInt();
            int number2=sc.nextInt();
            if(!(number1>=1 && number1<=5) || !(number2>=1 && number2<=5))
                System.out.println("Please, enter number in the range of 1-5");

            if(random1==number1 && random2==number2)
            {
                a[number1][number2]="x";
                System.out.println("You have won!");
                break;
            }
            else
            {
                if (number1==0 || number2==0) continue;
                a[number1][number2]="*";
                for (int m = 0; m <= 5; m++) {
                    for (int n = 0; n <= 5; n++) {
                        System.out.printf("%s ",a[m][n]);
                    }
                    System.out.println();
                }
            }
        }

        for (int m = 0; m <= 5; m++) {
            for (int n = 0; n <= 5; n++) {
                System.out.printf("%s ",a[m][n]);
            }
            System.out.println();
        }

    }


}
