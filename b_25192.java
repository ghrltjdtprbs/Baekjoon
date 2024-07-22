/*
* enter입력 이후에 중복된 아이디는 일반 채팅
* enter 이후 set에 아이디 넣기
* enter이 또 입력되었으면, 그동안 set에 있는 아이디 개수 센 다음 초기화
* */
import java.util.*;
public class b_25192 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        int answer = 0;
        Set<String> set = new HashSet<String>();

        for(int i = 0; i < count; i++){
            String message = sc.nextLine();
            if(message.equals("ENTER")){
                answer += set.size();
                set.clear();
            }else{
                set.add(message);
            }
        }

        answer += set.size();
        System.out.println(answer);

    }

}
