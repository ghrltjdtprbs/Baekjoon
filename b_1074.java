package day_3;

import java.util.Scanner;

public class b_1074 {
    static int[][] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int len = 1;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            len *= 2;
        }
        arr = new int[len][len];


    }
    private static void Z(int r,int c,int len){
        int newSize = len/2;
        //1사분면
        if(r < newSize && c < newSize){}
    }

}
