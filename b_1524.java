package day_8;
import java.util.*;
import java.io.*;

public class b_1524 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int sb = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> sjq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> sbq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < sj; j++){
                sjq.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < sb; j++){
                sbq.add(Integer.parseInt(st.nextToken()));
            }

            while(!sjq.isEmpty() && !sbq.isEmpty()){
                int sj_tmp = sjq.poll();
                int sb_tmp = sbq.poll();
                if(sb_tmp <= sj_tmp){
                    sjq.add(sj_tmp);
                }else{
                    sbq.add(sb_tmp);
                }

                if(sbq.isEmpty()){
                    System.out.println("S");
                }else if(sjq.isEmpty()){
                    System.out.println("B");
                }
            }
        }


    }
}
