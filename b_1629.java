import java.util.Scanner;
//곱셈
public class b_1629 {
    public static long modPow(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        // 분할정복
        long half = modPow(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 != 0) {
            result = (result * a) % c;
        }
        return result;
    }
//A를 B번 곱한 수를 C로 나눈 나머지
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(modPow(A, B, C));
    }
}
