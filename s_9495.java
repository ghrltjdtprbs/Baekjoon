package softeer;

import java.util.*;
import java.io.*;

public class s_9495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] popular = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            popular[i][0] = Integer.parseInt(st.nextToken());  // Pi: 유명인의 인기도
            popular[i][1] = Integer.parseInt(st.nextToken());  // Ci: 친화력
        }

        int myPopularity = 0;  // 철민이의 초기 인기도

        for (int i = 0; i < n; i++) {
            int Pi = popular[i][0];
            int Ci = popular[i][1];

            if (Math.abs(Pi - myPopularity) <= Ci) {
                myPopularity++;
            }
        }

        System.out.println(myPopularity);
    }
}
