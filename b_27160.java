package day_4;

import java.util.Scanner;

public class b_27160 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //STRAWBERRY = 0, BANANA = 1, LIME = 2, PLUM = 3
        int[] S = new int[4];

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String current = sc.next();
            int count = sc.nextInt();

            if(current.equals("STRAWBERRY")){
                S[0] += count;
            }else if(current.equals("BANANA")){
                S[1] += count;
            }else if(current.equals("LIME")){
                S[2] += count;
            }else{
                S[3] += count;
            }
        }

        for(int i = 0; i < S.length; i++){
            if(S[i] == 5){
                System.out.println("YES");
                break;
            }else{
                if(i == S.length - 1) System.out.println("NO");
            }
        }
    }
}
