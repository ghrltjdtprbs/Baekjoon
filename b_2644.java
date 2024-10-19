package day_10;
import java.util.*;
import java.io.*;
public class b_2644 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int target = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(br.readLine());

        graph = new LinkedList[node + 1];
        visited = new boolean[node + 1];
        answer = new int[node + 1];

        for(int i = 1; i <= node; i++){
            graph[i] = new LinkedList<>();
            answer[i] = -1;
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(end_tmp);
            graph[end_tmp].add(start_tmp);
        }

        dfs(startNode,0);

        System.out.println(answer[target]);
    }

    private static void dfs(int startNode, int depth){

        visited[startNode] = true;
        answer[startNode] = depth;
        if(startNode == target) return;

        for(int i : graph[startNode]){
            if(!visited[i]){
                dfs(i,depth + 1);
            }
        }
    }

}
