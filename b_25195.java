package day_10;
/*
- 그래프 dfs 탐색
- 방문 노드에 팬클럽이 있으면 return;
- 만약 노드에 연결된 추가 노드가 없고(끝노드) 파라미터로 받은 flag가 false이면 안만나기 성공
- isMeet 플래그를 이용해서 isMeet이 true가 되는 순간 탐색종료
 */

import java.util.*;
import java.io.*;

public class b_25195 {

    static LinkedList<Integer>[] graph;
    static int[] pans;
    static boolean[] ispan;
    static boolean[] visited;
    static boolean isWin = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        graph = new LinkedList[node + 1];
        ispan = new boolean[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());
            graph[start_tmp].add(end_tmp);
        }

        int pan = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pan; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            ispan[tmp] = true;
        }

        dfs(1);
        if (!isWin) {
            System.out.println("Yes");
        }


    }

    private static void dfs(int node) {
        if(ispan[node]) return;
        if(graph[node].size() == 0){
            isWin = true;
            System.out.println("yes");
            return;
        }
        visited[node] = true;
        for(int index : graph[node]){
            if(!visited[index]){
                if(isWin) return;
                dfs(index);

            }
        }
    }
}
