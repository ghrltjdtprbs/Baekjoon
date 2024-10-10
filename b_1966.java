package day_6;

import java.util.*;
import java.io.*;
public class b_1966 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int i = 0; i < test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int answer = 0;
            Queue<int[]> queue = new ArrayDeque<>();// [우선순위,인덱스]

            // 우선순위와 index 큐에 넣기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{priority,j});
            }

            // 우선순위만 우선순위큐로 정렬
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for(int[] doc : queue){
                priorityQueue.add(doc[0]);
            }
            int max = priorityQueue.remove(); // 우선순위 초기화

            // 출력 수행
            while(!queue.isEmpty()){
                int[] current = queue.remove();
                if(current[0] == max){
                    answer++;
                    // 궁금한 문서 index와 큐에서 뽑아낸 현재 요소의 index가 같으면 종료(정답)
                    if(current[1] == index) {
                        System.out.println(answer);
                        break;
                    }else{
                        max = priorityQueue.remove();
                    }
                }else{
                    queue.add(current);
                }
            }
        }
    }
}
