import java.io.*;
import java.util.*;
/*
*N번째 큰 수
*우선순위 큐
*
* */

public class b2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        // 행렬 데이터 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 우선순위 큐를 사용하여 N번째 큰 수 찾기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pq.offer(matrix[i][j]);
            }
        }

        // N번째 큰 수까지 제거
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = pq.poll();
        }

        // 결과 출력
        System.out.println(answer);
    }
}
