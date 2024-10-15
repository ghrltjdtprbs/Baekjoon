package day_8;
import java.util.*;
import java.io.*;
public class b_1026 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> aq = new PriorityQueue<>();
        PriorityQueue<Integer> bq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aq.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            bq.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            int a = aq.poll();
            int b = bq.poll();
            answer += (a*b);
        }

        System.out.println(answer);
    }
}
