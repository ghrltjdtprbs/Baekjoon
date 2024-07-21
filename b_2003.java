import java.util.*;

/*
 * 슬라이딩 윈도우로
 * start / end 설정
 * total이 넘기 전까지 end 증가
 * total과 같으면 answer++ / total이 넘으면 start 증가
 * start가 N-1  이면 종료
 * */
public class b_2003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = sc.nextInt();
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int start = 0;
        int end = 0;
        int currentSum = 0;

        while (end < N) {
            currentSum += arr[end];
            end++;

            while (currentSum >= total) {
                if (currentSum == total) {
                    answer++;
                }
                currentSum -= arr[start];
                start++;
            }
        }

        System.out.print(answer);

    }

}
