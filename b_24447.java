package day_10;
import java.util.*;
import java.io.*;
public class b_24447 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer_depth;
    static int[] answer_count;
    static int count = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new LinkedList[node + 1];
        visited = new boolean[node + 1];
        answer_depth = new int[node + 1];
        answer_count = new int[node + 1];

        for(int i = 1; i <= node; i++){
            graph[i] = new LinkedList<>();
            answer_depth[i] = -1;
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(end_tmp);
            graph[end_tmp].add(start_tmp);
        }

        bfs(startNode);

        long answer = 0;
        for(int i = 1; i <= node; i++){
            answer += (long)answer_count[i] * answer_depth[i];
        }

        System.out.println(answer);
    }

    private static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        answer_depth[node] = 0;
        answer_count[node] = count++;
        q.add(node);

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int index : graph[tmp]){
                if(!visited[index]){
                    visited[index] = true;
                    answer_depth[index] = answer_depth[tmp] + 1;
                    answer_count[index] = count++;
                    q.add(index);
                }
            }
        }
    }
}
