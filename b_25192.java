package day_4;
import java.util.*;
/*
- enter 입력 후 set으로 id 저장
 */
public class b_25192 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < N; i++){
            String id = sc.next();
            if(id.equals("ENTER")){
                answer += set.size();
                set.removeAll(set);
            }else{
                set.add(id);
            }
        }
        answer += set.size();
        System.out.println(answer);

    }

}
