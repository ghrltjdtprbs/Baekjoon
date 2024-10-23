package softeer;

import java.io.*;
import java.util.*;

public class s_277730 {
    static int[][] trees;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 좌우 이동
    static int[] dy = {-1, 1, 0, 0}; // 상하 이동
    static int n = 0;
    static int maxValue = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        trees = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        backTracking(0, 0);
        System.out.println(maxValue);
    }

    private static void backTracking(int tmpValue, int depth) {
        if (depth == 4) {  // 최대 4쌍을 선택했을 때
            maxValue = Math.max(maxValue, tmpValue);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int current = trees[i][j];
                    visited[i][j] = true;

                    // 상하좌우 인접한 나무를 탐색
                    for (int k = 0; k < 4; k++) {
                        int x_tmp = j + dx[k];
                        int y_tmp = i + dy[k];

                        // 유효한 인덱스 범위 내에서 방문하지 않은 나무를 선택
                        if (x_tmp >= 0 && y_tmp >= 0 && x_tmp < n && y_tmp < n && !visited[y_tmp][x_tmp]) {
                            visited[y_tmp][x_tmp] = true;
                            backTracking(tmpValue + current + trees[y_tmp][x_tmp], depth + 1);
                            visited[y_tmp][x_tmp] = false;
                        }
                    }

                    // 현재 나무의 방문을 해제
                    visited[i][j] = false;
                }
            }
        }
        maxValue = Math.max(maxValue, tmpValue);
    }
}
