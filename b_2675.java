package day_4;

import java.util.Scanner;

public class b_2675 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int count = sc.nextInt();
            String current = sc.next();
            String answer = "";

            for(int j = 0; j < current.length(); j++){
                for(int k = 0; k < count; k++){
                    answer += current.charAt(j);
                }
            }

            System.out.println(answer);

        }
    }
}
