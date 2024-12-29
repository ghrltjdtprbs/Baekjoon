package study;

import java.util.Scanner;

public class study_1437 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 0 || N == 1) {
            System.out.println(N);
            return;
        }

        long result = 1;
        final int MOD = 10007;

        // 4이하부터는 별도로 처리하는 것이 유리(2*2 > 3*1)
        // 4 이상은 최대한 3으로 나누기
        while (N > 4) {
            result = (result * 3) % MOD;
            N -= 3;
        }

        result = (result * N) % MOD;

        System.out.println(result);
    }
}
