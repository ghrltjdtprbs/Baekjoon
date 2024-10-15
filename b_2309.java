package day_8;
import java.util.*;
import java.io.*;
public class b_2309 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[9];
        int total = 0;

        for(int i = 0; i < 9; i++){
            int tmp = Integer.parseInt(br.readLine());
            answer[i] = tmp;
            total += tmp;
        }

        int target = total - 100;
        int x = 0,y = 0;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(answer[i] + answer[j] == target){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < 9; i++){
            if(i != x && i != y){
                pq.add(answer[i]);
            }
        }

        for(int i = 0; i < 7; i++){
            System.out.println(pq.remove());
        }

    }
}
