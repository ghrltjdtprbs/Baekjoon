package study;
import java.io.*;
import java.util.*;
public class study_2665 {
    static int N;
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maze = new int[N][N];
        dist = new int[N][N];

        // 미로 입력 및 거리 배열 초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                maze[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // 최소 벽 부수기 탐색
        bfs();

        // 최종 출력: 목적지까지의 최소 벽 부수기 횟수
        System.out.println(dist[N - 1][N - 1]);
    }

    static void bfs() {
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newDist = dist[x][y] + (maze[nx][ny] == 0 ? 1 : 0);
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        if (maze[nx][ny] == 0) {
                            deque.addLast(new int[]{nx, ny}); // 벽을 부수고 이동
                        } else {
                            deque.addLast(new int[]{nx, ny}); // 벽이 아닌 경우 우선순위 높음
                        }
                    }
                }
            }
        }
    }
}
