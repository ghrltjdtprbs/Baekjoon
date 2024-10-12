package day_7;

import java.util.*;
import java.io.*;

/*
- map으로 노래제목, 앞자리 음 세 개만 저장
- 앞자리 음 세 개 넣기 전에 이미 저장이 되어 있으면 노래 제목을 ?로 저장
 */
public class b_31562 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> map = new HashMap<>(); // 음계, 노래이름

        int ex = Integer.parseInt(st.nextToken());
        int games = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ex; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int len = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            for (int j = 0; j < 3; j++) {

                sb.append(st.nextToken()).append(" ");

            }
            String song = sb.toString().trim();

            if (map.containsKey(song)) {
                map.put(song, "?");
            } else {
                map.put(song, name);
            }
        }

        for (int i = 0; i < games; i++) {
            String question = br.readLine();
            System.out.println(map.getOrDefault(question, "!"));
        }
    }
}
