//정수 삼각형
import java.io.*;
import java.util.*;

public class b_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        // 삼각형 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대 합 계산
        dp[0][0] = triangle[0][0]; // 시작점 초기화
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]; // 왼쪽
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // 오른쪽
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // 최대값 찾기
        int maxSum = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i] > maxSum) {
                maxSum = dp[n - 1][i];
            }
        }

        System.out.println(maxSum);
    }
}

/*
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

7 -> 초기화
10 15
18 16 15
20 25 20 19
24 30 27 26 24 -> 여기서 최대값 찾음
*/