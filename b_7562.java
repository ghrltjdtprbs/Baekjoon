package day_10;

import java.util.*;
import java.io.*;

public class b_7562 {

    static int[] dx = new int[]{-2, -1, -2, -1, 1, 2, 2, 1};
    static int[] dy = new int[]{-1, -2, 1, 2, -2, -1, 1, 2};
    static int len = 0;
    static int end_x = 0;
    static int end_y = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_y = Integer.parseInt(st.nextToken());
            int start_x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end_y = Integer.parseInt(st.nextToken());
            end_x = Integer.parseInt(st.nextToken());
            int answer = bfs(start_x, start_y);
            System.out.println(answer);
        }

    }

    private static int bfs(int start_x, int start_y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[len][len];
        visited[start_y][start_x] = true;
        q.add(new int[]{start_x, start_y, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int current_x = current[0];
            int current_y = current[1];
            int count = current[2];

            if (current_x == end_x && current_y == end_y) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int tmp_x = current_x + dx[i];
                int tmp_y = current_y + dy[i];
                if (tmp_x >= 0 && tmp_y >= 0 && tmp_x < len && tmp_y < len
                    && !visited[tmp_y][tmp_x]) {
                    visited[tmp_y][tmp_x] = true;
                    q.add(new int[]{tmp_x, tmp_y, count + 1});
                }
            }
        }
        return -1;
    }

}
