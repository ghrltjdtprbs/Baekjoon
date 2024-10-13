package day_4;
import java.util.*;
public class b_1157 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        // 알파벳과 값을 저장할 map 생성 및 저장
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            map.put(current,map.getOrDefault(current,0) + 1);
        }

        // 키를 저장할 list 생성
        List<Character> keys = new ArrayList<>(map.keySet());
        boolean isDuplicated = false; // 중복 여부
        char answer_key = ' ';
        int answer = 0;

        for(int i = 0; i < keys.size(); i++){
            char tmp = keys.get(i);
            if(answer == map.get(tmp)){
                isDuplicated = true;
            }else{
                if(answer < map.get(tmp)){
                    answer = map.get(tmp);
                    answer_key = tmp;
                    isDuplicated = false;
                }
            }
        }

        if(isDuplicated){
            System.out.println("?");
        }else{
            System.out.println(answer_key);
        }

    }
}
