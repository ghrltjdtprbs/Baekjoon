package day_2;

import java.util.Scanner;

public class b_2003 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int goal = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int tmp = arr[start];

        while(start <= N){
            if(tmp >= goal){
                if(tmp == goal) answer++;
                if(start < N - 1){
                    tmp -= arr[start];
                    start++;
                }else{
                    break;
                }
            }else{
                if(end < N - 1){
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
