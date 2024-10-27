package softeer;

import java.io.*;
import java.util.*;

public class s_6250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] totalScore = new int[n];
        int[][] scores = new int[3][n];
        int[][] ranks = new int[4][n];  // 각 대회와 총합의 등수를 저장할 배열

        // 점수 입력 및 각 참가자 총합 계산
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
                totalScore[j] += scores[i][j];
            }
        }

        // 각 대회의 등수 계산
        for (int i = 0; i < 3; i++) {
            calculateRanks(scores[i], ranks[i]);
        }

        // 최종 등수 계산 (총합 점수 기준)
        calculateRanks(totalScore, ranks[3]);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ranks[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 주어진 점수 배열을 기준으로 등수를 계산하는 메서드
    private static void calculateRanks(int[] scores, int[] rank) {
        int n = scores.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) indices[i] = i;

        // 점수를 기준으로 내림차순 정렬
        Arrays.sort(indices, (a, b) -> Integer.compare(scores[b], scores[a]));

        // 등수 배정
        for (int i = 0; i < n; i++) {
            if (i > 0 && scores[indices[i]] == scores[indices[i - 1]]) {
                rank[indices[i]] = rank[indices[i - 1]];  // 같은 점수에 동일 등수 부여
            } else {
                rank[indices[i]] = i + 1;  // 등수는 1부터 시작
            }
        }
    }
}
