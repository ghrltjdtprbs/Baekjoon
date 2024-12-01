package study;

import java.io.*;
import java.util.*;

public class study_20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 모기 출몰 구간 수

        Map<Integer, Integer> map = new HashMap<>();

        // 입력 처리: 시작 시간 +1, 종료 시간 -1
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int TE = Integer.parseInt(st.nextToken());
            int TX = Integer.parseInt(st.nextToken());

            map.put(TE, map.getOrDefault(TE, 0) + 1);
            map.put(TX, map.getOrDefault(TX, 0) - 1);
        }

        // 키(시간)를 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        int sum = 0;           // 현재
        int max = 0;           // 최대
        int startTime = 0;     // 최대 모기 시작된 시간
        int endTime = 0;       // 최대 모기 끝난 시간
        boolean inMaxInterval = false; // 현재 최대 수 구간에 있는지

        // 스위핑으로 최대값과 구간 찾기
        for (int time : keyList) {
            sum += map.get(time); // 시간 변화 반영

            if (sum > max) {
                // 새로운 최대값 발견
                max = sum;
                startTime = time;
                inMaxInterval = true;
            } else if (sum < max && inMaxInterval) {
                // 최대값 구간 종료
                endTime = time;
                inMaxInterval = false;
            }
        }

        System.out.println(max);
        System.out.println(startTime + " " + endTime);
    }
}
