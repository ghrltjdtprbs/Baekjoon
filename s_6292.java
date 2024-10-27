package softeer;
import java.util.*;
import java.io.*;
public class s_6292 {
    static int MOD = 1000000007;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        long exponent = (long) time * 10;
        long answer = pow(exponent,up);
        System.out.println(answer);
    }

    private static long pow(long exp, int up){
        long answer = 1;
        long currentUp = up % MOD;;

        while(exp > 0){
            if(exp % 2 == 1){
                answer = (answer * currentUp) % MOD;
            }
            currentUp = (currentUp * currentUp) % MOD;
            exp /= 2;
        }
        return answer;
    }
}
