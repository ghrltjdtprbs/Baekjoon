package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_16197 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {

        int x1, y1, x2, y2, moves;

        public State(int x1, int y1, int x2, int y2, int moves) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        visited = new boolean[N][M][N][M]; // 두 동전의 위치를 동시에 기록

        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') {
                    coinCount++;
                    if (coinCount == 1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        int result = bfs(x1, y1, x2, y2);
        System.out.println(result);
    }

    public static int bfs(int x1, int y1, int x2, int y2) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(x1, y1, x2, y2, 0));
        visited[x1][y1][x2][y2] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 이동 횟수 10 넘으면 실패
            if (current.moves > 10) {
                return -1;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx1 = current.x1 + dx[dir];
                int ny1 = current.y1 + dy[dir];
                int nx2 = current.x2 + dx[dir];
                int ny2 = current.y2 + dy[dir];

                // 동전 보드 밖으로 나가는지 확인
                boolean coin1Out = !isInBoard(nx1, ny1);
                boolean coin2Out = !isInBoard(nx2, ny2);

                // 한 동전만 떨어진 경우
                if (coin1Out && !coin2Out) {
                    return current.moves + 1;
                }
                if (!coin1Out && coin2Out) {
                    return current.moves + 1;
                }

                // 두 동전 모두 떨어짐
                if (coin1Out && coin2Out) {
                    continue;
                }

                // 벽 만나면 원래 위치로 복귀
                if (!coin1Out && board[nx1][ny1] == '#') {
                    nx1 = current.x1;
                    ny1 = current.y1;
                }
                if (!coin2Out && board[nx2][ny2] == '#') {
                    nx2 = current.x2;
                    ny2 = current.y2;
                }

                // 이미 방문한 상태
                if (visited[nx1][ny1][nx2][ny2]) {
                    continue;
                }

                visited[nx1][ny1][nx2][ny2] = true;
                queue.add(new State(nx1, ny1, nx2, ny2, current.moves + 1));
            }
        }

        return -1;
    }

    public static boolean isInBoard(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}


