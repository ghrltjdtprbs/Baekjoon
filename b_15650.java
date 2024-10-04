package day_5;

import java.util.*;
import java.io.*;

public class b_15650 {

    static int N;
    static int M;
    static int[] answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        backTracking(0, 1);
    }

    private static void backTracking(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {

            answer[depth] = i;
            backTracking(depth + 1, i + 1);

        }
    }
}
