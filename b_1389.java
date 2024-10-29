package hh99;
import java.util.*;
import java.io.*;
public class b_1389 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[][] graph = new int[node][node];

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
        }

        for(int k = 0; k < node; k++){
            for(int i = 0; i < node; i ++){
                for(int j = 0; j < node; j++){
                    if(graph[i][k] )
                }
            }
        }
    }

}
