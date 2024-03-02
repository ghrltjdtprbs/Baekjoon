import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
[문자열교환]
1.문자열에서 a 총 개수를 계산
2.만약 문자열에 a가 없거나 전체가 a로만 이루어진 경우 교환 x 0을 출력 -> 종료
3.else 초기 윈도우 b 개수를 세고, 후에 슬라이딩 윈도우를 이용하여 각 위치에서 b의 최소 개수를 찾음
4.윈도우는 원형 인덱스 계산 -> 모듈러 연산을 사용
 */
public class b1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        // 'a'의 총 개수를 계산
        int totalA = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                totalA++;
            }
        }

        // 모든 문자가 'a'인 경우
        if (totalA == len) {
            System.out.println(0);
            return;
        }

        int bCount = 0, minB = Integer.MAX_VALUE;

        // 초기 윈도우 설정
        for (int i = 0; i < totalA; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }
        minB = bCount;

        // 슬라이딩 윈도우로 최소 교환 횟수 찾기
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == 'b') {
                bCount--;
            }
            if (s.charAt((i + totalA - 1) % len) == 'b') {
                bCount++;
            }
            minB = Math.min(minB, bCount);
        }

        System.out.println(minB);
    }
}
