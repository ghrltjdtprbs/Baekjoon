import java.util.Scanner;

public class b_9663 {
    private static int N; // 체스판 크기, 퀸
    private static int[] cols; // 퀸 놓인 열 위치 저장
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cols = new int[N];
        solve(0);
        System.out.println(result);
    }

    private static void solve(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                cols[row] = col;
                solve(row + 1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col || Math.abs(cols[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
