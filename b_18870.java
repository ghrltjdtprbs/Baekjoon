package day_8;
/*
- 예제를 배열로 만들고 입력
- 중복 제거하고 배열 복사
- 배열의 인덱스 출력
 */
import java.util.*;
import java.io.*;
public class b_18870 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ex = new int[n];
        int[] copy = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            ex[i] = Integer.parseInt(st.nextToken());
            copy[i] = ex[i];
        }
        Arrays.sort(copy);

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            int tmp = copy[i];
            if(!map.containsKey(tmp)){
                map.put(copy[i], count++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int tmp = ex[i];
            sb.append(map.get(tmp)).append(' ');
        }
        System.out.println(sb);
    }
}
