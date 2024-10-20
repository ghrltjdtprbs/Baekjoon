package day_10;
import java.util.*;
import java.io.*;

class Edge {
    int dest;
    int weight;
    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class b_1240 {
    static List<Edge>[] graph;
    static boolean[] visited;
    static int end_node = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int test_case = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new LinkedList[node + 1];
        for (int i = 1; i <= node; i++) {
            graph[i] = new LinkedList<>();
        }

        // 간선 정보 입력
        for (int i = 1; i < node; i++) {
            st = new StringTokenizer(br.readLine());
            int start_tmp = Integer.parseInt(st.nextToken());
            int end_tmp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start_tmp].add(new Edge(end_tmp, weight));
            graph[end_tmp].add(new Edge(start_tmp, weight));
        }

        // 테스트 케이스 처리
        for (int i = 0; i < test_case; i++) {
            visited = new boolean[node + 1];  // 방문 배열 초기화
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            end_node = Integer.parseInt(st.nextToken());

            int answer = dfs(start_node, 0);
            System.out.println(answer);
        }
    }

    // DFS 탐색
    private static int dfs(int start_node, int weight) {
        if (start_node == end_node) {  // 목표 노드에 도달하면 현재까지의 가중치 반환
            return weight;
        }

        visited[start_node] = true;  // 현재 노드 방문 처리

        // 인접한 노드들 탐색
        for (Edge edge : graph[start_node]) {
            if (!visited[edge.dest]) {  // 아직 방문하지 않은 노드로만 탐색
                int result = dfs(edge.dest, weight + edge.weight);  // 재귀 호출로 누적 가중치 계산
                if (result != -1) {  // 유효한 경로가 있으면 결과 반환
                    return result;
                }
            }
        }

        visited[start_node] = false;  // 탐색 후 방문 해제
        return -1;  // 유효한 경로가 없으면 -1 반환
    }
}
