package study;
import java.io.*;
import java.util.*;
public class study_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 작업 시간을 저장하는 배열
        int[] times = new int[n + 1];
        // 각 작업의 선행 작업 수를 저장하는 배열 (진입 차수)
        int[] inDegree = new int[n + 1];
        // 각 작업의 선행 작업들을 저장하는 리스트 배열
        List<Integer>[] adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 작업별 최소 완료 시간을 저장하는 배열
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken()); // 해당 작업의 소요 시간
            result[i] = times[i]; // 초기화: 각 작업의 완료 시간은 최소 자기 자신의 시간으로 설정
            int numPreTasks = Integer.parseInt(st.nextToken()); // 선행 작업의 개수

            // 선행 작업이 있을 경우 인접 리스트와 진입 차수를 설정
            for (int j = 0; j < numPreTasks; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                adjList[preTask].add(i);
                inDegree[i]++;
            }
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 위상 정렬 실행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adjList[current]) {
                inDegree[next]--;
                // 다음 작업의 최소 완료 시간을 갱신
                result[next] = Math.max(result[next], result[current] + times[next]);
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 결과: 작업 중 가장 오래 걸리는 시간을 출력
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, result[i]);
        }
        System.out.println(maxTime);
    }
}
