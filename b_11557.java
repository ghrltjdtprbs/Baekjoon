package day_8;
import java.util.*;
import java.io.*;
public class b_11557 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            int n = Integer.parseInt(br.readLine());
            String[] name = new String[n];
            int[] sul = new int[n];
            int max = 0;
            int maxIndex = 0;
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                name[j] = st.nextToken();
                sul[j] = Integer.parseInt(st.nextToken());
                if(max < sul[j]){
                    max = sul[j];
                    maxIndex = j;
                }
            }

            System.out.println(name[maxIndex]);

        }
    }
}
