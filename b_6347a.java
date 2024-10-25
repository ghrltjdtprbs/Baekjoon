package softeer;

import java.io.*;
import java.util.*;
// 문자열을 순회하며 P(로봇)이 나올 경우 앞뒤로 K(거리)만큼 조회해 잡을 수 있으면 answer++;
// visited 배열 이용해서 이미 잡은 물건인지 조회(P부분은 true처리 해야함)
public class b_6347a {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String rail = br.readLine();

        boolean[] visited = new boolean[len];
        int answer = 0;

        //초기화

        for(int i = 0; i < len; i++){
            char current = rail.charAt(i);
            if(current == 'P'){
                boolean flag = false;
                for(int j = 1; j <= K; j++){
                    if(i - j >= 0 && !visited[i - j] && rail.charAt(i-j) == 'H'){
                        answer++;
                        visited[i - j] = true;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    for(int j = 1; j <= K; j++) {
                        if (i + j < len && !visited[i + j] && rail.charAt(i + j) == 'H') {
                            answer++;
                            visited[i + j] = true;
                            break;
                        }
                    }
                }

            }
        }


        System.out.println(answer);
    }
}