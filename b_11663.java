package day_10;
import java.util.*;
import java.io.*;
public class b_11663 {
    static int[] spots;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int spot = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        spots = new int[spot];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < spot; i++){
            spots[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(spots);

        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int line_start = Integer.parseInt(st.nextToken());
            int line_end = Integer.parseInt(st.nextToken());

            int start_index = startIndex(line_start);
            int end_index = endIndex(line_end);

            if(start_index > end_index){
                System.out.println(0);
            }else{
                System.out.println(end_index - start_index + 1);
            }

        }
    }

    private static int startIndex(int line_start){
        int start = 0;
        int end = spots.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(spots[mid] < line_start){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }

    private static int endIndex(int line_end){
        int start = 0;
        int end = spots.length - 1;
        while(start <= end){
            int mid = (start + end) /2;
            if(spots[mid] <= line_end){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}
