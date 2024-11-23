package study;

import java.util.*;

public class study_19237 {

    static class Shark {
        int x, y, dir;
        int[][] priority;

        public Shark(int x, int y, int dir, int[][] priority) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.priority = priority;
        }
    }

    static class Smell {
        int sharkNum;
        int time;

        public Smell(int sharkNum, int time) {
            this.sharkNum = sharkNum;
            this.time = time;
        }
    }

    static int N, M, k;
    static Smell[][] smells;
    static Shark[] sharks;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int remainingSharks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        k = sc.nextInt();
        smells = new Smell[N][N];
        sharks = new Shark[M + 1];
        remainingSharks = M;

        // 상어 초기 위치
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > 0) {
                    int sharkNum = map[i][j];
                    sharks[sharkNum] = new Shark(i, j, 0, null);
                    smells[i][j] = new Smell(sharkNum, k);
                }
            }
        }

        // 상어 초기 방향
        for (int i = 1; i <= M; i++) {
            sharks[i].dir = sc.nextInt() - 1;
        }

        // 상어의 이동 우선순위
        for (int i = 1; i <= M; i++) {
            int[][] priority = new int[4][4];
            for (int j = 0; j < 4; j++) {
                for (int p = 0; p < 4; p++) {
                    priority[j][p] = sc.nextInt() - 1;
                }
            }
            sharks[i].priority = priority;
        }

        // 시뮬레이션 실행
        int time = 0;
        while (time <= 1000) {
            if (remainingSharks == 1) {
                System.out.println(time);
                return;
            }

            moveSharks();
            updateSmells();

            time++;
        }

        System.out.println(-1);
    }

    // 상어 이동
    static void moveSharks() {
        int[][] newPositions = new int[N][N];
        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            if (shark == null) continue; // 이미 제거된 상어는 건너뜀

            boolean moved = false;
            int nx = 0, ny = 0;

            // 1. 냄새가 없는 칸으로 이동
            for (int d : shark.priority[shark.dir]) {
                nx = shark.x + dx[d];
                ny = shark.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && (smells[nx][ny] == null || smells[nx][ny].time == 0)) {
                    shark.x = nx;
                    shark.y = ny;
                    shark.dir = d;
                    moved = true;
                    break;
                }
            }

            // 2. 이동하지 못했다면, 자신의 냄새가 있는 칸으로 이동
            if (!moved) {
                for (int d : shark.priority[shark.dir]) {
                    nx = shark.x + dx[d];
                    ny = shark.y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && smells[nx][ny] != null && smells[nx][ny].sharkNum == i) {
                        shark.x = nx;
                        shark.y = ny;
                        shark.dir = d;
                        break;
                    }
                }
            }

            // 새 위치 기록
            if (newPositions[shark.x][shark.y] == 0) {
                newPositions[shark.x][shark.y] = i;
            } else {
                // 충돌 -> 번호가 작은 상어만 살아남음
                int otherSharkNum = newPositions[shark.x][shark.y];
                if (i < otherSharkNum) {
                    sharks[otherSharkNum] = null;
                    newPositions[shark.x][shark.y] = i;
                } else {
                    sharks[i] = null;
                }
                remainingSharks--;
            }
        }
    }

    // 냄새 업데이트
    static void updateSmells() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smells[i][j] != null && smells[i][j].time > 0) {
                    smells[i][j].time--;
                    if (smells[i][j].time == 0) {
                        smells[i][j] = null;
                    }
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            if (shark == null) continue;

            smells[shark.x][shark.y] = new Smell(i, k);
        }
    }
}
