package softeer;
import java.util.*;
import java.io.*;

public class b_6246 {
    static int[][] arr;
    static int[][] target;
    static boolean[][] visited;
    static int point = 0;
    static int n = 0;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        target = new int[point][2];
        for (int i = 0; i < point; i++) {
            st = new StringTokenizer(br.readLine());
            target[i][0] = Integer.parseInt(st.nextToken());
            target[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(target[0][0], target[0][1], 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int target_index) {
        // 목표 지점에 순서대로 도달한 경우
        if (target_index == point) {
            answer++;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && ny > 0 && nx <= n && ny <= n && !visited[nx][ny] && arr[nx][ny] == 0) {
                // 다음 방문 목표 위치에 도달한 경우
                if (nx == target[target_index][0] && ny == target[target_index][1]) {
                    dfs(nx, ny, target_index + 1);
                } else {
                    dfs(nx, ny, target_index);
                }
            }
        }

        visited[x][y] = false; // 백트래킹
    }
}
