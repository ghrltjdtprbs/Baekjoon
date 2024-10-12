package day_7;
import java.io.*;
import java.util.*;
public class b_14235 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0){
                if(pq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                for(int j = 0; j < tmp; j++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

    }
}
