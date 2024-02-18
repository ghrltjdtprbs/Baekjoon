import java.io.*;
import java.util.*;
/*
한 줄로 서기(배열, 그리디)
각 사람의 키를 1부터 N까지 순서대로
각 키에 대해, 해당 키의 사람이 자신보다 큰 사람들 사이에서 몇 번째 위치해야 하는지 주어진 정보를 사용
     -> 자신보다 큰 사람의 수 만큼 빈 공간 건너뛰고 그 위치에 배치
 */
public class b1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lineInfo = new int[N];
        int[] line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lineInfo[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int space = lineInfo[i - 1];
            for (int j = 0; j < N; j++) {
                if (space == 0 && line[j] == 0) {
                    line[j] = i;
                    break;
                } else if (line[j] == 0) {
                    space--;
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
