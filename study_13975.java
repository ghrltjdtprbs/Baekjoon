package study;

import java.io.*;
import java.util.PriorityQueue;

/*
우선순위큐에(최소힙) 파일 크기 모두 삽입 -> 가장 작은 것 부터 합침 ->
- 항상 가장 작은 두 파일 합친다 -> 그리디
*/
public class study_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(input[i]));
            }
            long totalCost = 0;

            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                long cost = first + second;
                totalCost += cost;

                pq.add(cost);
            }

            sb.append(totalCost).append("\n");
        }

        System.out.print(sb);
    }
}
