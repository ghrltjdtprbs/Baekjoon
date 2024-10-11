package day_7;
/*
- 1번 투표수를 dasom으로 저장
- 나머지를 우선순위 큐에 넣고, 우선순위 큐의 앞이 다솜보다 적을때까지 -1 , 다솜++ 반복
 */

import java.util.*;
import java.io.*;

public class b_1417 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = 0;
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(i == 0){
                dasom = Integer.parseInt(br.readLine());
            }else{
                pq.add(Integer.parseInt(br.readLine()));
            }
        }

        while(!pq.isEmpty()){
            int tmp = pq.remove();
            if(dasom > tmp){
                break;
            }else{
                tmp--;
                answer++;
                dasom++;
                if(tmp > 0){
                    pq.add(tmp);
                }

            }
        }

        System.out.print(answer);

    }
}
