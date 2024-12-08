package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study_1520 {

    static int[][] map, dp;
    static int m, n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        // 도착점에 도달한 경우
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        // 이미 방문한 적이 있다면 저장된 값 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 경로 수 초기화

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효한 범위 내에서 내리막 길인 경우
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny); // 다음 경로 탐색
            }
        }

        return dp[x][y];
    }
}
