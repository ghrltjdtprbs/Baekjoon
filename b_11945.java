package day_2;

import java.util.Scanner;

public class b_11945 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        for(int i = 0; i <= h; i++){
            String line = sc.nextLine();
            StringBuffer sb = new StringBuffer(line);
            System.out.println(sb.reverse());
        }

        sc.close();

    }
}
