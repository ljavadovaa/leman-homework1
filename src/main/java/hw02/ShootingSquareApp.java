package hw02;

import java.util.Scanner;

public class ShootingSquareApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("All set. Get ready to rumble!");
        String[][] a = new String[20][20];
        int[] number1 = new int[20];
        int[] number2 = new int[20];
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
            int i=0;
            number1[i]=sc.nextInt();
            number2[i]=sc.nextInt();
            if(!(number1[i]>=1 && number1[i]<=5) || !(number2[i]>=1 && number2[i]<=5))
                System.out.println("Please, enter number in the range of 1-5");

            if(random1==number1[i] && random2==number2[i])
            {
                a[number1[i]][number2[i]]="x";
                System.out.println("You have won!");
                break;
            }
            else
            {
                if (number1[i]==0 || number2[i]==0) continue;
                a[number1[i]][number2[i]]="*";
                for (int m = 0; m <= 5; m++) {
                    for (int n = 0; n <= 5; n++) {
                        System.out.printf("%s ",a[m][n]);
                    }
                    System.out.println();
                }
            }
            i++;
        }

        for (int m = 0; m <= 5; m++) {
            for (int n = 0; n <= 5; n++) {
                System.out.printf("%s ",a[m][n]);
            }
            System.out.println();
        }

    }


}
