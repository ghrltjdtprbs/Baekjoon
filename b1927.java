/*
1.PriorityQueue를 사용하여 최소 힙을 구현.
2.입력받은 N에 따라 N번의 연산
3.각 연산에서 정수 x를 입력
4.만약 x가 0이면, 힙이 비어있지 않은 경우 가장 작은 값을 출력하고 제거. 비어있으면 0을 출력
5.x가 0이 아닌 자연수인 경우, 힙에 x를 추가
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수 N을 입력받음
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙 구현을 위한 우선순위 큐

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine()); // 정수 x를 입력받음

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0); // 힙이 비어있으면 0 출력
                } else {
                    System.out.println(minHeap.poll()); // 힙에서 가장 작은 값을 출력하고 제거
                }
            } else {
                minHeap.add(x); // 힙에 x 추가
            }
        }
    }
}
