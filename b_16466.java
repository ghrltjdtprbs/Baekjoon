package day_8;

import java.io.*;
import java.util.*;

public class b_16466 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        int[] ticket = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ticket[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ticket);
        for (int i = 0; i < n; i++) {
            if(ticket[i] == answer){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
