package day_4;
/*
map으로 저장(사전순으로 저장)
map 순회하면서 가장 많이 팔린책 조회
 */
import java.util.*;
public class b_1302 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String,Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int sell = 0;
        String answer = "";
        List<String> keys = new ArrayList<>(map.keySet());
        for(int i = 0; i < keys.size(); i++){
            if(sell < map.get(keys.get(i))){
                sell = map.get(keys.get(i));
                answer = keys.get(i);
            }
        }
        System.out.println(answer);
    }

}
