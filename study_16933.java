package study;

import java.io.*;
import java.util.*;

public class study_16933 {
    static class Node {
        int x, y, dist, breakWall, isDay;

        public Node(int x, int y, int dist, int breakWall, int isDay) {
            this.x = x;
            this.y = y;
            this.dist = dist; // 이동거리
            this.breakWall = breakWall; // 부순 벽 수
            this.isDay = isDay; // 낮 -> 1 밤 -> 0
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][][][] visited = new boolean[n][m][k + 1][2]; // 낮/밤 상태도 방문 배열에 포함

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0, 1)); // 시작점
        visited[0][0][0][1] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                System.out.println(current.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 빈 칸 이동
                if (map[nx][ny] == '0' && !visited[nx][ny][current.breakWall][1 - current.isDay]) {
                    visited[nx][ny][current.breakWall][1 - current.isDay] = true;
                    queue.add(new Node(nx, ny, current.dist + 1, current.breakWall, 1 - current.isDay));
                }

                // 벽 부수기
                if (map[nx][ny] == '1' && current.breakWall < k && current.isDay == 1 &&
                    !visited[nx][ny][current.breakWall + 1][1 - current.isDay]) {
                    visited[nx][ny][current.breakWall + 1][1 - current.isDay] = true;
                    queue.add(new Node(nx, ny, current.dist + 1, current.breakWall + 1, 1 - current.isDay));
                }
            }

            // 제자리 대기 (밤 -> 낮으로)
            if (!visited[current.x][current.y][current.breakWall][1 - current.isDay]) {
                visited[current.x][current.y][current.breakWall][1 - current.isDay] = true;
                queue.add(new Node(current.x, current.y, current.dist + 1, current.breakWall, 1 - current.isDay));
            }
        }

        System.out.println(-1); // 도달할 수 없는 경우
    }
}
