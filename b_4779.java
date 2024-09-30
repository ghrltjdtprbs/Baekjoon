package day_3;

import java.util.Scanner;

public class b_4779 {
    static char[] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int length = (int)Math.pow(3,N);
            arr = new char[length];
            for(int i = 0; i < length; i++){
                arr[i] = '-';
            }
            cantore(0,length);

            System.out.println(new String(arr));
        }

    }

    private static void cantore(int start,int len){
        if(len == 1) return;
        int newLen = len/3;
        for(int i = start+newLen;i<start+2*newLen;i++){
            arr[i] = ' ';
        }
        cantore(start,newLen);
        cantore(start+newLen*2,newLen);
    }
}
