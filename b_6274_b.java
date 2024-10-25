package softeer;

import java.io.*;
import java.util.*;

public class b_6274_b {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String rail = br.readLine();

        boolean[] visited = new boolean[len];
        int answer = 0;

        for (int i = 0; i < len; i++) {
            // 현재 위치가 로봇(P)일 때
            if (rail.charAt(i) == 'P') {
                // 로봇이 왼쪽부터 오른쪽으로 거리를 K까지 탐색하여 부품을 찾음
                boolean foundPart = false;

                // 왼쪽에서 찾기
                for (int j = Math.max(i - K, 0); j < i && !foundPart; j++) {
                    if (rail.charAt(j) == 'H' && !visited[j]) {
                        visited[j] = true;
                        answer++;
                        foundPart = true;
                    }
                }

                // 오른쪽에서 찾기
                if (!foundPart) {
                    for (int j = i + 1; j <= Math.min(i + K, len - 1); j++) {
                        if (rail.charAt(j) == 'H' && !visited[j]) {
                            visited[j] = true;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
