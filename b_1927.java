package day_7;
import java.util.*;
import java.io.*;
public class b_1927 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                pq.add(tmp);
            }
        }
    }
}
