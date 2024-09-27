package day_2;

import java.util.Scanner;

public class b_2167 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int test_case = sc.nextInt();
        int[][] answer = new int[test_case][4];
        for (int i = 0; i < test_case; i++) {
            for (int j = 0; j < 4; j++) {
                answer[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < test_case; i++) {
            int tmp = 0;
            int x1 = answer[i][0] - 1;
            int y1 = answer[i][1] - 1;
            int x2 = answer[i][2] - 1;
            int y2 = answer[i][3] - 1;

            if (y1 == y2) {
                if (x1 == x2) {
                    tmp = arr[x1][y1];
                } else {
                    for (int j = x1; j <= x2; j++) {
                        tmp += arr[j][y1];
                    }
                }
            } else {
                for (int j = y1; j <= y2; j++) {
                    for (int k = x1; k <= x2; k++) {
                        tmp += arr[k][j];
                    }
                }
            }
            System.out.println(tmp);
        }

    }
}
