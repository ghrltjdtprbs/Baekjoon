package study;
import java.io.*;
import java.util.*;
public class study_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] incDp = new int[N]; // 증가하는 부분 수열의 길이
        int[] decDp = new int[N]; // 감소하는 부분 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가하는 부분 수열의 길이 계산
        for (int i = 0; i < N; i++) {
            incDp[i] = 1; // 자기 자신은 항상 수열의 시작이 될 수 있음
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    incDp[i] = Math.max(incDp[i], incDp[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열의 길이 계산 (반대로 탐색)
        for (int i = N - 1; i >= 0; i--) {
            decDp[i] = 1; // 자기 자신은 항상 수열의 시작이 될 수 있음
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    decDp[i] = Math.max(decDp[i], decDp[j] + 1);
                }
            }
        }

        // 가장 긴 바이토닉 부분 수열의 길이 계산
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, incDp[i] + decDp[i] - 1);
        }

        System.out.println(maxLen);
    }
}
