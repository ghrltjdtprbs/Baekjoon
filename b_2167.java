import java.util.Scanner;

public class b_2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][M + 1];
        int[][] sumArr = new int[N + 1][M + 1];

        // 배열 입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 2차원 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sumArr[i][j] = arr[i][j] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
            }
        }

        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            System.out.println(result);
        }

        sc.close();
    }
}
