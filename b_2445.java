package day_2;

import java.util.Scanner;

public class b_2445 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String stars = "*";
        String enter ="";
        for(int i = 1; i < N; i++){
            enter += "  ";
        }
        for(int i = 1; i <= N; i++){
            System.out.println(stars + enter + stars);
            if(stars.length() < N)stars += "*";
            if(enter.length() != 0)enter = enter.substring(0,enter.length() - 2);
        }
        for(int i = 1; i < N; i++){
            enter += "  ";
            if(stars.length() != 1)stars = stars.substring(0,stars.length() - 1);
            System.out.println(stars + enter + stars);

        }
    }
}
