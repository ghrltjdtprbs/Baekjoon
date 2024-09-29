package day_4;

import java.util.Scanner;

public class b_1152 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        if(s.isEmpty()){
            System.out.println(0);
        }else{
            String[] answer = s.split(" ");
            System.out.println(answer.length);
        }

    }
}
