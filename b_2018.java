package day_2;

import java.util.Scanner;

public class b_2018 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int tmp = 1;

        while(start < arr.length){
            if(tmp >= N){
                if(tmp == N) answer++;
                if(start < arr.length - 1){
                    tmp -= arr[start];
                    start++;
                }else{
                    break;
                }
            }else{
                if(end < arr.length - 1){
                    end++;
                    tmp += arr[end];
                }else{
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}
