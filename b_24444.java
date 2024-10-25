package day_10;
import java.util.*;
import java.io.*;
public class b_24444 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int count = 1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new LinkedList[node + 1];
        visited = new boolean[node + 1];
        answer = new int[node + 1];

        for(int i = 1; i <= node; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(end_tmp);
            graph[end_tmp].add(start_tmp);
        }

        for(int i = 1; i <= node; i++){
            Collections.sort(graph[i]);
        }

        bfs(startNode);

        for(int i = 1; i <= node; i++){
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        answer[node] = count++;
        q.add(node);

        while(!q.isEmpty()){
            int current = q.poll();
            for(int index : graph[current]){
                if(!visited[index]){
                    visited[index] = true;
                    answer[index] = count++;
                    q.add(index);
                }
            }
        }
    }
}