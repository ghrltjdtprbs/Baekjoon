package day_10;
import java.util.*;
import java.io.*;
public class b_10815 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] base = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            base[i] = tmp;
        }
        Arrays.sort(base);

        int m = Integer.parseInt(br.readLine());
        int[] ex = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int tmp = Integer.parseInt(st.nextToken());
            ex[i] = tmp;
        }

        int[] answer = new int[m];
        for(int i = 0; i < m; i++){
            int current = ex[i];
            int start = 0;
            int end = base.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(current == base[mid]){
                    answer[i] = 1;
                    break;
                }
                if(base[mid] < current){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            System.out.print(answer[i] + " ");
        }


    }

}
