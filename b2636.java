import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
[치즈]
   1. 판의 크기와 치즈의 배치를 입력 받는다
   2. 치즈가 모두 녹을 때까지 다음 과정을 반복
   3. BFS(너비 우선 탐색)를 사용하여 판의 가장자리부터 시작하여 공기가 닿는 치즈를 찾아 녹인다
   4. 한 번의 탐색으로 녹은 치즈의 수를 세어, 치즈가 녹기 한 시간 전의 치즈 조각 수를 기록
   5. 치즈가 모두 녹을 때까지 걸린 시간과, 녹기 한 시간 전의 치즈 조각 수를 출력
   */
public class b2636 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로 길이 입력
        M = sc.nextInt(); // 가로 길이 입력
        board = new int[N][M];
        int time = 0, lastCheese = 0;

        // 치즈의 배치를 입력받는 부분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 치즈가 모두 녹을 때까지 반복
        while (true) {
            visited = new boolean[N][M];
            int cheese = meltCheese();
            if (cheese == 0) break; // 치즈가 더 이상 없으면 반복 중단
            lastCheese = cheese; // 마지막으로 녹은 치즈의 수 기록
            time++; // 시간 증가
        }

        System.out.println(time); // 총 걸린 시간 출력
        System.out.println(lastCheese); // 녹기 한 시간 전의 치즈 조각 수 출력
        sc.close();
    }

    // 치즈를 녹이는 메소드
    static int meltCheese() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 시작점 (0, 0)에서 탐색 시작
        visited[0][0] = true;
        int count = 0; // 녹은 치즈의 수

        // BFS를 사용하여 치즈 녹이기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우로 이동하며 치즈 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 범위 확인 및 방문 여부 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    if (board[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                    } else {
                        board[nx][ny] = 0; // 치즈 녹이기
                        count++; // 녹은 치즈 수 증가
                    }
                    visited[nx][ny] = true; // 방문한 위치 표시
                }
            }
        }
        return count; // 녹은 치즈의 수 반환
    }

}
