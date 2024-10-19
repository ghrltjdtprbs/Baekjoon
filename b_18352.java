package day_10;
import java.util.*;
import java.io.*;
public class b_18352 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int target_depth;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        target_depth = Integer.parseInt(st.nextToken());
        int start_node = Integer.parseInt(st.nextToken());

        graph = new LinkedList[node + 1];
        visited = new boolean[node + 1];

        for(int i = 1; i <= node; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(end_tmp);
        }
        bfs(0,start_node);

        Collections.sort(answer);
        if(answer.size() == 0){
            System.out.println(-1);
        }else{
            for(int i = 0; i < answer.size(); i++){
                System.out.println(answer.get(i));
            }
        }
    }

    private static void bfs(int depth,int start_node){
        Queue<int[]> q = new ArrayDeque<>();
        visited[start_node] = true;
        q.add(new int[]{start_node,0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int current_node = tmp[0];
            int count = tmp[1];
            if(count == target_depth){
                visited[current_node] = true;
                answer.add(current_node);
            }
            for(int index : graph[current_node]){
                if(!visited[index]){
                    visited[index] = true;
                    q.add(new int[]{index, count + 1});
                }
            }
        }

    }

}
