package softeer;
import java.util.*;
import java.io.*;
public class s_277809 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken());
        int test_case = Integer.parseInt(st.nextToken());

        int[] score = new int[student + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= student; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < test_case; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int total = 0;
            for(int k = start; k <= end; k++){
                total += score[k];
            }
            double answer = total / (end - start + 1);

            System.out.println(Math.round(answer * 100)/100.0);
        }
    }

}
