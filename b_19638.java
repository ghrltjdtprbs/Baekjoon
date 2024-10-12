package day_7;
import java.util.*;
import java.io.*;
public class b_19638 {
    public static void main(String arggs[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        boolean win = false;
        while(count >= 0){
            int tmp = pq.poll();
            if(tmp < goal){
                System.out.println("YES");
                System.out.println(answer);
                win = true;
                break;
            }else{
                answer++;
                if(tmp > 1 && count != 0) tmp = tmp/2;
                pq.add(tmp);
                count--;
            }
        }
         if(!win){
             System.out.println("NO");
             System.out.println(pq.poll());
         }

    }

}
