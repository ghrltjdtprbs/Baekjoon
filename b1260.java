import java.io.*;
import java.util.*;
//DFS와 BFS
//Queue
public class b1260 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 그래프의 인접 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);

        // BFS 수행
        visited = new boolean[N + 1];
        bfs(V);

        // 결과 출력
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    // DFS 구현
    static void dfs(int v) {
        visited[v] = true;
        dfsResult.append(v).append(" ");
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    // BFS 구현
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsResult.append(current).append(" ");

            for (int i : graph[current]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
