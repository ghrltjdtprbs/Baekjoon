package day_2;

import java.util.Scanner;

public class b_2438 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String stars ="*";
        for(int i = 1; i <= N; i++){
            System.out.println(stars);
            stars += "*";
        }
    }
}
