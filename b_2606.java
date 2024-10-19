package day_10;

import java.util.*;
import java.io.*;

public class b_2606 {

    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        graph = new LinkedList[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(end_tmp);
            graph[end_tmp].add(start_tmp);
        }

        dfs(1);
        System.out.println(count);

    }

    private static void dfs(int node) {
        if(!visited[node]){
            visited[node] = true;
            for (int index : graph[node]) {
                if(!visited[index]){
                    count++;
                    dfs(index);
                }
            }
        }else{
            return;
        }


    }

}
