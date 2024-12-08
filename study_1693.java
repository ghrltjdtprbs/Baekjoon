package study;

import java.util.*;
import java.io.*;

public class study_1693 {
    static List<Integer>[] tree;
    static int[][] dp; // [node][color] -> 특정 노드를 특정 색으로 칠했을 때 최소 비용
    static int n; // 노드 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 초기화
        // 트리 = 사이클 없고 계층화된 그래프
        tree = new ArrayList[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향
            tree[u].add(v);
            tree[v].add(u);
        }

        System.out.println(solve(1, 0, -1));
    }

/*
DFS + DP 방식으로 트리의 최소 색칠 비용을 계산
current  -> 현재 처리 중인 노드
color -> 현재 노드의 색 (1 ~ n)
parent -> 부모 노드 (현재 노드의 부모를 재귀 호출에서 제외해야함)
현재 노드를 특정 색으로 칠했을 때의 최소 비용 return
*/
    static int solve(int current, int color, int parent) {
        // 이미 계산된 결과가 있으면 그 값을 반환
        if (dp[current][color] != -1) {
            return dp[current][color];
        }

        // 현재 노드를 해당 색으로 칠하는 비용 추가
        dp[current][color] = color;

        // 현재 노드의 모든 자식 노드 탐색
        for (int child : tree[current]) {
            if (child == parent) {
                continue; // 부모 노드로 돌아가는 간선은 무시
            }

            int minCost = Integer.MAX_VALUE; // 자식 노드들을 칠하는 최소 비용을 계산

            // 자식 노드를 부모와 다른 색으로 칠해야 함
            for (int nextColor = 1; nextColor <= n; nextColor++) {
                if (nextColor == color) {
                    continue;
                }
                // 비용 계산
                minCost = Math.min(minCost, solve(child, nextColor, current));
            }

            // 현재 노드의 비용에 자식들의 최소 비용을 추가
            dp[current][color] += minCost;
        }

        // 현재 노드를 특정 색으로 칠했을 때의 최소 비용 반환
        return dp[current][color];
    }

}
