package softeer;
import java.util.*;
import java.io.*;
public class s_6291 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int[][] timetable = new int[test_case][2];
        for(int i = 0; i < test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timetable[i][0] = start;
            timetable[i][1] = end;
        }

        Arrays.sort(timetable,(a,b) -> a[1] != b[1]? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));

        int count = 0;
        int lastEndTime = 0;
        for(int i = 0; i < test_case; i++){
            if(timetable[i][1] >= lastEndTime){
                lastEndTime = timetable[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}
