import java.util.*;

/*
 * 슬라이딩 윈도우 활용
 * */
public class b_2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 1;
        int end = 1;
        int answer = 0;
        int current = 0;

        while(end <= N){
            current += end;
            end++;
            while(current >= N){
                if(current == N) answer++;
                current -= start;
                start++;
            }
        }

        System.out.print(answer);
    }
}
