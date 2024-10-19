package day_10;

import java.util.*;
import java.io.*;
public class b_2805 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tree = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] treeLen = new int[tree];
        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        for(int i = 0; i < tree; i++){
            treeLen[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(treeLen[i], maxLen);
        }

        int goal = 0;
        int start = 0;
        int end = maxLen;
        while(start <= end){
            int mid = (start + end) / 2;
            long tmp = 0;
            for(int index : treeLen){
                if(index > mid){
                    tmp += (index - mid);
                }
            }
            if(tmp >= target){
                goal = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(goal);

    }

}
