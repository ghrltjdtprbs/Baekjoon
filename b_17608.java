package day_6;

import java.util.*;
import java.io.*;

public class b_17608 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stick = new int[N];
        int last_stick = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int current_stick = Integer.parseInt(br.readLine());
            stick[i] = current_stick;
        }
        for(int i = N - 1; i >= 0; i--){
            if(stick[i] > last_stick){
                last_stick = stick[i];
                answer++;
            }
        }
        System.out.println(answer);


    }

}
